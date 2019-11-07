package com.example.controller;

import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/11/7 19:56
 */
@Controller
public class SecKillController {

    @Autowired
    RedisUtil redisUtil;


    @RequestMapping("kill")
    @ResponseBody
    public String kill(){
        String numberId="1";

        Jedis jedis = redisUtil.getJedis();



        Integer stock =Integer.parseInt(jedis.get("106"));

        if (stock>0){
            System.out.println("当前库存数量剩余为"+stock+"用户为"+numberId+"抢购成功");
            jedis.incrBy("106", -1);
        }


        jedis.close();
        return  "1";
    }
}   
