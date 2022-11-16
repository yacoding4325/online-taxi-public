package com.yacoding.apipassenger.service;

//import com.yacoding.apipassenger.remote.ServiceVefificationcodeClient;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.VerificationCodeDTO;
import com.yacoding.internalcommon.responese.NumberCodeResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author yaCoding
 * @create 2022-11-15 下午 9:43
 */
//验证码 校验

@Service
public class VerificationCodeService {

//    @Autowired
//    private ServiceVefificationcodeClient serviceVefificationcodeClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 生成验证码
     * @param passengerPhone 手机号
     * @return
     */
//    public ResponseResult generatorCode(String passengerPhone) {
//        // 调用验证码服务，获取验证码
//        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVefificationcodeClient.getNumberCode(6);
//        int numberCode = numberCodeResponse.getData().getNumberCode();
//
//        //存入redis
//        //key,value，过期时间
//        String key = RedisPrefixUtils.generatorKeyByPhone(passengerPhone,IdentityConstants.PASSENGER_IDENTITY) ;
//        //存入redis
//        stringRedisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);
//
//        // 通过短信服务商，将对应的验证码发送到手机上。阿里短信服务，腾讯短信通，华信，容联
//        return ResponseResult.success("");
//    }

//    @Autowired
//    private ServicePassengerUserClient servicePassengerUserClient;

    /**
     * 校验验证码
     * @param passengerPhone 手机号
     * @param verificationCode 验证码
     * @return
     */
//    public ResponseResult checkCode(String passengerPhone,String verificationCode) {
//        //根据手机号，去redis读取
//        //生成key
//        String key = RedisPrefixUtils.generatorKeyByPhone(passengerPhone,IdentityConstants.PASSENGER_IDENTITY) ;
//        //根据key 获取value
//        String codeRedis = stringRedisTemplate.opsForValue().get(key);
//        System.out.println("redis中的value："+codeRedis);
//
//        //验证码校验
//        if (StringUtils.isBlank(codeRedis)){
//            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
//        }
//
//        if (!verificationCode.trim().equals(codeRedis.trim())){
//            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
//        }
//
//        // 判断原来是否有用户，并进行对应的处理
//        VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
//        verificationCodeDTO.setPassengerPhone(passengerPhone);
//        servicePassengerUserClient.loginOrRegister(verificationCodeDTO);
//
//        // 颁发令牌，不应该用魔法值，用常量
//        String accessToken = JwtUtils.generatorToken(passengerPhone, IdentityConstants.PASSENGER_IDENTITY, TokenConstants.ACCESS_TOKEN_TYPE);
//        String refreshToken = JwtUtils.generatorToken(passengerPhone, IdentityConstants.PASSENGER_IDENTITY ,TokenConstants.REFRESH_TOKEN_TYPE);
//
//        // 将token存到redis当中
//        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(passengerPhone , IdentityConstants.PASSENGER_IDENTITY , TokenConstants.ACCESS_TOKEN_TYPE);
//        stringRedisTemplate.opsForValue().set(accessTokenKey , accessToken , 30, TimeUnit.DAYS);
//
//        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(passengerPhone , IdentityConstants.PASSENGER_IDENTITY , TokenConstants.REFRESH_TOKEN_TYPE);
//        stringRedisTemplate.opsForValue().set(refreshTokenKey , refreshToken , 31, TimeUnit.DAYS);
//
//        // 响应
//        TokenResponse tokenResponse = new TokenResponse();
//        tokenResponse.setAccessToken(accessToken);
//        tokenResponse.setRefreshToken(refreshToken);
//        return ResponseResult.success(tokenResponse);
//    }

}
