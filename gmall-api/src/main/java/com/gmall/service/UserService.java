package com.gmall.service;



import com.gmall.bean.UmsMember;
import com.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @author Moses
 * @version 1.0
 * @date 2019/10/9 16:10
 */
public interface UserService {

    List<UmsMember> getAllUser();

    UmsMember login(UmsMember umsMember);

    void addUserToken(String token, String memberId);

    UmsMember addOauthUser(UmsMember umsMember);

    UmsMember checkOauthUser(UmsMember umsCheck);

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);

    UmsMemberReceiveAddress getReceiveAddressById(String receiveAddressId);
}
