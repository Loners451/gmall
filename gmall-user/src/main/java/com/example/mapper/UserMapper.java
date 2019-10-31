package com.example.mapper;


import com.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/9 16:18
 */
public interface UserMapper extends Mapper<UmsMember> {

    List<UmsMember> getAllUser();
}   
