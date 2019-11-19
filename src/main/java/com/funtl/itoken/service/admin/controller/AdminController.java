package com.funtl.itoken.service.admin.controller;


import com.funtl.itoken.service.admin.domain.User;
import com.funtl.itoken.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping("/user")
    public String user(Model model,String accountId, String name){
        User user =new User();
        user.setAccountId(accountId);
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(System.currentTimeMillis());
        user.setName(name);
        user.setToken("11111111111111");
        user.setAvatarUrl("https://avatars0.githubusercontent.com/u/52448034?v=4");
        adminService.register(user);
        return "user";
    }

    @RequestMapping("/login")
    public String login(Model model, String accountId, String name){
        User login = adminService.login(accountId, name);
        if(login!=null){
            System.out.println("登录成功");
            model.addAttribute("message","登录成功，"+name);
        }
        return "login";
    }
}
