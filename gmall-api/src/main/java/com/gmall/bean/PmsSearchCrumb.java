package com.gmall.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/24 22:24
 */
@Data
public class PmsSearchCrumb  implements Serializable {

    private String valueId;
    private String valueName;
    private String urlParam;
}   
