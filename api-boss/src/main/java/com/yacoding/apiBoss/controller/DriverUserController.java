package com.yacoding.apiBoss.controller;

import com.yacoding.apiBoss.service.CarService;
import com.yacoding.apiBoss.service.DriverUserService;
import com.yacoding.internalcommon.dto.Car;
import com.yacoding.internalcommon.dto.DriverUser;
import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-11-23 下午 9:20
 */

@RestController
public class DriverUserController {

    @Autowired
    private DriverUserService driverUserService;

    /**
     * 添加司机
     * @param driverUser
     * @return
     */
    @PostMapping("/driver-user")
    public ResponseResult addDriverUser(@RequestBody DriverUser driverUser){
        return driverUserService.addDriverUser(driverUser);
    }

    @Autowired
    CarService carService;

    @PostMapping("/car")
    public ResponseResult car(@RequestBody Car car){
        return carService.addCar(car);
    }

}
