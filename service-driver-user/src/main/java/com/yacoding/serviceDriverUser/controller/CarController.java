package com.yacoding.serviceDriverUser.controller;

import com.yacoding.internalcommon.dto.Car;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.serviceDriverUser.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yaCoding
 * @create 2022-11-24 上午 10:06
 */

@RestController
@Slf4j
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/car")
    public ResponseResult addCar(@RequestBody Car car) {
        return carService. addCar(car);
    }

}
