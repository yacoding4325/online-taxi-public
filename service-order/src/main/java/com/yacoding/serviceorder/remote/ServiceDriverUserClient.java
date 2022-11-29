package com.yacoding.serviceorder.remote;

import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author yaCoding
 * @create 2022-11-29 下午 8:22
 */
@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {

    @GetMapping("/city-driver/is-alailable-driver")
    ResponseResult<Boolean> isAvailableDriver(@RequestParam String address);


}
