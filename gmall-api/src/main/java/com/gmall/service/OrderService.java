package com.gmall.service;

import com.gmall.bean.OmsOrder;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/11/2 16:56
 */
public interface OrderService {

    String checkTradeCode(String memberId, String tradeCode);

    String genTradeCode(String memberId);

    void saveOrder(OmsOrder omsOrder);

    OmsOrder getOrderByOutTradeNo(String outTradeNo);

    void updateOrder(OmsOrder omsOrder);
}
