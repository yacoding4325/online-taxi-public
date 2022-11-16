package com.yacoding.internalcommon.request;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-11-16 上午 10:01
 */


@Data
public class VerificationCodeDTO {

    private String passengerPhone;

    private String verificationCode;

    private String driverPhone;
}
