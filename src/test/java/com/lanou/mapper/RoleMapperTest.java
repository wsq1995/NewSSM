package com.lanou.mapper;

import com.lanou.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SSM-mybatis.xml")
public class RoleMapperTest {

    @Resource
    private RoleMapper roleMapper;

    @Test
    public void saveRole() throws Exception {
        Role role = new Role("校长");
        roleMapper.addRole(role);
    }

    @Test
    public void findAll() throws Exception {
        roleMapper.findAll().forEach(System.out::println);
    }

    @Test
    public void findByName() throws Exception {
        Role role = new Role("管理员");
        roleMapper.findByName(role);
    }

    @Test
    public void updateRole() throws Exception {
        Role role = new Role();
        role.setRoleId(340);
        role.setRoleName("6666666");
        roleMapper.updateRole(role);
    }

    @Test
    public void deleteRole() throws Exception {
        Role role = new Role();
        role.setRoleId(339);
        roleMapper.deleteRole(role.getRoleId());
    }

    @Test
    public void findNameById() throws Exception {
        Role role = new Role();
        role.setRoleId(100);
        roleMapper.findNameById(role.getRoleId());
    }

    @Test
    public void roleModules() throws Exception {
        roleMapper.roleModules(200).forEach(System.out::println);
    }

    @Test
    public void modules() throws Exception {
        roleMapper.findModules().forEach(System.out::println);
    }

}