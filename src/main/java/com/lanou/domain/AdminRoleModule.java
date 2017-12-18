package com.lanou.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/12/9.
 */
public class AdminRoleModule {
//    private Admin admin;
//    private List<Module> modules;
//    private List<Role>roles;
    private int adminId;
    private String adminCode;
    private String Pwd;
    private String name;
    private String telephone;
    private String email;
    private Date enrolldate;
//    private int roleId;
//    private int moduleId;
//    private String roleName;
//    private String moduleName;
    private AdminRole adminRole;
    private Role role;
    private Module module;


    public AdminRoleModule() {
    }

    public AdminRoleModule(int adminId, String adminCode, String pwd, String name, String telephone, String email, Date enrolldate, AdminRole adminRole, Role role, Module module) {
        this.adminId = adminId;
        this.adminCode = adminCode;
        Pwd = pwd;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.enrolldate = enrolldate;
        this.adminRole = adminRole;
        this.role = role;
        this.module = module;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Date enrolldate) {
        this.enrolldate = enrolldate;
    }

    public AdminRole getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(AdminRole adminRole) {
        this.adminRole = adminRole;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "AdminRoleModule{" +
                "adminId=" + adminId +
                ", adminCode='" + adminCode + '\'' +
                ", Pwd='" + Pwd + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrolldate=" + enrolldate +
                ", adminRole=" + adminRole +
                ", role=" + role +
                ", module=" + module +
                '}';
    }
}
