package com.yacoding.apiDriver.remote;

import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author yaCoding
 * @create 2022-12-06 下午 11:06
 */
@FeignClient("service-order")
public interface ServiceOrderClient {
    /**
     * 接乘客
     * @param orderRequest
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/order/to-pick-up-passenger")
    ResponseResult toPickUpPassenger(@RequestBody OrderRequest orderRequest);

    /**
     * 到达乘客上车点
     * @param orderRequest
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/order/arrived-departure")
    ResponseResult arrivedDeparture(@RequestBody OrderRequest orderRequest);

    /**
     * 司机接到乘客
     * @param orderRequest
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/order/pick-up-passenger")
    ResponseResult pickUpPassenger(@RequestBody OrderRequest orderRequest);

    /**
     * 乘客到达目的地，行程终止
     * @param orderRequest
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value ="/order/passenger-getoff")
    ResponseResult passengerGetoff(@RequestBody OrderRequest orderRequest);

    @PostMapping("/order/push-pay-info")
    ResponseResult pushPayInfo(@RequestBody OrderRequest orderRequest);

}
