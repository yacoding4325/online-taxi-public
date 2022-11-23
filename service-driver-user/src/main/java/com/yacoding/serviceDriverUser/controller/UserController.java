package com.yacoding.serviceDriverUser.controller;

import com.yacoding.internalcommon.dto.DriverUser;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.serviceDriverUser.service.DriverUserService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-11-23 下午 8:06
 */

@RestController
@Slf4j
public class UserController {

    @Autowired
    private DriverUserService driverUserService;

    /**
     * 新增司机
     */
    @PostMapping("/user")
    public ResponseResult addUser(@RequestBody DriverUser driverUser) {
        log.info(JSONObject.fromObject(driverUser).toString());
        return driverUserService.addDriverUser(driverUser);
    }
}
