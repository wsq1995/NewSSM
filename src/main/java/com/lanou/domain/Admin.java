package com.lanou.domain;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/12/7.
 */
@Component
public class Admin {
    private int adminId;
    private String adminCode;
    private String Pwd;
    private String name;
    private String telephone;
    private String email;
    private Date enrolldate;

    private List<Role>roles;
    private List<Module>modules;
    private List<AdminRole>adminRoles;
    private List<RoleModule>roleModules;

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminCode='" + adminCode + '\'' +
                ", Pwd='" + Pwd + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrolldate='" + enrolldate + '\'' +
                ", roles=" + roles +
                ", modules=" + modules +
                ", adminRoles=" + adminRoles +
                ", roleModules=" + roleModules +
                '}';
    }

    public Admin() {
    }
    public Admin(Date enrolldate) {
        this.enrolldate = enrolldate;
    }

    public Admin(int adminId) {
        this.adminId = adminId;
    }

    public Admin(String adminCode, String pwd, String name,
                 String telephone, String email, Date enrolldate) {
        this.adminCode = adminCode;
        Pwd = pwd;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.enrolldate = enrolldate;
    }

    public Admin(int adminId, String adminCode, String pwd,
                 String name, String telephone, String email) {
        this.adminId = adminId;
        this.adminCode = adminCode;
        Pwd = pwd;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<AdminRole> getAdminRoles() {
        return adminRoles;
    }

    public void setAdminRoles(List<AdminRole> adminRoles) {
        this.adminRoles = adminRoles;
    }

    public List<RoleModule> getRoleModules() {
        return roleModules;
    }

    public void setRoleModules(List<RoleModule> roleModules) {
        this.roleModules = roleModules;
    }
}
