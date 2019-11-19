package com.funtl.itoken.service.admin.controller;



import com.funtl.itoken.service.admin.BaseResult;
import com.funtl.itoken.service.admin.domain.User;
import com.funtl.itoken.service.admin.service.AdminService;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private AdminService adminService;


    @RequestMapping("/userlogin")
    public BaseResult login(String accountId, String name, Model model){

        //BaseResult baseResult=new BaseResult();
        System.out.println("accountId:"+accountId);
        System.out.println("name:"+name);

        BaseResult baseResult = checkLogin(accountId, name);
        if(baseResult!=null){
            return baseResult;
        }
        User login = adminService.login(accountId, name);
        if(login!=null){
            System.out.println("登录成功");
            model.addAttribute("message","登录成功，"+name);
            return BaseResult.ok(login);
        }else{
            return  BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("","登录失败")));
        }

    }

    private BaseResult checkLogin(String accountId,String name){
        BaseResult baseResult = new BaseResult();


        List<BaseResult.Error> errors = new ArrayList<>();
        if(StringUtils.isNotBlank(accountId) && StringUtils.isNotBlank(name)){
            return BaseResult.ok(null);
        }

        if(StringUtils.isBlank(accountId)){
            BaseResult.Error error = new BaseResult.Error();
            error.setField("accountId");
            error.setMessage("accountId不能为空");
            errors.add(error);
        }
        if(StringUtils.isBlank(name)){
            BaseResult.Error error = new BaseResult.Error();
            System.out.println();
            error.setField("name");
            error.setMessage("name不能为空");
            errors.add(error);
        }
        return BaseResult.notOk(errors);

    }
}
