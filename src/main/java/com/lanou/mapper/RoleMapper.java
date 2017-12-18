package com.lanou.mapper;

import com.lanou.domain.Module;
import com.lanou.domain.Role;
import com.lanou.domain.RoleModule;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/12/8.
 */
public interface RoleMapper {

    /**
     * 查询所有角色
     *
     * @return
     */
    List<Role> findAll();

    /**
     * 添加角色
     *
     * @param role
     */
    void addRole(Role role);

    void addtModule(int roleId, Integer moduleId);

    /**
     * 根据名字查找信息
     *
     * @param role
     * @return
     */
    List findByName(Role role);

    /**
     * 编辑角色
     *
     * @param role
     */
    void updateRole(Role role);

    /**
     * 编辑权限
     *
     * @param roleModule
     */
    void updateRoleModule(RoleModule roleModule);

    /**
     * 根据id找名字
     *
     * @param roleId
     * @return
     */
    List<Role> findNameById(int roleId);

    /**
     * 根据id删除角色
     *
     * @param roleId
     */
    void deleteRole(int roleId);

    /**
     * 根据id删除角色权限
     *
     * @param roleId
     */
    void deleteRoleModule(int roleId);

    //    验证删除
    List validateDel(int roleId);

    //    在重新添加角色权限
    void addRoleModule(int roleId, int module);

    //    回显权限
    List<RoleModule> roleModules(int roleId);

    //    查找所有权限
    List<Module> findModules();
}
