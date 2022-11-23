package com.yacoding.apiBoss.service;

import com.yacoding.apiBoss.remote.ServiceDriverUserClient;
import com.yacoding.internalcommon.dto.DriverUser;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.serviceDriverUser.mapper.DriverUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Author yaCoding
 * @create 2022-11-23 下午 9:22
 */
@Service
public class DriverUserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    @Autowired
    private DriverUserMapper driverUserMapper;

    /**
     * 添加司机
     * @param driverUser
     * @return
     */
    public ResponseResult addDriverUser(DriverUser driverUser){
        return serviceDriverUserClient.addDriverUser(driverUser);
    }

    public ResponseResult updateDriverUser(DriverUser driverUser){
        LocalDateTime now = LocalDateTime.now();
        driverUser.setGmtModified(now);
        driverUserMapper.updateById(driverUser);
        return ResponseResult.success("");
    }
}
