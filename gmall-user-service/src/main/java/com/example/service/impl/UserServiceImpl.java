package com.example.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.example.mapper.UserMapper;
import com.example.util.RedisUtil;
import com.gmall.bean.UmsMember;
import com.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;


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


    @Autowired
    RedisUtil redisUtil;

    @Override
    public List<UmsMember> getAllUser() {
      List<UmsMember> umlist=userMapper.selectAll();
        return umlist;
    }

    @Override
    public UmsMember login(UmsMember umsMember) {

        Jedis jedis = redisUtil.getJedis();

        return null;
    }
}
