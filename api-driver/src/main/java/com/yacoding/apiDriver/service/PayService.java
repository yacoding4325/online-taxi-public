package com.yacoding.apiDriver.service;

import com.yacoding.apiDriver.remote.ServiceSsePushClient;
import com.yacoding.internalcommon.constant.IdentityConstants;
import com.yacoding.internalcommon.dto.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-12-08 上午 10:19
 */

@Service
public class PayService {

    @Autowired
    ServiceSsePushClient serviceSsePushClient;

    public ResponseResult pushPayInfo(String orderId, String price, Long passengerId) {
        //封装消息
        JSONObject message = new JSONObject();
        message.put("price",price);
        message.put("orderId",orderId);

        //推送消息
        serviceSsePushClient.push(passengerId, IdentityConstants.PASSENGER_IDENTITY,message.toString());
        return ResponseResult.success();
    }

}
