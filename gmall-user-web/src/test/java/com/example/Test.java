package com.example;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/30 15:32
 */
public class Test {


    public static void main(String[] args) {


        LocalDate now = LocalDate.now();



        System.out.println(LocalDate.now());


        String name="";

        if (StringUtils.isNotBlank(name)){
            System.out.println("--------->"+"isBlank");
        }else {
            System.out.println("--->");
        }
    }
}   
