package com.lanou.mapper;

import com.lanou.domain.Admin;
import com.lanou.domain.AdminRole;
import com.lanou.domain.Module;
import com.lanou.domain.RoleModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SSM-mybatis.xml")
public class AdminMapperTest {

    @Resource
    private AdminMapper adminMapper;

    @Test
    public void login() throws Exception {
        Admin admin = new Admin();
        adminMapper.login(admin);
    }

    @Test
    public void findAllAdmin() throws Exception {
        adminMapper.findAllAdmin(0).forEach(System.out::println);
    }

    @Test
    public void addAdmin() throws Exception {
        adminMapper.addAdmin(new Admin(8000, "UOUO", "5555", "UOUO", "6854236982", "6544641674@qq.com"));
    }

    @Test
    public void addAdminRole() throws Exception {
        adminMapper.addAdminRole(8000, 333);
    }

    @Test
    public void deleteAdmin() throws Exception {
        adminMapper.deleteAdminRole(8015);
        int i = adminMapper.deleteAdmin(8015);
        System.out.println(i);
    }


    @Test
    public void findAdminsById() throws Exception {
        adminMapper.findAdminsById(5000).forEach(System.out::println);
    }


    @Test
    public void findAdminRoleById() throws Exception {
        adminMapper.findAdminRoleById(5000).forEach(System.out::println);
    }

    @Test
    public void findAllModule() throws Exception {
        adminMapper.findAllModule(new Module()).forEach(System.out::println);
    }

    @Test
    public void findAllARM() throws Exception {
        adminMapper.findAllARM(-1, "%%").forEach(System.out::println);
    }

    @Test
    public void findroleIdByRoleName() throws Exception {
        adminMapper.findroleIdByRoleName("%理%").forEach(System.out::println);
    }

    @Test
    public void findAdminIdByRoleId() throws Exception {
        adminMapper.findAdminIdByRoleId(100).forEach(System.out::println);
    }

    @Test
    public void findRoleIdByModuleId() throws Exception {
        adminMapper.findRoleIdByModuleId(3).forEach(System.out::println);
    }
}