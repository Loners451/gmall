package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.bean.PmsProductSaleAttr;
import com.gmall.bean.PmsSkuInfo;
import com.gmall.service.SkuService;
import com.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/16 16:03
 */
@Controller
public class ItemController {

    @Reference
    SkuService skuService;

    @Reference
    SpuService spuService;

    @RequestMapping("{skuId}.html")
    public String item(@PathVariable("skuId") String skuId, Model model) {
        //sku的对象
        PmsSkuInfo pmsSkuInfo = skuService.getSkuById(skuId);
        model.addAttribute("skuInfo", pmsSkuInfo);
        //销售属性列表
       List<PmsProductSaleAttr> pmsProductSaleAttrs= spuService.spuSaleAttrListCheckBySku(pmsSkuInfo.getProductId());


        model.addAttribute("spuSaleAttrListCheckBySku", pmsProductSaleAttrs);
        return "item";
    }
}   
