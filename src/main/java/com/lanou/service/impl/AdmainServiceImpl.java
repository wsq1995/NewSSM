package com.lanou.service.impl;

import com.lanou.domain.*;
import com.lanou.mapper.AdminMapper;
import com.lanou.service.AdmainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by dllo on 17/12/7.
 */
@Service
public class AdmainServiceImpl implements AdmainService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private HttpSession session;
    private Set<AdminRole> ars1;
    private Set<AdminRole> ars2;

    @Override
    public String login(Admin admin, String verifyCode) {
        String adminCode = admin.getAdminCode();
        String pwd = admin.getPwd();
        String newVerifyCode = (String) session.getAttribute("verifyCode");
        List<Admin> login = adminMapper.login(admin);
        if (login.size() != 0){
            session.setAttribute("login",login.get(0));
        }
        if (adminCode == null || adminCode.equals("") && adminCode.equals(admin.getAdminCode())) {
            return "nameError";
        } else if (pwd == null || pwd.equals("") && pwd.equals(admin.getPwd())) {
            return "PwdError";
        } else if (!verifyCode.equalsIgnoreCase(newVerifyCode) && newVerifyCode != null && !newVerifyCode.equals("")) {
            return "codeError";
        } else if (login.size() == 0) {
            return "adminError";
        }
        return "index";
    }

    @Override
    public List<Admin> findAllAdmin() {
        return adminMapper.findAllAdmin(0);
    }

    //    添加管理员
    @Override
    public String addAdmin(Admin admin, String rePwd, Integer[] roleId) {
        if (admin.getName().equals("") || admin.getName() == null) {
            return "nameNull";
        } else if (admin.getName().length() >= 20 || !Pattern.compile("[a-zA-Z]{3,8}").matcher(admin.getName()).matches()) {
            return "nameLength";
        } else if (admin.getAdminCode().equals("") || admin.getAdminCode() == null) {
            return "codeNull";
        } else if (!rePwd.equals(admin.getPwd()) || rePwd.equals("") || rePwd == null) {
            return "rePwdNull";
        } else if (admin.getPwd().equals("") || admin.getPwd() == null) {
            return "pwdError";
        } else if (adminMapper.findAdminName().size() != 0) {
            return "nameExit";
        } else if (!Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8})|(0\\\\d{2}-\\\\d{8})|(0\\\\d{3}-\\\\d{7})$").matcher(admin.getTelephone()).matches()) {
            return "phoneError";
        } else if (!Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$").matcher(admin.getEmail()).matches()) {
            return "emailError";
        } else if (roleId[0] == 0) {
            return "roleError";
        } else {
            Admin admin1 = new Admin(new Date());
            admin.setEnrolldate(admin1.getEnrolldate());
            adminMapper.addAdmin(admin);
            for (int i = 0; i < roleId.length; i++) {
                Integer integer = roleId[i];
                adminMapper.addAdminRole(admin.getAdminId(), integer);
            }
            return "add";
        }
    }

    @Override
    public List<Admin> findAdminsById(int adminId) {
        return adminMapper.findAdminsById(adminId);
    }

    @Override
    public List<AdminRole> findAdminRoleById(int adminId) {
        return adminMapper.findAdminRoleById(adminId);
    }


    @Override
    public int deleteAdmin(int adminId) {
        return adminMapper.deleteAdmin(adminId);
    }

    @Override
    public void deleteAdminRole(int adminId) {
        adminMapper.deleteAdminRole(adminId);
    }

    @Override
    public List<Module> findAllModule(Module module) {
        return adminMapper.findAllModule(module);
    }

    //    高级查询
    @Override
    public List<Admin> findAllARM(int moduleId, String roleName) {
//        set会自动去重
        Set<Integer> adminIds = new HashSet<>();
        List<Admin> admin = new ArrayList<>();
        if (moduleId == -1 && roleName.equals("")) {
            admin = adminMapper.findAllAdmin(0);
        } else if (moduleId != -1 && !roleName.equals("")) {
            List<RoleModule> rms = adminMapper.findRoleIdByModuleId(moduleId);
            for (RoleModule rm : rms) {
                ars1 = adminMapper.findAdminIdByRoleId(rm.getRoleId());
            }
            List<Role> roles = adminMapper.findroleIdByRoleName('%' + roleName + '%');
            for (Role role : roles) {
                ars2 = adminMapper.findAdminIdByRoleId(role.getRoleId());
            }
            for (AdminRole a1 : ars1) {
                for (AdminRole a2 : ars2) {
                    if (a2.getAdminId() == a1.getAdminId()) {
                        adminIds.add(a2.getAdminId());
                    }
                }
            }
            for (Integer adminId : adminIds) {
                admin.addAll(adminMapper.findAllAdmin(adminId));
            }
        } else {
            if (moduleId != -1) {
                List<RoleModule> rms = adminMapper.findRoleIdByModuleId(moduleId);
                for (RoleModule rm : rms) {
                    Set<AdminRole> ars = adminMapper.findAdminIdByRoleId(rm.getRoleId());
                    for (AdminRole ar : ars) {
                        adminIds.add(ar.getAdminId());
                    }
                }
            }
//            如果角色名字不选,就执行查询所有的管理员,
//            如果选择,就先通过角色名字查找角色id,遍历,然后执行通过角色id查询管理员id,
//            遍历集合,将所有的管理员id添加到管理员id集合中,就是将所有集合装到一个管理员的大集合中
            if (!roleName.equals("")) {
                List<Role> roles = adminMapper.findroleIdByRoleName('%' + roleName + '%');
                for (Role role : roles) {
                    Set<AdminRole> ars = adminMapper.findAdminIdByRoleId(role.getRoleId());
                    for (AdminRole ar : ars) {
                        adminIds.add(ar.getAdminId());
                    }
                }
            }
            for (Integer adminId : adminIds) {
                admin.addAll(adminMapper.findAllAdmin(adminId));
            }
        }
        //给前台返回所有数据
        return admin;
    }

    @Override
    public String updateA(Admin admin, Integer[] role) {
        if (admin.getName().equals("") || admin.getName() == null) {
            return "nameNull";
        } else if (admin.getName().length() >= 20 || !Pattern.compile("[a-zA-Z]{3,8}").matcher(admin.getName()).matches()) {
            return "nameLength";
        } else if (adminMapper.findAdminName().size() != 0) {
            return "nameExit";
        } else if (!Pattern.compile("^1[3|4|5|7|8][0-9]{9}$").matcher(admin.getTelephone()).matches()) {
            return "phoneError";
        } else if (!Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$").matcher(admin.getEmail()).matches()) {
            return "emailError";
        } else if (role[0] == 0) {
            return "roleError";
        } else {
            adminMapper.updateA(admin);
            adminMapper.deleteAdminRole(admin.getAdminId());
            for (int i = 0; i < role.length; i++) {
                Integer integer = role[i];
                adminMapper.addAdminRole(admin.getAdminId(), integer);
            }
            return "add";
        }
    }

    @Override
    public List<Admin> findModuleIdByAdminId(int adminId) {
        return adminMapper.findMouduleIdByAdminId(adminId);
    }

}
