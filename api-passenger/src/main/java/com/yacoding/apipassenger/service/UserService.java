package com.yacoding.apipassenger.service;

import com.yacoding.apipassenger.remote.ServicePassengerUserClient;
import com.yacoding.internalcommon.dto.PassengerUser;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.dto.TokenResult;
import com.yacoding.internalcommon.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-11-20 下午 2:12
 */

@Service
@Slf4j
public class UserService {

    @Autowired
    ServicePassengerUserClient servicePassengerUserClient;

    public ResponseResult getUserByAccessToken(String accessToken) {
        log.info("accessToken:" + accessToken);
        // 解析accessToken，拿到手机号
        TokenResult tokenResult = JwtUtils.checkToken(accessToken);
        String phone = tokenResult.getPhone();
        log.info("手机号：" + phone);

        // 根据手机号查询用户信息
        ResponseResult<PassengerUser> userByPhone = servicePassengerUserClient.getUserByPhone(phone);
        return ResponseResult.success(userByPhone.getData());
    }

}
