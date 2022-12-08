package com.yacoding.apiDriver.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author yaCoding
 * @create 2022-12-08 上午 10:20
 */
@FeignClient("service-see-push")
public interface ServiceSsePushClient {

    @RequestMapping(method = RequestMethod.GET,value = "/push")
    String push(@RequestParam Long passengerId, @RequestParam String passengerIdentity, @RequestParam String toString);

}
