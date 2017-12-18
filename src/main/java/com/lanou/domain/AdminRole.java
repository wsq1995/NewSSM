package com.lanou.domain;

/**
 * Created by dllo on 17/12/8.
 */
public class AdminRole {
    private int adminId;
    private int roleId;

    public AdminRole() {
    }

    @Override
    public String toString() {
        return "AdminRole{" +
                "adminId=" + adminId +
                ", roleId=" + roleId +
                '}';
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public AdminRole(int adminId, int roleId) {
        this.adminId = adminId;
        this.roleId = roleId;
    }
}
