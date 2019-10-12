package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.bean.PmsBaseCatalog1;
import com.gmall.bean.PmsBaseCatalog2;
import com.gmall.bean.PmsBaseCatalog3;
import com.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 列表分类
 * @author Moses
 * @version 1.0
 * @date 2019/10/11 19:35
 */
@RestController
@CrossOrigin
public class CatalogController {

     @Reference
     CatalogService catalogService;

   /***
     * @Author: Moses
     * @Description: 三级分类
     * @Date: 2019/10/12
     [catalog2Id]
     java.util.List<com.gmall.bean.PmsBaseCatalog3> 
     **/
    @PostMapping("getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){

        List<PmsBaseCatalog3> catalog3s = catalogService.getCatalog3(catalog2Id);
        return catalog3s;
    }

    /***
      * @Author: Moses
      * @Description: 二级分类
      * @Date: 2019/10/12
      [catalog1Id]
      java.util.List<com.gmall.bean.PmsBaseCatalog2> 
      **/
    @PostMapping("getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){

        List<PmsBaseCatalog2> catalog2s = catalogService.getCatalog2(catalog1Id);
        return catalog2s;
    }


   /***
     * @Author: Moses
     * @Description: 一级分类
     * @Date: 2019/10/12
     []
     java.util.List<com.gmall.bean.PmsBaseCatalog1> 
     **/
     @PostMapping("getCatalog1")
     public List<PmsBaseCatalog1> getCatalogl(){
         List<PmsBaseCatalog1> catalog1s = catalogService.getCatalog1();
         return  catalog1s;
     }
}   
