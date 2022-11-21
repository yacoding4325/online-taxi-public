package com.yacoding.internalcommon.responese;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-11-20 下午 4:10
 */

@Data
public class TerminalResponse {

    private String tid;

    private Long carId;

    private String longitude ;

    private String latitude ;
}

