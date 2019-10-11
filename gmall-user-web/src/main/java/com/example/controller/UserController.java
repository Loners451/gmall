package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.bean.UmsMember;
import com.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/9 16:09
 */
@RestController
public class UserController {

    @Reference
    UserService userService;

    @RequestMapping("/hello")
    public String index(){
        return  "hello user";
    }

    @RequestMapping("/getAllUser")
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }

}   
