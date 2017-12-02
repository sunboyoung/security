package com.zms.service.permission;

import com.zms.dao.permission.PermissionDao;
import com.zms.pojo.permission.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Transactional(rollbackFor = Error.class)
    public int createPermission(Permission permission) {
        // TODO Auto-generated method stub
        return permissionDao.createPermission(permission);
    }

    @Transactional(rollbackFor = Error.class)
    public void deletePermission(Long permissionId) {
        // TODO Auto-generated method stub
        permissionDao.deletePermission(permissionId);
    }

}
