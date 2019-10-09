package com.example.service.impl;

import com.example.bean.UmsMember;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/9 16:13
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUser() {
      List<UmsMember> umlist=userMapper.selectAll();
        return umlist;
    }
}
