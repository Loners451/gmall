package com.gmall.service;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/11/2 16:56
 */
public interface OrderService {

    String checkTradeCode(String memberId, String tradeCode);

    String genTradeCode(String memberId);
}
