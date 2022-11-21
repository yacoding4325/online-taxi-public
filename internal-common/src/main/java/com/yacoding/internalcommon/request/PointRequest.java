package com.yacoding.internalcommon.request;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-11-20 下午 4:09
 */

@Data
public class PointRequest {

    private String tid;

    private String trid;

    private PointDTO[] points;

}
