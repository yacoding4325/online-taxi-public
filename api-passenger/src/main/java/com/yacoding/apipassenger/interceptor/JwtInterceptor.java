package com.yacoding.apipassenger.interceptor;

import com.yacoding.internalcommon.constant.TokenConstants;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.dto.TokenResult;
import com.yacoding.internalcommon.util.JwtUtils;
import com.yacoding.internalcommon.util.RedisPrefixUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author yaCoding
 * @create 2022-11-18 下午 2:23
 */

public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        boolean result = true;
        String resultString = "";

        String token = request.getHeader("Authorization");
        //解析token
        TokenResult tokenResult = JwtUtils.checkToken(token);

        if (tokenResult == null) {
            resultString = "access token invalid";
            result = false;
        } else {
            //拼接key
            String phone = tokenResult.getPhone();
            String identity = tokenResult.getIdentity();

            String tokenKey = RedisPrefixUtils.generatorTokenKey(phone,identity, TokenConstants.ACCESS_TOKEN_TYPE);
            //从redis 中取出 token
            String tokenRedis = stringRedisTemplate.opsForValue().get(tokenKey);
            if ((StringUtils.isBlank(tokenRedis)) || (!token.trim().equals(tokenRedis.trim()))) {
                resultString = "access token invalid";
                result = false;
            }
        }
        if (!result) {
            PrintWriter out = response.getWriter();
            out.print(JSONObject.fromObject(ResponseResult.fail(resultString)).toString());
        }
        return result;
    }
}
