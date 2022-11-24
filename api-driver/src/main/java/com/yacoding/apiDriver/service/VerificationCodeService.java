package com.yacoding.apiDriver.service;

import com.yacoding.apiDriver.remote.ServiceDriverUserClient;
import com.yacoding.apiDriver.remote.ServiceVerificationcodeClient;
import com.yacoding.internalcommon.constant.CommonStatusEnum;
import com.yacoding.internalcommon.constant.DriverCarConstants;
import com.yacoding.internalcommon.constant.IdentityConstants;
import com.yacoding.internalcommon.constant.TokenConstants;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.responese.DriverUserExistsResponse;
import com.yacoding.internalcommon.responese.NumberCodeResponse;
import com.yacoding.internalcommon.responese.TokenResponse;
import com.yacoding.internalcommon.util.JwtUtils;
import com.yacoding.internalcommon.util.RedisPrefixUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * @Author yaCoding
 * @create 2022-11-24 下午 6:35
 */

@Service
@Slf4j
public class VerificationCodeService {

    @Autowired
    ServiceDriverUserClient serviceDriverUserClient;

    @Autowired
    ServiceVerificationcodeClient serviceVerificationcodeClient;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    /**
     * 查询司机 手机号是否存在
     * @param driverPhone
     * @return
     */
    public ResponseResult checkAndsendVerificationCode(String driverPhone) {
        // 查询 service-driver-user，该手机号的司机是否存在
        ResponseResult<DriverUserExistsResponse> driverUserExistsResponseResponseResult = serviceDriverUserClient.checkDriver(driverPhone);
        DriverUserExistsResponse data = driverUserExistsResponseResponseResult.getData();
        int ifExists = data.getIfExists();
        if (ifExists == DriverCarConstants.DRIVER_NOT_EXISTS) {
            return ResponseResult.fail(CommonStatusEnum.DRIVER_NOT_EXITST.getCode(),CommonStatusEnum.DRIVER_NOT_EXITST.getValue());
        }
        log.info(driverPhone + "的司机存在");
        //获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResult = serviceVerificationcodeClient.getNumberCode(6);
        NumberCodeResponse numberCodeResponse = numberCodeResult.getData();
        int numberCode = numberCodeResponse.getNumberCode();
        log.info("验证码" + numberCode);
        // 调用第三方发生验证码,第三方：阿里短信服务，腾讯，华信，容联

        // 存入reids。1：key，2：存入value
        String key = RedisPrefixUtils.generatorKeyByPhone(driverPhone, IdentityConstants.DRIVER_IDENTITY);
        stringRedisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);
        return ResponseResult.success("");
    }


    /**
     * 校验验证码
     * @param driverPhone 手机号
     * @param verificationCode 验证码
     * @return
     */
    public ResponseResult checkCode(String driverPhone, String verificationCode) {
        //根据手机号，去redis 读取验证码
        //生成key
        String key = RedisPrefixUtils.generatorKeyByPhone(driverPhone,IdentityConstants.DRIVER_IDENTITY);
        //根据key 获取value
        String codeRedis = stringRedisTemplate.opsForValue().get(key);
        System.out.println("redis中的value：" + codeRedis);

        //校验验证码
        if (StringUtils.isBlank(codeRedis)) {
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        if (!verificationCode.trim().equals(codeRedis.trim())) {
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }

        //颁发令牌， 不应该用魔法值，用常量
        String accessToken = JwtUtils.generatorToken(driverPhone, IdentityConstants.DRIVER_IDENTITY, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generatorToken(driverPhone, IdentityConstants.DRIVER_IDENTITY ,TokenConstants.REFRESH_TOKEN_TYPE);

        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(driverPhone , IdentityConstants.DRIVER_IDENTITY , TokenConstants.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey , accessToken , 30, TimeUnit.DAYS);

        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(driverPhone , IdentityConstants.DRIVER_IDENTITY , TokenConstants.REFRESH_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(refreshTokenKey , refreshToken , 31, TimeUnit.DAYS);

        //响应
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setAccessToken(refreshToken);
        return ResponseResult.success(tokenResponse);
    }
}
