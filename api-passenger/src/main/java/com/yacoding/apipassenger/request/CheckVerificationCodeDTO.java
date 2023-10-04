package com.yacoding.apipassenger.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//验证码的 校验
@Data
public class CheckVerificationCodeDTO {

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3,4,5,6,7,8,9]\\d{9}$",message = "请填写正确的手机号")
    private String passengerPhone;

    @NotBlank(message = "验证码不能为空")
    @Pattern(regexp = "^\\d{6}$",message = "请填写6位数字的验证码")
    private String verificationCode;

}