package com.yacoding.serviceDriverUser.controller;

import com.yacoding.internalcommon.dto.DriverUserWorkStatus;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.serviceDriverUser.service.DriverUserWorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-11-25 下午 3:21
 */

//前端控制器
@RestController
public class DriverUserWorkStatusController {

    @Autowired
    DriverUserWorkStatusService driverUserWorkStatusService;

    @RequestMapping("/driver-user-work-status")
    public ResponseResult changeWorkStatus(@RequestBody DriverUserWorkStatus driverUserWorkStatus) {
        return driverUserWorkStatusService.changeWorkStatus(driverUserWorkStatus.getDriverId(),driverUserWorkStatus.getWorkStatus());
    }

}
