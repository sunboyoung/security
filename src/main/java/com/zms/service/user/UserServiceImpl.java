package com.zms.service.user;

import com.passwordHelper.PasswordHelper;
import com.zms.dao.role.RoleDao;
import com.zms.dao.user.UserDao;
import com.zms.pojo.resource.Resource;
import com.zms.pojo.role.Role;
import com.zms.pojo.user.User;
import com.zms.to.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;
    @Transactional(rollbackFor = Error.class)
    public int createUser(User user) {
        // TODO Auto-generated method stub
        PasswordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    @Transactional(rollbackFor = Error.class)
    public void updateUser(User user) {
        // TODO Auto-generated method stub
        userDao.updateUser(user);
    }

    @Transactional(rollbackFor = Error.class)
    public void deleteUser(Long userId) {
        // TODO Auto-generated method stub
        userDao.deleteUser(userId);
    }

    @Transactional(rollbackFor = Error.class)
    public void correlationRoles(Long userId, Long roleIds) {
        // TODO Auto-generated method stub
        userDao.correlationRoles(userId, roleIds);
    }

    @Transactional(rollbackFor = Error.class)
    public void uncorrelationRoles(Long userId, Long roleIds) {
        // TODO Auto-generated method stub
        userDao.uncorrelationRoles(userId, roleIds);
    }

    public User findOne(Long userId) {
        // TODO Auto-generated method stub
        return userDao.findOne(userId);
    }

    public User findByUsername(String userName) {
        // TODO Auto-generated method stub
        return userDao.findByUsername(userName);
    }

    public Set<String> findRoles(String userName) {
        // TODO Auto-generated method stub
        return userDao.findRoles(userName);
    }

    public Set<String> findPermissions(String userName) {
        // TODO Auto-generated method stub
        return userDao.findPermissions(userName);
    }

    public List<Map<String, Object>> getUserListByPage(Page page) {
        return userDao.getUserListByPage(page);
    }

    public Set<Integer> findPermissionIdByUserName(String userName) {
        return userDao.findPermissionIdByUserName(userName);
    }

    public List<Resource> findResourceByPermissionId(Set<Integer> permissionIds) {
        return userDao.findResourceByPermissionId(permissionIds);
    }

    public List<Resource> findResourceByParentId(Long parentId) {
        return userDao.findResourceByParentId(parentId);
    }


}
