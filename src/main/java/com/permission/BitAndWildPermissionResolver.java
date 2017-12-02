package com.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * @author zms
 * 
 */
public class BitAndWildPermissionResolver implements PermissionResolver {


    public Permission resolvePermission(String permissionString) {
        if(permissionString.startsWith("+")) {
            return new BitPermission(permissionString);
        }
        return new WildcardPermission(permissionString);
    }
}