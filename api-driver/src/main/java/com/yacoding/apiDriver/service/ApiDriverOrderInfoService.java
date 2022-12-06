package com.yacoding.apiDriver.service;

import com.yacoding.apiDriver.remote.ServiceOrderClient;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-12-06 下午 11:07
 */

@Service
public class ApiDriverOrderInfoService {

    @Autowired
    ServiceOrderClient serviceOrderClient;

    /**
     * 去接乘客
     * @param orderRequest
     * @return
     */
    public ResponseResult toPickUpPassenger(OrderRequest orderRequest) {
        return serviceOrderClient.toPickUpPassenger(orderRequest);
    }
}
