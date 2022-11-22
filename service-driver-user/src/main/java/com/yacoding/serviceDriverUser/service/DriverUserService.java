package com.yacoding.serviceDriverUser.service;

import com.yacoding.internalcommon.dto.DriverUser;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.serviceDriverUser.mapper.DriverUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-11-22 下午 11:05
 */
@Service
public class DriverUserService {

    @Autowired
    private DriverUserMapper driverUserMapper;

    public ResponseResult testGetDriverUser(){

        DriverUser driverUser = driverUserMapper.selectById(1);
        return ResponseResult.success(driverUser);
    }

}