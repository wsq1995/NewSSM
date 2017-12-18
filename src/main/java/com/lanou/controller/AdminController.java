package com.lanou.controller;

import com.lanou.domain.*;
import com.lanou.service.AdmainService;
import com.lanou.utils.AjaxResult;
import com.lanou.utils.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by dllo on 17/12/7.
 */
@Controller
public class AdminController {

    @Resource()
    private AdmainService admainService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(Admin admin, String verifyCode, HttpSession session) {
        session.setAttribute("adminCode", admin.getAdminCode());
        session.setAttribute("Pwd", admin.getPwd());
        String error = admainService.login(admin, verifyCode);
        return error;
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    //    验证码验证
    @RequestMapping("/getVerifyCode")
    public void getVerifycode(HttpSession session, HttpServletResponse response) throws IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        session.setAttribute("verifyCode", verifyCode.getText());
        OutputStream os = response.getOutputStream();
        VerifyCode.output(image, os);
    }

    //    转到查询所有管理员界面
    @RequestMapping("/admin_list")
    public String admin_list() {
        return "admin/admin_list";
    }

    //    查询所有管理员
    @RequestMapping("/findAllAdmin")
    @ResponseBody
    public AjaxResult findAllAdmin() {
        return new AjaxResult(admainService.findAllAdmin());
    }

    //    跳到添加管理员页面
    @RequestMapping("/adminAdd")
    public String adminAdd() {
        return "admin/admin_add";
    }

    @RequestMapping("/addAdmin")
    @ResponseBody
    public String addAdmin(Admin admin, String rePwd, Integer[] roleId) {
        String s2 = admainService.addAdmin(admin, rePwd, roleId);
        return s2;
    }

    //    跳到编辑管理员界面
    @RequestMapping("/updateAdmin")
    public String updataAdmin() {
        return "admin/admin_mod";
    }

    @RequestMapping("/upd")
    @ResponseBody
    public String updateR(Admin admin, HttpSession session) {
        session.setAttribute("adminId", admin.getAdminId());
        return "success";
    }

    //    回显信息
    @RequestMapping("/echo")
    @ResponseBody
    public List<Admin> echo(HttpSession session) {
        int adminId = (int) session.getAttribute("adminId");
        List<Admin> adminsById = admainService.findAdminsById(adminId);
        return adminsById;
    }

    //    回显角色
    @RequestMapping("/findAdminRoleId")
    @ResponseBody
    public List<AdminRole> findAdminRoleId(HttpSession session) {
        int adminId = (int) session.getAttribute("adminId");
        return admainService.findAdminRoleById(adminId);
    }

    //    编辑管理员
    @RequestMapping("/updateA")
    @ResponseBody
    public String updateA(Admin admin, Integer[] role) {
        String s3 = admainService.updateA(admin, role);
        return s3;
    }

    //    删除管理员
    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public int deleteAdmin(Admin admin) {
        admainService.deleteAdminRole(admin.getAdminId());
        int result = admainService.deleteAdmin(admin.getAdminId());
        return result;
    }

    //退出
    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("adminCode");
        session.removeAttribute("Pwd");
        return "login";
    }

    //    高级查询显示下拉框
    @RequestMapping("/queryModule")
    @ResponseBody
    public List<Module> findAllModule(Module module) {
        List<Module> allModule = admainService.findAllModule(module);
        return allModule;
    }

    //    高级查询
    @RequestMapping(value = "/findAllARM")
    @ResponseBody
    public AjaxResult findAllARM(String roleName,int moduleId) {
        try {
            roleName = new String(roleName.getBytes("8859_1"),"utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new AjaxResult(admainService.findAllARM(moduleId,roleName));
    }

}
