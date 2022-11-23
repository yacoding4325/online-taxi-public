package com.yacoding.apiBoss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-11-23 下午 9:02
 */

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "api-boss";
    }

}
