package com.yacoding.internalcommon.responese;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-11-24 下午 6:55
 */

@Data
public class DriverUserExistsResponse {

    private String driverPhone;

    private int ifExists;

}
