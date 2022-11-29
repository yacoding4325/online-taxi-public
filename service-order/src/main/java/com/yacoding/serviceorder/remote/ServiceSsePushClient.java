package com.yacoding.serviceorder.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author yaCoding
 * @create 2022-11-29 下午 9:57
 */

@FeignClient("service-sse-push")
public interface ServiceSsePushClient {

    @RequestMapping(method = RequestMethod.GET,value = "/push")
    public String push(@RequestParam Long userId, @RequestParam String identity, @RequestParam String content);

}
