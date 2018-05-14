package com.zms.service.user;

import com.zms.pojo.resource.Resource;
import com.zms.pojo.user.User;
import com.zms.to.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface UserService {
    /**
     * 创建用户
     *
     * @author zms
     * @date 2017年11月27日下午5:50:38
     */
    public int createUser(User user);

    /**
     * 更新用户信息
     *
     * @author zms
     * @date 2017年11月27日下午5:50:53
     */
    public void updateUser(User user);

    /**
     * 删除用户信息
     *
     * @author zms
     * @date 2017年11月27日下午6:11:50
     */
    public void deleteUser(Long userId);

    /**
     * 添加用户--->角色信息
     *
     * @author zms
     * @date 2017年11月27日下午6:11:57
     */
    public void correlationRoles(Long userId, Long roleIds);

    /**
     * 删除用户--->角色信息
     *
     * @author zms
     * @date 2017年11月27日下午6:12:15
     */
    public void uncorrelationRoles(Long userId, Long roleIds);

    /**
     * 根据userId查出用户信息
     *
     * @author zms
     * @date 2017年11月27日下午6:12:30
     */
    User findOne(Long userId);

    /**
     * 根据用户名查询用户信息
     *
     * @author zms
     * @date 2017年11月27日下午6:12:50
     */
    User findByUsername(String userName);

    /**
     * 根据用户名查询角色信息
     *
     * @author zms
     * @date 2017年11月27日下午6:13:05
     */
    Set<String> findRoles(String userName);

    /**
     * 根据用户名查询权限信息
     *
     * @author zms
     * @date 2017年11月27日下午6:13:28
     */
    Set<String> findPermissions(String userName);

    /**
     * 获取所有的用户列表
     *
     * @return user
     */
    List<Map<String, Object>> getUserListByPage(Page page);

    /***********************新添加的方法**************************/
    /**
     * 根据用户名获取资源权限id
     *
     * @Author:zms
     * @Description:
     * @Date:2018/1/13 15:20
     */
    Set<Integer> findPermissionIdByUserName(String userName);

    /**
     * 根据资源权限id获取资源
     *
     * @Author:zms
     * @Description:
     * @Date:2018/1/13 15:24
     */
    List<Resource> findResourceByPermissionId(@Param("set") Set<Integer> permissionIds);

    /**
     * 通过父id获取资源列表
     *
     * @Author:zms
     * @Description:
     * @Date:2018/1/13 16:51
     */
    List<Resource> findResourceByParentId(Long parentId);
}

