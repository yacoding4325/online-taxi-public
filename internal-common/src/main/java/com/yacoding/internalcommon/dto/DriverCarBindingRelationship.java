package com.yacoding.internalcommon.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author yaCoding
 * @create 2022-11-24 上午 11:51
 */

@Data
public class DriverCarBindingRelationship implements Serializable {

    private Long id;

    /**
     * 司机id
     */
    private Long driverId;

    /**
     * 车辆Id
     */
    private Long carId;

    /**
     * 绑定状态：1：绑定，2：解绑
     */
    private Integer bindState;

    /**
     * 绑定时间
     */
    private LocalDateTime bindingTime;

    /**
     * 解绑时间
     */
    private LocalDateTime unBindingTime;

}
