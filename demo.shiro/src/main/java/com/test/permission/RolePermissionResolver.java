package com.test.permission;

import org.apache.shiro.authz.Permission;

import java.util.Collection;

public interface RolePermissionResolver {
    Collection<Permission> resolvePermissionsInRole(String var1);

}
