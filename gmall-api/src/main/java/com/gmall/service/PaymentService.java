package com.gmall.service;

import com.gmall.bean.PaymentInfo;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/11/3 20:21
 */
public interface PaymentService {
    void updatePayment(PaymentInfo paymentInfo);

    void savePaymentInfo(PaymentInfo paymentInfo);
}
