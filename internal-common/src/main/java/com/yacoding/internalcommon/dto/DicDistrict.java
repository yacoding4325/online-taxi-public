package com.yacoding.internalcommon.dto;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-11-20 下午 4:11
 */

@Data
public class DicDistrict {

    private String addressCode;

    private String addressName;

    private String parentAddressCode;

    private Integer level;

}
