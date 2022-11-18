package com.yacoding.apipassenger.controller;

import com.yacoding.apipassenger.service.TokenService;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.responese.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-11-18 下午 7:56
 */

//原来的token
@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/token-refresh")
    public ResponseResult refreshToken(@RequestBody TokenResponse tokenResponse) {
        String refreshTokenSrc = tokenResponse.getRefreshToken();
        System.out.println("原来的 refreshToken："+refreshTokenSrc);
        return tokenService.refreshToken(refreshTokenSrc);
    }

}
