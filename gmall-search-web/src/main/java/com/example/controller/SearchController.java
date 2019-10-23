package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.bean.PmsSearchParam;
import com.gmall.bean.PmsSearchSkuInfo;
import com.gmall.service.SearchService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/23 9:50
 */
@Controller
public class SearchController {


    @Reference
    SearchService searchService;


    @GetMapping("list.html")
    public String list(PmsSearchParam pmsSearchParam, Model model) {

        //调用搜索服务，返回搜索结果

        List<PmsSearchSkuInfo> pmsSearchSkuInfos = searchService.list(pmsSearchParam);

        model.addAttribute("skuLsInfoList", pmsSearchSkuInfos);

        return "list";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}   
