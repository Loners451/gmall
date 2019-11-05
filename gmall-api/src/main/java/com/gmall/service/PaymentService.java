package com.gmall.service;

import com.gmall.bean.PaymentInfo;

import java.util.Map;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/11/3 20:21
 */
public interface PaymentService {
    void updatePayment(PaymentInfo paymentInfo);

    void savePaymentInfo(PaymentInfo paymentInfo);

    void sendDelayPaymentResultCheckQueue(String outTradeNo, int i);

    Map<String, Object> checkAlipayPayment(String out_trade_no);
}
