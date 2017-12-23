package com.lanou.controller;

import com.lanou.domain.Account;
import com.lanou.service.AccountService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/23.
 */
@Controller
public class AccountController {

    @Resource
    private AccountService accountService;
    //    转到财务界面
    @RequestMapping("/account_list")
    public String account_list() {
        return "account/account_list";
    }
    
//    查找所有财务
    @RequestMapping("/findAllAccount")
    public AjaxResult findAllAccount(int pageNum){
        return new AjaxResult(accountService.findAllAcount(pageNum));
    }

}
