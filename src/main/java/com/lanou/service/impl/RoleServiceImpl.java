package com.lanou.service.impl;

import com.lanou.domain.Module;
import com.lanou.domain.Role;
import com.lanou.domain.RoleModule;
import com.lanou.mapper.RoleMapper;
import com.lanou.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/8.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public String addRole(Role role, Integer[] moduleId) {
        if (role.getRoleName().equals("") || role.getRoleName() == null) {
            return "nameNull";
        } else if (moduleId[0] == 0) {
            return "integerError";
        } else if ((roleMapper.findByName(role).size() != 0)) {
            return "nameExist";
        } else {
            roleMapper.addRole(role);
            for (int i = 0; i < moduleId.length; i++) {
                Integer integer = moduleId[i];
                roleMapper.addtModule(role.getRoleId(), integer);
            }
            return "add";
        }
    }

    /**
     * 修改角色
     * @param role
     */
    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    /**
     * 修改权限
     * @param roleModule
     */
    @Override
    public void updateRoleModule(RoleModule roleModule) {
        roleMapper.updateRoleModule(roleModule);
    }

    @Override
    public List<Role> findNameById(int roleId) {
        return roleMapper.findNameById(roleId);
    }

    /**
     * 删除角色
     * @param roleId
     */
    @Override
    public void deleteRole(int roleId) {
        roleMapper.deleteRole(roleId);
    }

    /**
     * 删除中间表
     * @param roleId
     */
    @Override
    public void deleteRoleModule(int roleId) {
        roleMapper.deleteRoleModule(roleId);
    }

    /**
     * 在循环着添加中间表的数据
     * @param module
     */
    @Override
    public void addRoleModule(int roleId,int[] module) {
        for (int i = 0; i < module.length; i++) {
            Integer integer = module[i];
            roleMapper.addRoleModule(roleId,integer);
        }
    }

    /**
     * 回显权限
     * @param roleId
     * @return
     */
    @Override
    public List<RoleModule> roleModules(int roleId) {
        return roleMapper.roleModules(roleId);
    }


    @Override
    public String validateDel(int roleId) {
        if (roleMapper.validateDel(roleId).size() > 0){
            return "false";
        }else {
            return "success";
        }
    }

    @Override
    public List<Module> findModules() {
        return roleMapper.findModules();
    }


}
