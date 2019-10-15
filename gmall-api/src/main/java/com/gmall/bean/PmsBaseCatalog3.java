package com.gmall.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/11 19:50
 */
@Data
public class PmsBaseCatalog3 implements Serializable {

    @Id
    private  String id;
    private  String name;
    private  String catalog2Id;


}
