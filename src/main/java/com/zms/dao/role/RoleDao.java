package com.zms.dao.role;

import com.zms.pojo.role.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    /**
     * 创建角色
     *
     * @author zms
     * @date 2017年11月28日下午2:34:38
     */
    public int createRole(Role role);

    /**
     * 删除角色
     *
     * @author zms
     * @date 2017年11月28日下午2:34:46
     */
    public void deleteRole(Long roleId);

    /**
     * 关联角色-->权限
     *
     * @param roleId
     * @param permissionId
     * @author zms
     * @date 2017年11月30日下午3:07:13
     */

    public void correlationPermissions(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    /**
     * 根据角色编号得到角色标识符列表
     *
     * @param roleIds
     * @return String
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号得到权限字符串列表
     *
     * @param roleIds
     * @return String
     */
    Set<String> findPermissions(Long[] roleIds);

    /**
     * 获取角色列表
     *
     * @return role
     */
    List<Role> getRoleList();
}