package com.lanou.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SSM-mybatis.xml")
public class AccountMapperTest {

    @Resource
    private AccountMapper accountMapper;

    @Test
    public void findAllAccount() throws Exception {
        accountMapper.findAllAccount().forEach(System.out::println);
    }

}