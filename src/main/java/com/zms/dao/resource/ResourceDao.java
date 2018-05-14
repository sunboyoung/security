package com.zms.dao.resource;


import com.zms.pojo.resource.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ResourceDao {


    /**
     * 创建资源
     *
     * @param resource
     * @return Resource
     * @author zms
     * @date 2017年12月22日下午3:46:41
     */
    public Resource createResource(Resource resource);

    /**
     * 更新资源
     *
     * @param resource
     * @return Resource
     * @author zms
     * @date 2017年12月22日下午3:46:56
     */
    public Resource updateResource(Resource resource);

    /**
     * 根据资源Id删除资源
     *
     * @param resourceId
     * @author zms
     * @date 2017年12月22日下午3:47:10
     */
    public void deleteResource(Long resourceId);

    /**
     * 根据资源id查找资源
     *
     * @param resourceId
     * @return Resource
     * @author zms
     * @date 2017年12月22日下午3:47:32
     */
    Resource findOne(Long resourceId);

    /**
     * 查询所有的资源
     *
     * @author zms
     * @date 2017年12月22日下午3:47:46
     */
    List<Resource> findAll();

    /**
     * 得到资源对应的权限字符串
     *
     * @param resourceIds
     * @return String
     * @author zms
     * @date 2017年12月25日下午4:08:32
     */
    Set<String> findPermissions(@Param("set") Set<Long> resourceIds);

    /**
     * 根据用户权限得到顶级菜单
     *
     * @param permissions
     * @return List
     * @author zms
     * @date 2017年12月25日下午4:08:47
     */
    List<Resource> findMenus(@Param("set") Set<String> permissions);

    /**
     * 根据用户权限得到子级菜单
     *
     * @param permissions
     * @return List
     * @author zms
     * @date 2017年12月27日上午11:33:36
     */
    List<Resource> findChildrenMenu(@Param("set") Set<String> permissions);

    /**
     * 根据用户权限得到按钮操作
     *
     * @Author:zms
     * @Description:
     * @Date:2018/1/9 21:07
     */
    List<Resource> findChildrenButton(@Param("set") Set<String> permissions);

    //*************************改版后的方法****************************//

    /**
     * 根据用户角色获取资源权限
     *
     * @Author:zms
     * @Description:
     * @Date:2018/1/13 14:48
     */
    List<Resource> findResourceByRole(@Param("set") Set<String> roles);


    /**
     * @Author:zms
     * @Description: 根据父id查询子资源
     * @Date:2018/4/12 17:47
     */
    List<Resource> findChildrenResource(Long id);
}
