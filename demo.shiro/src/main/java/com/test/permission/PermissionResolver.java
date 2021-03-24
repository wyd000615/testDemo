package com.test.permission;

import org.apache.shiro.authz.Permission;

public interface PermissionResolver {
    Permission resolvePermission(String var1);
}
