package com.yacoding.apipassenger.controller;

import com.yacoding.apipassenger.service.UserService;
import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author yaCoding
 * @create 2022-11-20 下午 2:09
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseResult getUser(HttpServletRequest request) {
        //http 请求中 获取accessToken
        String accessToken = request.getHeader("Authorization");
        return userService.getUserByAccessToken(accessToken);
    }
}
