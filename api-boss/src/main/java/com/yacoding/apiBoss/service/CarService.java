package com.yacoding.apiBoss.service;

import com.yacoding.apiBoss.remote.ServiceDriverUserClient;
import com.yacoding.internalcommon.dto.Car;
import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-11-23 下午 10:19
 */
@Service
public class CarService {

    @Autowired
    ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult addCar(Car car){
        return serviceDriverUserClient.addCar(car);
    }

}
