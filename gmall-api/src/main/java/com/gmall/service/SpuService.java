package com.gmall.service;

import com.gmall.bean.PmsProductImage;
import com.gmall.bean.PmsProductInfo;
import com.gmall.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/12 19:02
 */
public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);

    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId,String skuId);
}
