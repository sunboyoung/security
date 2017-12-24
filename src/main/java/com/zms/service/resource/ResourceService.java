package com.zms.service.resource;


import com.zms.pojo.resource.Resource;

import java.util.List;

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

}
