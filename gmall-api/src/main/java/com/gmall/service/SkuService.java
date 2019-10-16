package com.gmall.service;

import com.gmall.bean.PmsSkuInfo;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/15 15:28
 */
public interface SkuService {
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getSkuById(String skuId);
}
