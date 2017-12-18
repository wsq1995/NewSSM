package com.lanou.domain;

/**
 * Created by dllo on 17/12/8.
 */
public class RoleModule {
    private int roleId;
    private int moduleId;
    private Module module;
    private Role role;

    public RoleModule() {
    }

    public RoleModule(int roleId) {
        this.roleId = roleId;
    }

    public RoleModule(int roleId, int moduleId) {
        this.roleId = roleId;
        this.moduleId = moduleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "RoleModule{" +
                "roleId=" + roleId +
                ", moduleId=" + moduleId +
                '}';
    }
}
