package com.yacoding.apiBoss.service;

import com.yacoding.apiBoss.remote.ServiceDriverUserClient;
import com.yacoding.internalcommon.dto.DriverUser;
import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-11-23 下午 9:22
 */
@Service
public class DriverUserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    /**
     * 添加司机
     * @param driverUser
     * @return
     */
    public ResponseResult addDriverUser(DriverUser driverUser){
        return serviceDriverUserClient.addDriverUser(driverUser);
    }
}
