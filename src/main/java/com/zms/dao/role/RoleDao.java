package com.zms.dao.role;

import com.zms.pojo.role.Role;
import org.apache.ibatis.annotations.Param;

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


}