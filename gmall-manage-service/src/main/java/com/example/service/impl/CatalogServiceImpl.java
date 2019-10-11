package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.mapper.PmsBaseCatalog1Mapper;
import com.example.mapper.PmsBaseCatalog2Mapper;
import com.example.mapper.PmsBaseCatalog3Mapper;
import com.gmall.bean.PmsBaseCatalog1;
import com.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/11 20:23
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }
}
