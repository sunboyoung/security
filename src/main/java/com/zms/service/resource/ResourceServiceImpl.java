package com.zms.service.resource;

import com.zms.dao.resource.ResourceDao;
import com.zms.pojo.resource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Transactional(rollbackFor = Error.class)
    public Resource createResource(Resource resource) {
        // TODO Auto-generated method stub
        return resourceDao.createResource(resource);
    }

    @Transactional(rollbackFor = Error.class)
    public Resource updateResource(Resource resource) {
        // TODO Auto-generated method stub
        return resourceDao.updateResource(resource);
    }

    @Transactional(rollbackFor = Error.class)
    public void deleteResource(Long resourceId) {
        // TODO Auto-generated method stub
        resourceDao.deleteResource(resourceId);
    }

    public Resource findOne(Long resourceId) {
        // TODO Auto-generated method stub
        return resourceDao.findOne(resourceId);
    }

    public List<Resource> findAll() {
        // TODO Auto-generated method stub
        return resourceDao.findAll();
    }

    public Set<String> findPermissions(Set<Long> resourceIds) {
        return resourceDao.findPermissions(resourceIds);
    }

    public List<Resource> findMenus(Set<String> permissions) {
        return resourceDao.findMenus(permissions);
    }

    public List<Resource> findChildrenMenu(Set<String> permissions) {
        return resourceDao.findChildrenMenu(permissions);
    }

}
