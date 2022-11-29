package com.yacoding.internalcommon.responese;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-11-29 下午 10:02
 */

@Data
public class OrderDriverResponse {

    private Long driverId;

    private String driverPhone;

    private Long carId;

    /**
     * 机动车驾驶证号
     */
    private String licenseId;

    /**
     * 车辆号牌
     */
    private String vehicleNo;

    /**
     * 车辆类型
     */
    private String vehicleType;

}
