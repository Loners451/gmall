package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.bean.PmsBaseAttrInfo;
import com.gmall.bean.PmsBaseAttrValue;
import com.gmall.bean.PmsBaseSaleAttr;
import com.gmall.service.AttrService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 查询信息
 *
 * @author Moses
 * @version 1.0
 * @date 2019/10/12 10:11
 */
@RestController
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attService;

    @PostMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = attService.baseSaleAttrList();
        return pmsBaseSaleAttrs;
    }


    @PostMapping("getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){

        List<PmsBaseAttrValue> pmsBaseAttrValues = attService.getAttrValueList(attrId);
        return pmsBaseAttrValues;
    }


    @RequestMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
       String success= attService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }





    /***
      * @Author: Moses
      * @Description: 根据条件查询
      * @Date: 2019/10/12
      [catalog3Id]
      java.util.List<com.gmall.bean.PmsBaseAttrInfo> 
      **/
    @GetMapping("attrInfoList")
    public List<PmsBaseAttrInfo> attrInfosList(String catalog3Id) {
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attService.attrInfosList(catalog3Id);
        return pmsBaseAttrInfos;
    }
}   
