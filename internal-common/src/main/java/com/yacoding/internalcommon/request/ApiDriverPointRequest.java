package com.yacoding.internalcommon.request;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-11-26 下午 2:25
 */

@Data
public class ApiDriverPointRequest {

    public Long carId;

    private PointDTO[] points;

}

