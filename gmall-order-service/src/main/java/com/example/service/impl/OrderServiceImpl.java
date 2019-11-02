package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.util.RedisUtil;
import com.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.UUID;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/11/2 17:16
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    RedisUtil redisUtil;

    @Override
    public String checkTradeCode(String memberId,String tradeCode) {

        Jedis jedis = null ;

        try {
            jedis = redisUtil.getJedis();
            String tradeKey = "user:" + memberId + ":tradeCode";


            String tradeCodeFromCache = jedis.get(tradeKey);// 使用lua脚本在发现key的同时将key删除，防止并发订单攻击
            //对比防重删令牌
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Long eval = (Long) jedis.eval(script, Collections.singletonList(tradeKey), Collections.singletonList(tradeCode));

            if (eval!=null&&eval!=0) {
                // jedis.del(tradeKey);
                return "success";
            } else {
                return "fail";
            }
        }finally {
            jedis.close();
        }
    }

    @Override
    public String genTradeCode(String memberId) {
        Jedis jedis =null;
        String tradeCode="";
        try {
            jedis=redisUtil.getJedis();

            String tradeKey = "user:" + memberId + ":tradeCode";

            //生成随机数
            tradeCode = UUID.randomUUID().toString();

            jedis.setex(tradeKey, 60*15, tradeCode);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }

        return tradeCode;

    }
}
