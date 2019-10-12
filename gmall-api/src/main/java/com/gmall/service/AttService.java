package com.gmall.service;

import com.gmall.bean.PmsBaseAttrInfo;
import com.gmall.bean.PmsBaseAttrValue;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/12 10:24
 */
public interface AttService {
    List<PmsBaseAttrInfo> attrInfosList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);
}
