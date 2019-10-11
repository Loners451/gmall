package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.bean.PmsBaseCatalog1;
import com.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/11 19:35
 */
@RestController
public class CatalogController {

     @Reference
     CatalogService catalogService;

     @PostMapping("getCatalog1")
     public List<PmsBaseCatalog1> getCatalogl(){
         List<PmsBaseCatalog1> catalog1s = catalogService.getCatalog1();
         return  catalog1s;
     }
}   
