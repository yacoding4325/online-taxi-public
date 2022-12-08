package com.yacoding.apiDriver.controller;

import com.yacoding.apiDriver.service.PayService;
import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-12-08 上午 10:18
 */

@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    PayService payService;

    /**
     * 司机发起收款
     * @param orderId
     * @param price
     * @param passengerId
     * @return
     */
    @PostMapping("/push-pay-info")
    public ResponseResult pushPayInfo(@RequestParam String orderId , @RequestParam String price, @RequestParam Long passengerId){
        return payService.pushPayInfo(orderId,price,passengerId);
    }

}
