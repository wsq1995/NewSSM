package com.lanou.service;

import com.lanou.domain.Admin;
import com.lanou.domain.AdminRole;
import com.lanou.domain.AdminRoleModule;
import com.lanou.domain.Module;

import java.util.List;

/**
 * Created by dllo on 17/12/7.
 */
public interface AdmainService {

    //    查询所有
    String login(Admin admin, String verifyCode);

    //    查询所有管理员
    List<Admin> findAllAdmin();

    //    添加管理员
    String addAdmin(Admin admin, String rePwd, Integer[] roleId);

    //    回显信息
    List<Admin> findAdminsById(int adminId);

    //    回显角色
    List<AdminRole> findAdminRoleById(int adminId);

    //    编辑管理员
    String updateA(Admin admin, Integer[] role);

    //    删除管理员
    int deleteAdmin(int adminId);

    //    删除管理员角色
    void deleteAdminRole(int adminId);

    //    高级查询
    List<Module> findAllModule(Module module);

    //    五个表的高级查询
    List<Admin> findAllARM(int moduleId,String roleName);

}
