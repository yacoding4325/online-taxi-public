package com.yacoding.serviceorder.controller;

import com.yacoding.internalcommon.dto.OrderInfo;
import com.yacoding.serviceorder.mapper.OrderInfoMapper;
import com.yacoding.serviceorder.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-11-27 下午 3:31
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "service-order test";
    }

    @Autowired
    OrderInfoService orderInfoService;

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Value("${server.port}")
    String port;

    /**
     * 测试派单逻辑
     * @param orderId
     * @return
     */
    @GetMapping("/test-real-time-order/{orderId}")
    public String dispatchRealTimeOrder(@PathVariable("orderId") long orderId){
        System.out.println("service-order 端口："+ port+" 并发测试：orderId："+orderId);
        OrderInfo orderInfo = orderInfoMapper.selectById(orderId);
        orderInfoService.dispatchRealTimeOrder(orderInfo);
        return "test-real-time-order   success";
    }

}
