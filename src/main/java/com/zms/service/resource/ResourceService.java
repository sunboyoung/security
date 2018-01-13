package com.zms.service.resource;


import com.zms.pojo.resource.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;


public interface ResourceService {

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
     * @param permissions 权限集合
     * @return List
     * @author zms
     * @date 2017年12月25日下午4:08:47
     */
    List<Resource> findMenus(@Param("set") Set<String> permissions);

    /**
     * 根据用户权限得到子级菜单
     *
     * @param permissions 权限集合
     * @return List
     * @author zms
     * @date 2017年12月27日上午11:34:32
     */
    List<Resource> findChildrenMenu(@Param("set") Set<String> permissions);

    /**
     * 根据用户权限得到操作按钮
     *
     * @Author:zms
     * @Description:
     * @Date:2018/1/9 20:58
     */
    List<Resource> findChildrenButton(@Param("set") Set<String> permissions);
}
