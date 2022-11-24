package com.yacoding.serviceDriverUser.remote;

import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.responese.TerminalResponse;
import com.yacoding.internalcommon.responese.TrackResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author yaCoding
 * @create 2022-11-24 上午 10:17
 */

@FeignClient("service-map")
public interface ServiceMapClient {

    @RequestMapping(method = RequestMethod.POST, value = "/track/add")
    public ResponseResult<TrackResponse> addTrack(@RequestParam String tid);

    @RequestMapping(method = RequestMethod.POST, value = "/terminal/add")
    public ResponseResult<TerminalResponse> addTerminal(@RequestParam String name , @RequestParam String desc);

}
