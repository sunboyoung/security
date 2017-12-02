package com.zms.service.role;

import com.zms.dao.role.RoleDao;
import com.zms.pojo.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Transactional(rollbackFor = Error.class)
    public int createRole(Role role) {
        // TODO Auto-generated method stub
        return roleDao.createRole(role);
    }

    @Transactional(rollbackFor = Error.class)
    public void deleteRole(Long roleId) {
        // TODO Auto-generated method stub
        roleDao.deleteRole(roleId);
    }

    public void correlationPermissions(Long roleId, Long permissionId) {
        // TODO Auto-generated method stub
        roleDao.correlationPermissions(roleId, permissionId);
    }
}
