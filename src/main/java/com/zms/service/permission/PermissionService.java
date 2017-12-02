package com.zms.service.permission;

import com.zms.pojo.permission.Permission;

public interface PermissionService {
    /**
     * 创建权限
     *
     * @param permission
     * @return int
     * @author zms
     * @date 2017年11月30日下午1:57:29
     */
    public int createPermission(Permission permission);

    /**
     * 删除权限
     *
     * @param permissionId
     * @author zms
     * @date 2017年11月30日下午1:57:48
     */
    public void deletePermission(Long permissionId);


}
