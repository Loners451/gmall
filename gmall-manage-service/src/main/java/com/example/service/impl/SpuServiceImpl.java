package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.mapper.PmsProductInfoMapper;
import com.gmall.bean.PmsProductInfo;
import com.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/12 19:04
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo productInfo=new PmsProductInfo();
        productInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.select(productInfo);

        return pmsProductInfos;
    }
}
