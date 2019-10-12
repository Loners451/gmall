package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.bean.PmsProductInfo;
import com.gmall.service.SpuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/12 18:47
 */
@RestController
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;

    @RequestMapping("spuList")
    public List<PmsProductInfo> spuList(String catalog3Id){

        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);

        return pmsProductInfos;
    }

}   
