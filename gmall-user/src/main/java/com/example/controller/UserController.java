package com.example.controller;

import com.example.bean.UmsMember;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/9 16:09
 */
@RestController
public class UserController {

    @Autowired
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
