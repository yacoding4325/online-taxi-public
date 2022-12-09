package com.yacoding.apiDriver.controller;

import com.yacoding.apiDriver.service.UserService;
import com.yacoding.internalcommon.dto.DriverUser;
import com.yacoding.internalcommon.dto.DriverUserWorkStatus;
import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yaCoding
 * @create 2022-11-24 上午 8:32
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser){
        return userService.updateUser(driverUser);
    }

    @PostMapping("/driver-user-work-status")
    public ResponseResult changeWorkStatus(@RequestBody DriverUserWorkStatus driverUserWorkStatus){
        return userService.changeWorkStatus(driverUserWorkStatus);
    }


}
