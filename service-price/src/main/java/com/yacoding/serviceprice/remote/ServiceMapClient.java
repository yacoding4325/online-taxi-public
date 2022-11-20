package com.yacoding.serviceprice.remote;

import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.ForecastPriceDTO;
import com.yacoding.internalcommon.responese.DirectionResponse;
import com.sun.javafx.scene.traversal.Direction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-map")
public interface ServiceMapClient {

    @RequestMapping(method = RequestMethod.GET,value = "/direction/driving")
    public ResponseResult<DirectionResponse> direction(@RequestBody ForecastPriceDTO forecastPriceDTO);
}
