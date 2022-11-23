package com.yacoding.apiBoss.remote;

import com.yacoding.internalcommon.dto.DriverUser;
import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author yaCoding
 * @create 2022-11-23 下午 9:24
 */

@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseResult addDriverUser(@RequestBody DriverUser driverUser);

}
