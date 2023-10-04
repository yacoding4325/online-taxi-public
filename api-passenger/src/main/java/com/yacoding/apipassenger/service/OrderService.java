package com.yacoding.apipassenger.service;

import com.yacoding.apipassenger.remote.ServiceOrderClient;
import com.yacoding.internalcommon.constant.IdentityConstants;
import com.yacoding.internalcommon.dto.OrderInfo;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-11-27 下午 2:08
 */
@Service
public class OrderService {

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public ResponseResult add(OrderRequest orderRequest) {
        return serviceOrderClient.add(orderRequest);
    }

    public ResponseResult book(OrderRequest orderRequest){
        return serviceOrderClient.book(orderRequest);
    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    public ResponseResult cancel(Long orderId) {
        return serviceOrderClient.cancel(orderId, IdentityConstants.PASSENGER_IDENTITY);
    }

    public ResponseResult<OrderInfo> detail(Long orderId){
        return serviceOrderClient.detail(orderId);
    }

    public ResponseResult<OrderInfo> currentOrder(String phone , String identity){
        return serviceOrderClient.current(phone,identity);
    }
}
