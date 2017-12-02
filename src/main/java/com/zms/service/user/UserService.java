package com.zms.service.user;

import com.zms.pojo.user.User;

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

}

