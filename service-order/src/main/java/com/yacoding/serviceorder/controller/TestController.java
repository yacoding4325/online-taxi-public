package com.yacoding.serviceorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
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

}
