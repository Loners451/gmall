package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.bean.UmsMember;
import com.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/29 16:44
 */
@Controller
public class PassportController {

    @Reference
    UserService userService;


    @RequestMapping("verify")
    @ResponseBody
    public String verify(String token){

        // 通过jwt校验token真假

        return "success";
    }



    @RequestMapping("/login")
    @ResponseBody
    public String login(UmsMember umsMember){


        // 调用用户服务验证用户名和密码
        UmsMember umsMemberLogin = userService.login(umsMember);

        if (umsMemberLogin != null) {
            // 登录成功
        }else {
            // 登录失败
        }

        return  "token";
    }


    @RequestMapping("/index")
    public String index(String ReturnUrl, ModelMap modelMap){

        modelMap.put("ReturnUrl",ReturnUrl );

        return  "index";
    }
}   
