package com.gmall.service;

import com.gmall.bean.PmsBaseCatalog1;
import com.gmall.bean.PmsBaseCatalog2;
import com.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/11 20:21
 */
public interface CatalogService {

    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
