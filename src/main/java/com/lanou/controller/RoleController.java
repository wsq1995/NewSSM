package com.lanou.controller;

import com.lanou.domain.Module;
import com.lanou.domain.Role;
import com.lanou.domain.RoleModule;
import com.lanou.service.RoleService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/12/8.
 */
@Controller
public class RoleController {
    @Resource
    private RoleService roleService;

    //    以下只为跳转页面
    @RequestMapping("/role_list")
    @ResponseBody
    public String role_list() {
        return "success";
    }

    @RequestMapping("/role")
    public String role() {
        return "role/role_list";
    }
//    以上只为跳转页面

    @RequestMapping("/role_Add")
    public String add() {
        return "role/role_add";
    }

    //    查询所有角色
    @RequestMapping("/AdminFindAll")
    @ResponseBody
    public AjaxResult AdminFindAll() {
        return new AjaxResult(roleService.findAll());
    }

    //    添加角色
    @RequestMapping("/addRole")
    @ResponseBody
    public String addRole(Role role, Integer[] moduleId) {
        String s1 = roleService.addRole(role, moduleId);
        return s1;
    }

    @RequestMapping("/list")
    public String list() {
        return "role/role_list";
    }


    @RequestMapping("/update")
    @ResponseBody
    public String updateR(Role role, HttpSession session) {
        session.setAttribute("roleId", role.getRoleId());
        return "success";
    }

    //回显名字
    @RequestMapping(value = "/echoRole", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String echo(HttpSession session) {
        int roleId = (int) session.getAttribute("roleId");
        List<Role> ids = roleService.findNameById(roleId);
        return ids.get(0).getRoleName();
    }

    //回显权限
    @RequestMapping("/findModuleId")
    @ResponseBody
    public List<RoleModule> findModuleId(HttpSession session) {
        int roleId = (int) session.getAttribute("roleId");
        return roleService.roleModules(roleId);
    }

    //    跳转到修改页面
    @RequestMapping("/up")
    public String up() {
        return "role/role_mod";
    }

    //    修改角色
    @RequestMapping("/updateRole")
    @ResponseBody
    public Role updateRole(Role role, int[] module) {
        roleService.updateRole(role);
        roleService.deleteRoleModule(role.getRoleId());
        roleService.addRoleModule(role.getRoleId(), module);
        return role;
    }

    //    删除角色
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteRole(Role role) {
        String s = roleService.validateDel(role.getRoleId());
        if (s.equals("success")) {
            roleService.deleteRole(role.getRoleId());
            roleService.deleteRoleModule(role.getRoleId());
        }
        return s;
    }

    //    查找所有权限
    @RequestMapping("/findAllModule")
    @ResponseBody
    public List<Module> findModules() {
        List<Module> modules = roleService.findModules();
        return modules;
    }

}
