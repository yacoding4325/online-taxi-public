package com.yacoding.pay.controller;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yaCoding
 * @create 2022-12-08 下午 12:44
 */
@RequestMapping("/alipay")
@Controller
@ResponseBody
public class AlipayController {

    @GetMapping("/pay")
    public String pay(String subject,String outTradeNo, String totalAmount){
        AlipayTradePagePayResponse response ;
        try {
            response = Factory.Payment.Page().pay(subject, outTradeNo, totalAmount,"");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return response.getBody();
    }

}
