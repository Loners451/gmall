package com.example.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/9 18:13
 */
@Data
public class UmsMemberReceiveAddress {
    @Id
    private String id;
    private String memberId;
    private String  name;
    private String  phoneNumber;
    private int defaultStatus;
    private String postCode;
    private String province;
    private String city;
    private String region;
    private String detailAddress;
}   
