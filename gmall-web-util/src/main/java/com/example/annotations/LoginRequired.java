package com.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/29 19:30
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public  @interface LoginRequired {

    boolean loginSuccess() default true;
}   
