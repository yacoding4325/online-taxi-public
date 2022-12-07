package com.yacoding.apiDriver.service;

import com.yacoding.apiDriver.remote.ServiceOrderClient;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    /**
     * 到达乘客上车点
     * @param orderRequest
     * @return
     */
    public ResponseResult arrivedDeparture(OrderRequest orderRequest) {
        return serviceOrderClient.arrivedDeparture(orderRequest);
    }

    /**
     * 司机接到乘客
     * @param orderRequest
     * @return
     */
    public ResponseResult pickUpPassenger(@RequestBody OrderRequest orderRequest) {
        return serviceOrderClient.pickUpPassenger(orderRequest);
    }

    /**
     * 乘客到达目的地，行程终止
     * @param orderRequest
     * @return
     */
    public ResponseResult passengerGetoff(OrderRequest orderRequest) {
        return serviceOrderClient.passengerGetoff(orderRequest);
    }
}
