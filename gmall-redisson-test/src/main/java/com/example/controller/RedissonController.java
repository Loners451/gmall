package com.example.controller;

import com.example.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/19 10:16
 */
@RestController
public class RedissonController {

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    RedisUtil redisUtil;


    @RequestMapping("testRedisson")
    public String testRedisson() {

        RLock lock = redissonClient.getLock("lock");
        Jedis jedis = redisUtil.getJedis();   //连接redis
        try {


            String v = jedis.get("k");//获取值
            System.out.println("<--------" + v);
            if (StringUtils.isBlank(v)) {
                v = "1";
            }
            System.out.println("-------->" + v);
            jedis.set("k", (Integer.parseInt(v)) + 1 + "");        //设置值
            jedis.close();
        } finally {

            lock.unlock();
        }

        return "success";
    }
}   
