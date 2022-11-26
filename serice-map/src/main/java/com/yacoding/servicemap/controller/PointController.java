package com.yacoding.servicemap.controller;

import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.PointRequest;
import com.yacoding.servicemap.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    PointService pointService;

    @PostMapping("/upload")
    public ResponseResult upload(@RequestBody PointRequest pointRequest){
        return pointService.upload(pointRequest);
    }

}
