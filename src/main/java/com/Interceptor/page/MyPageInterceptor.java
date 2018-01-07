package com.Interceptor.page;

import com.zms.to.page.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import javax.security.auth.login.Configuration;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;


/**
 * @Intercepts 说明是一个拦截器
 * @Signature 拦截器的签名
 * type 拦截的类型 四大对象之一( Executor,ResultSetHandler,ParameterHandler,StatementHandler)
 * method 拦截的方法
 * args 参数
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class MyPageInterceptor implements Interceptor {

    //    默认页码
    private Integer defaultPageNo;
    //    默认每页显示条数
    private Integer defaultPageSize;
    //    是否启用分页功能 默认为启用
    private boolean defaultUseFlag;
    //    检测当前页码的合法性（大于最大页码或小于最小页码都不合法） 默认为合法
    private boolean defaultCheckFlag;


    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = getActuralHandlerObject(invocation);
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        String sql = statementHandler.getBoundSql().getSql();
        // 检测未通过，不是select语句
        if (!checkIsSelectFalg(sql)) {
            return invocation.proceed();
        }
        BoundSql boundSql = statementHandler.getBoundSql();
        Object paramObject = boundSql.getParameterObject();
        if (paramObject == null) {
            return invocation.proceed();
        }
        Page page = getPageParam(paramObject);
        if (page == null) {
            return invocation.proceed();
        }
        Integer pageNo = page.getPageNo() == null ? defaultPageNo : page.getPageNo();

        Integer pageSize = page.getPageSize() == null ? defaultPageSize : page.getPageSize();

        Boolean useFlag = page.isDefaultUseFlag() == null ? defaultUseFlag : page.isDefaultUseFlag();

        Boolean checkFlag = page.isDefaultCheckFlag() == null ? defaultCheckFlag : page.isDefaultCheckFlag();

        //不使用分页功能
        if (!useFlag) {
            return invocation.proceed();
        }
        //获取查询的数据总数
        int totalCount = getTotalPageNo(invocation, metaStatementHandler, boundSql);
        //将动态获取到的分页参数回填到pageParam中
        setTotltToParam(page, totalCount, pageSize);
        //检查当前页码的有效性
        checkPage(checkFlag, pageNo, page.getTotalPageNo());
        //修改sql
        return updateSqlLimit(invocation, metaStatementHandler, boundSql, pageNo, pageSize);
    }


    /**
     * 从代理对象中分离出真实statementHandler对象,非代理对象
     *
     * @param invocation
     * @autor zms
     */
    private StatementHandler getActuralHandlerObject(Invocation invocation) {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        Object object = null;
        //分离代理对象链，目标可能被多个拦截器拦截，分离出最原始的目标类
        while (metaStatementHandler.hasGetter("h")) {
            object = metaStatementHandler.getValue("h");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }
        if (object == null) {
            return statementHandler;
        }
        return (StatementHandler) object;
    }


    /**
     * @Author:zms
     * @Description:判断是否是查询方法 只有查询方法用到分页
     * @Date:2018/1/1 18:05
     */

    private boolean checkIsSelectFalg(String sql) {
        String trimSql = sql.trim();
        int index = trimSql.toLowerCase().indexOf("select");
        return index == 0;
    }

    /**
     * @Author:zms
     * @Description: 获取分页的参数
     * 参数可以通过map，@param注解进行参数传递。或者请求pojo继承自PageParam  将PageParam中的分页数据放进去
     * @Date:2018/1/1 18:16
     */
    private Page getPageParam(Object paramerObject) {
        if (paramerObject == null) {
            return null;
        }
        Page page = null;
        //通过map和@param注解将PageParam参数传递进来，pojo继承自PageParam不推荐使用  这里从参数中提取出传递进来的pojo继承自PageParam
        //首先处理传递进来的是map对象和通过注解方式传值的情况，从中提取出PageParam,循环获取map中的键值对，取出PageParam对象
        if (paramerObject instanceof Map) {
            Map<String, Object> params = (Map<String, Object>) paramerObject;
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() instanceof Page) {
                    return (Page) entry.getValue();
                }
            }
        } else if (paramerObject instanceof Page) {
            //继承方式 pojo继承自PageParam 只取出我们希望得到的分页参数

            page = (Page) paramerObject;

        }
        return page;
    }

    /**
     * @Author:zms
     * @Description: 获取当前sql查询的记录总数
     * @Date:2018/1/1 18:41
     */
    private int getTotalPageNo(Invocation invocation, MetaObject metaStatementHandler, BoundSql boundSql) {

        //获取mapper文件中当前查询语句的配置信息
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");

        //获取所有配置Configuration
        org.apache.ibatis.session.Configuration configuration = mappedStatement.getConfiguration();

        //获取当前查询语句的sql
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");

        //将sql改写成统计记录数的sql语句,这里是mysql的改写语句,将第一次查询结果作为第二次查询的表
        String countSql = "select count(*) as total from (" + sql + ") $_paging";

        //获取connection连接对象，用于执行countsql语句
        Connection conn = (Connection) invocation.getArgs()[0];

        PreparedStatement ps = null;

        int total = 0;

        try {
            //预编译统计总记录数的sql
            ps = conn.prepareStatement(countSql);
            //构建统计总记录数的BoundSql
            BoundSql countBoundSql = new BoundSql(configuration, countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
            //构建ParameterHandler，用于设置统计sql的参数
            ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);
            //设置总数sql的参数
            parameterHandler.setParameters(ps);
            //执行查询语句
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //与countSql中设置的别名对应
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return total;
    }

    /**
     * @Author:zms
     * @Description: 验证当前页码的有效性
     * @Date:2018/1/1 18:33
     */
    private void checkPage(boolean checkFlag, Integer pageNo, Integer totalPageNo) throws Exception {
        if (checkFlag) {
            if (pageNo > totalPageNo) {
                throw new Exception("查询失败，查询页码" + pageNo + "大于总页数" + totalPageNo);
            }
        }
    }


    //获取代理对象
    public Object plugin(Object o) {
        //生成object对象的动态代理对象
        return Plugin.wrap(o, this);
    }

    /**
     * @Author:zms
     * @Description:设置数据总数以及总页数
     * @Date:2018/1/1 18:52
     */
    private void setTotltToParam(Page page, int totalCount, int pageSize) {
        page.setTotalCount(totalCount);
        page.setTotalPageNo(totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1);
    }


    private Object updateSqlLimit(Invocation invocation, MetaObject metaStatementHandler, BoundSql boundSql, int pageNo, int pageSize) throws InvocationTargetException, IllegalAccessException, SQLException {
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        //构建新的分页sql语句
        String limitSql = "select * from (" + sql + ") $_paging_table limit ?,?";
        //修改当前要执行的sql语句
        metaStatementHandler.setValue("delegate.boundSql.sql", limitSql);
        //相当于调用prepare方法，预编译sql并且加入参数，但是少了分页的两个参数，它返回一个PreparedStatement对象
        PreparedStatement ps = (PreparedStatement) invocation.proceed();
        //获取占位符个数 即是传参的个数 当下传入pageNo,pageSize 即是两个占位符
        int currentSize = ps.getParameterMetaData().getParameterCount();
        //设置与分页相关的两个参数
        ps.setInt(currentSize - 1, (pageNo == 0 ? pageNo : pageNo - 1) * pageSize);
        ps.setInt(currentSize, pageSize);
        return ps;
    }


    /**
     * @Author:zms
     * @Description: 设置代理对象的参数
     * @Date:2018/1/1 19:18
     */
    public void setProperties(Properties properties) {
        //如果项目中分页的pageSize是统一的，也可以在这里统一配置和获取，这样就不用每次请求都传递pageSize参数了。参数是在配置拦截器时配置的。
       /* String limit1 = properties.getProperty("limit", "10");
        this.pageSize = Integer.valueOf(limit1);
        this.dbType = properties.getProperty("dbType", "mysql");*/
        String strDefaultPage = properties.getProperty("default.pageNo");
        String strDefaultPageSize = properties.getProperty("default.pageSize");
        String strDefaultUseFlag = properties.getProperty("default.useFlag");
        String strDefaultCheckFlag = properties.getProperty("default.checkFlag");
        this.defaultPageNo = Integer.valueOf(strDefaultPage);
        this.defaultPageSize = Integer.valueOf(strDefaultPageSize);
        this.defaultUseFlag = Boolean.valueOf(strDefaultUseFlag);
        this.defaultCheckFlag = Boolean.valueOf(strDefaultCheckFlag);
    }
}