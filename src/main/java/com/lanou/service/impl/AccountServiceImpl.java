package com.lanou.service.impl;

import com.lanou.domain.Account;
import com.lanou.domain.Fee;
import com.lanou.mapper.AccountMapper;
import com.lanou.service.AccountService;
import com.lanou.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/23.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;
    @Override
    public PageBean<Account> findAllAcount(int pageNum) {
        List<Account> allAccount = accountMapper.findAllAccount();
        PageBean<Account> pageBean = new PageBean<Account>(pageNum, 5, allAccount.size());

        List<Account> list = new ArrayList<>();

        int end = pageBean.getStartIndex() + 5;

        if (end >= pageBean.getTotalRecord()) {

            end = pageBean.getTotalRecord();
        }

        int start = pageBean.getStartIndex();

        if (start > pageBean.getTotalRecord()) {

            start = start - 5;
        }
        for (int i = start; i < end; i++) {

            list.add(allAccount.get(i));
        }
        pageBean.setData(list);

        return pageBean;
    }
}
