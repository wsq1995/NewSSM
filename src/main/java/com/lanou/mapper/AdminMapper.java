package com.lanou.mapper;

import com.lanou.domain.*;

import java.util.List;
import java.util.Set;

/**
 * Created by dllo on 17/12/7.
 */
public interface AdminMapper {

    //    查询名字
    List<Admin> login(Admin admin);

    //    查询所有管理员
    List<Admin> findAllAdmin(int adminId);

    //    添加管理员
    void addAdmin(Admin admin);

    //    添加管理员角色
    void addAdminRole(int adminId, Integer roleId);

    //    查询名字
    List<Admin> findAdminName();

    //    回显信息
    List<Admin> findAdminsById(int adminId);

    //    回显角色
    List<AdminRole> findAdminRoleById(int adminId);

    //    编辑管理员
    void updateA(Admin admin);

    //    删除管理员
    int deleteAdmin(int adminId);

    //    删除管理员角色
    void deleteAdminRole(int adminId);

    //    高级查询显示权限
    List<Module> findAllModule(Module module);

//    ===================高级查询==========================

    //通过权限id查询角色id
    List<RoleModule> findRoleIdByModuleId(int moduleId);

    //    通过角色id查询管理员id
    Set<AdminRole> findAdminIdByRoleId(int roleId);

    //    通过角色名字查询角色id
    List<Role> findroleIdByRoleName(String roleName);


//    ===================根据权限不同显示不同图标===========================

    List<Admin> findMouduleIdByAdminId(int adminId);

}
