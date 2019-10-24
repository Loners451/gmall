package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.bean.PmsBaseAttrInfo;
import com.gmall.bean.PmsSearchParam;
import com.gmall.bean.PmsSearchSkuInfo;
import com.gmall.bean.PmsSkuAttrValue;
import com.gmall.service.AttrService;
import com.gmall.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/23 9:50
 */
@Controller
public class SearchController {


    @Reference
    SearchService searchService;

    @Reference
    AttrService attrService;


    @GetMapping("list.html")
    public String list(PmsSearchParam pmsSearchParam, Model model) {

        //调用搜索服务，返回搜索结果

        List<PmsSearchSkuInfo> pmsSearchSkuInfos = searchService.list(pmsSearchParam);

        model.addAttribute("skuLsInfoList", pmsSearchSkuInfos);
        // 抽取检索结果锁包含的平台属性集合
        Set<String> valueIdSet = new HashSet<>();
        for (PmsSearchSkuInfo pmsSearchSkuInfo : pmsSearchSkuInfos) {
            List<PmsSkuAttrValue> skuAttrValueList = pmsSearchSkuInfo.getSkuAttrValueList();
            for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
                String valueId = pmsSkuAttrValue.getValueId();
                valueIdSet.add(valueId);
            }
        }
        // 根据valueId将属性列表查询出来
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrService.getAttrValueListByValueId(valueIdSet);
        model.addAttribute("attrList", pmsBaseAttrInfos);

        String urlParam = getUrlParam(pmsSearchParam);
        model.addAttribute("urlParam", urlParam);


        return "list";
    }

    private String getUrlParam(PmsSearchParam pmsSearchParam) {

        String catalog3Id = pmsSearchParam.getCatalog3Id();
        String keyword = pmsSearchParam.getKeyword();
        String [] skuAttrValueList = pmsSearchParam.getValueId();

        String urlParam="";

        if (StringUtils.isNotBlank(catalog3Id)){
            urlParam=urlParam+"&catalog3Id="+catalog3Id;
        }

        if (StringUtils.isNotBlank(keyword)){
            urlParam=urlParam+"&keyword="+keyword;
        }
        if (skuAttrValueList!=null) {
            for (String pmSku : skuAttrValueList) {
                urlParam = urlParam + "&valueId=" + pmSku;
            }
        }


        return null;
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}   
