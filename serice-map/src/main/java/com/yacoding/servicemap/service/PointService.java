package com.yacoding.servicemap.service;

import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.PointRequest;
import com.yacoding.servicemap.remote.PointClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PointService {

    @Autowired
    PointClient pointClient;

    public ResponseResult upload(PointRequest pointRequest){
        return pointClient.upload(pointRequest);
    }

}
