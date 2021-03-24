package com.test.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;

public class BitAndWildPermissionResolver implements PermissionResolver {
    @Override
    public Permission resolvePermission(String permissionString) {
        if(permissionString.startsWith("+")) {
            return (Permission) new BitPermission(permissionString);
        }
        return new WildcardPermission(permissionString);
    }
}
