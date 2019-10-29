package com.gmall.service;

import com.gmall.bean.OmsCartItem;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/28 11:30
 */
public interface CartService {

    OmsCartItem ifCartExistByUser(String memberId, String skuId);

    void addCart(OmsCartItem omsCartItem);

    void updateCart(OmsCartItem omsCartItemFromDb);

    void flushCartCache(String memberId);

    List<OmsCartItem> cartList(String userId);

    void checkCart(OmsCartItem omsCartItem);
}
