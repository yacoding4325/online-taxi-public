package com.yacoding.serviceDriverUser.service;

import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.serviceDriverUser.mapper.DriverUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-12-01 下午 1:40
 */

@Service
public class CityDriverUserService {

    @Autowired
    DriverUserMapper driverUserMapper;

    public ResponseResult isAvailableDriver(String cityCode) {
        int i = driverUserMapper.selectDriverUserCountByCityCode(cityCode);
        if (i > 0) {
            return ResponseResult.success(true);
        } else {
            return ResponseResult.success(false);
        }
    }

}
