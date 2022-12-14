package com.yacoding.servicemap.service;

import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.responese.ServiceResponse;
import com.yacoding.servicemap.remote.ServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceFromMapService {

    @Autowired
    private ServiceClient serviceClient;


    /**
     * 创建服务
     * @param name
     * @return
     */
    public ResponseResult add(String name){

        return serviceClient.add(name);

    }
}
