package com.zms.service.role;

import com.zms.pojo.role.Role;

public interface RoleService {

    /**
     * 创建角色
     *
     * @author zms
     * @date 2017年11月28日下午2:31:18
     */
    public int createRole(Role role);

    /**
     * 删除角色
     *
     * @author zms
     * @date 2017年11月28日下午2:31:42
     */
    public void deleteRole(Long roleId);


    /**
     * 关联角色-->权限信息
     *
     * @param
     * @return
     * @author zms
     * @date 2017年11月30日下午3:12:24
     */
    public void correlationPermissions(Long roleId, Long permissionId);


}
