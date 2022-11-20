package com.yacoding.internalcommon.responese;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-11-20 下午 3:07
 */
//预测价格响应
@Data
public class ForecastPriceResponse {

    private double price;

    private String cityCode;

    private String vehicleType;

    private String fareType;

    private Integer fareVersion;

}
