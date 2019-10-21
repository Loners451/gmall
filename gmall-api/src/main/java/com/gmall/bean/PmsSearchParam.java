package com.gmall.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * es的映射实体
 * @author Moses
 * @version 1.0
 * @date 2019/10/21 15:33
 */
@Data
public class PmsSearchParam  implements Serializable {
    private String catalog3Id;

    private String keyword;

    private List<PmsSkuAttrValue> skuAttrValueList;
}   
