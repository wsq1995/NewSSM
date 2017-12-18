package com.lanou.domain;

import java.util.List;

/**
 * Created by dllo on 17/12/8.
 */
public class Role {
    private int roleId;
    private String roleName;

    private Module module;
    private RoleModule roleModule;

    public Role() {
    }

    public Role(int roleId) {
        this.roleId = roleId;
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", module=" + module +
                ", roleModule=" + roleModule +
                '}';
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public RoleModule getRoleModule() {
        return roleModule;
    }

    public void setRoleModule(RoleModule roleModule) {
        this.roleModule = roleModule;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

//    public List<Module> getModules() {
//        return modules;
//    }
//
//    public void setModules(List<Module> modules) {
//        this.modules = modules;
//    }
//
//    public List<AdminRole> getAdminRoles() {
//        return adminRoles;
//    }
//
//    public void setAdminRoles(List<AdminRole> adminRoles) {
//        this.adminRoles = adminRoles;
//    }
//
//    public List<RoleModule> getRoleModules() {
//        return roleModules;
//    }
//
//    public void setRoleModules(List<RoleModule> roleModules) {
//        this.roleModules = roleModules;
//    }
}
