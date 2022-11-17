package com.yacoding.internalcommon.responese;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-11-17 下午 3:17
 */
@Data
public class TokenResponse {

    private String accessToken;

    private String refreshToken;

}
