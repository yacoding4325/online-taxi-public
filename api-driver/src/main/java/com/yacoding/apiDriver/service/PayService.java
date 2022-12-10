package com.yacoding.apiDriver.service;

import com.yacoding.apiDriver.remote.ServiceOrderClient;
import com.yacoding.apiDriver.remote.ServiceSsePushClient;
import com.yacoding.internalcommon.constant.IdentityConstants;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.OrderRequest;
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

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public ResponseResult pushPayInfo(Long orderId, String price, Long passengerId) {
        //封装消息
        JSONObject message = new JSONObject();
        message.put("price",price);
        message.put("orderId",orderId);

        //修改订单状态
        OrderRequest orderRequest  = new OrderRequest();
        orderRequest.setOrderId(orderId);
        serviceOrderClient.pushPayInfo(orderRequest);

        //推送消息
        serviceSsePushClient.push(passengerId, IdentityConstants.PASSENGER_IDENTITY,message.toString());
        return ResponseResult.success();
    }

}
