package com.lanou.mapper;

import com.lanou.domain.Account;
import com.lanou.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/12/23.
 */
public interface AccountMapper {
    List<Account> findAllAccount();
}
