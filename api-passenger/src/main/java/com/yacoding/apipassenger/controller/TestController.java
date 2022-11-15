package com.yacoding.apipassenger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-11-15 下午 8:52
 */
//测试 文件
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){

        return "test api passenger";
    }

}
