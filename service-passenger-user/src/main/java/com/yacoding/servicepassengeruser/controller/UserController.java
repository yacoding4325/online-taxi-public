package com.yacoding.servicepassengeruser.controller;

import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.VerificationCodeDTO;
import com.yacoding.servicepassengeruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println("手机号："+passengerPhone);
        return userService.loginOrRegister(passengerPhone);
    }

//    @GetMapping("/user/{phone}")
//    public ResponseResult getUser(@PathVariable("phone") String passengerPhone){
//        System.out.println("service-passenger-user: phone:"+passengerPhone);
//        return userService.getUserByPhone(passengerPhone);
//    }
}