package com.gmall.service;

import com.gmall.bean.PmsSearchParam;
import com.gmall.bean.PmsSearchSkuInfo;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/23 15:00
 */
public interface SearchService {
    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam);
}
