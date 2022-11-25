package com.yacoding.serviceDriverUser.service;

import com.yacoding.internalcommon.dto.Car;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.responese.TerminalResponse;
import com.yacoding.internalcommon.responese.TrackResponse;
import com.yacoding.serviceDriverUser.mapper.CarMapper;
import com.yacoding.serviceDriverUser.remote.ServiceMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Author yaCoding
 * @create 2022-11-24 上午 10:08
 */
@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private ServiceMapClient serviceMapClient;

    public ResponseResult addCar(Car car) {
        LocalDateTime now = LocalDateTime.now();
        car.setGmtModified(now);
        car.setGmtCreate(now);
        //保存车辆
        carMapper.insert(car);

        // 获得此车辆的终端id：tid
        ResponseResult<TerminalResponse> responseResult = serviceMapClient.addTerminal(car.getVehicleNo(), car.getId()+"");
        String tid = responseResult.getData().getTid();
        car.setTid(tid);

        //获得此车辆 的轨迹id ：trid
        ResponseResult<TrackResponse> trackResponseResponseResult = serviceMapClient.addTrack(tid);
        String trid = trackResponseResponseResult.getData().getTrid();
        String trname = trackResponseResponseResult.getData().getTrname();
        car.setTrid(trid);
        car.setTrname(trname);
        carMapper.updateById(car);
        return ResponseResult.success("");
    }
}
