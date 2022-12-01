package com.yacoding.serviceDriverUser.controller;

import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.serviceDriverUser.service.CityDriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-12-01 下午 1:37
 */

@RestController
@RequestMapping("/city-driver")
public class CityDriverController {

    @Autowired
    CityDriverUserService cityDriverUserService;

    /**
     * 根据城市码查询当前城市是否有可用司机
     * @param cityCode
     * @return
     */
    @GetMapping("/is-alailable-driver")
    public ResponseResult isAvailableDriver(String cityCode){
        return cityDriverUserService.isAvailableDriver(cityCode);
    }

}
