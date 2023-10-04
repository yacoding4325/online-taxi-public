package com.yacoding.apipassenger.controller;

import com.yacoding.apipassenger.request.CheckVerificationCodeDTO;
import com.yacoding.apipassenger.request.SendVerificationCodeDTO;
import com.yacoding.apipassenger.service.VerificationCodeService;
import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-11-15 下午 9:33
 */
@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @PostMapping("/verification-code")
    public ResponseResult verificationCode(@Validated @RequestBody SendVerificationCodeDTO verificationCodeDTO){

        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        return verificationCodeService.generatorCode(passengerPhone);

    }

    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@Validated @RequestBody CheckVerificationCodeDTO checkVerificationCodeDTO){

        String passengerPhone = checkVerificationCodeDTO.getPassengerPhone();
        String verificationCode = checkVerificationCodeDTO.getVerificationCode();

        System.out.println("手机号"+passengerPhone+",验证码："+verificationCode);

        return verificationCodeService.checkCode(passengerPhone,verificationCode);
    }
}
