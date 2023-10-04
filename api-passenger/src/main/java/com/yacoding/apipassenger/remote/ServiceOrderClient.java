package com.yacoding.apipassenger.remote;

import com.yacoding.internalcommon.dto.OrderInfo;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yaCoding
 * @create 2022-11-27 下午 2:09
 */
@FeignClient("service-order")
public interface ServiceOrderClient {

    @RequestMapping(method = RequestMethod.POST,value = "order/add" )
    public ResponseResult add(@RequestBody  OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.GET,value = "/test-real-time-order/{orderId}")
    public String dispatchRealTimeOrder(@PathVariable("orderId") long orderId);

    @RequestMapping(method = RequestMethod.POST, value = "/order/book")
    public ResponseResult book(@RequestBody OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.POST, value = "/order/cancel")
    public ResponseResult cancel(@RequestParam Long orderId , @RequestParam String identity);

    @RequestMapping(method = RequestMethod.GET, value = "/order/detail")
    public ResponseResult<OrderInfo> detail(@RequestParam Long orderId);

    @RequestMapping(method = RequestMethod.GET, value = "/order/current")
    public ResponseResult current(@RequestParam String phone ,@RequestParam String identity);

}
