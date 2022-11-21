package com.yacoding.servicemap.service;

import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.responese.TrackResponse;
import com.yacoding.servicemap.remote.TrackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {

    @Autowired
    TrackClient trackClient;

    public ResponseResult<TrackResponse> add(String tid){

        return trackClient.add(tid);
    }
}
