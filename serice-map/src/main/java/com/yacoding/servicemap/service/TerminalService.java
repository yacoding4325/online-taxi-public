package com.yacoding.servicemap.service;

import com.yacoding.internalcommon.constant.AmapConfigConstants;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.responese.TerminalResponse;
import com.yacoding.internalcommon.responese.TrsearchResponse;
import com.yacoding.servicemap.remote.TerminalClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TerminalService {

    @Autowired
    TerminalClient terminalClient;

    /**
     * 添加数据
     * @param name
     * @param desc
     * @return
     */
    public ResponseResult<TerminalResponse> add(String name , String desc){

        return terminalClient.add(name , desc);
    }

    /**
     * 终端搜索
     * @param center
     * @param radius
     * @return
     */
    public ResponseResult<List<TerminalResponse>> aroundsearch(String center, Integer radius){

        return terminalClient.aroundsearch(center,radius);
    }

    /**
     * 轨迹查询
     * @param tid
     * @param starttime
     * @param endtime
     * @return
     */
    public ResponseResult<TrsearchResponse> trsearch(String tid , Long starttime , Long endtime){

        return terminalClient.trsearch(tid,starttime,endtime);
    }

}
