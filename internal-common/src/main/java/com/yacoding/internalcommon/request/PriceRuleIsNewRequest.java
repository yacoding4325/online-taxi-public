package com.yacoding.internalcommon.request;

import lombok.Data;

/**
 * @Author yaCoding
 * @create 2022-11-20 下午 3:42
 */
//价格规则是新请求
@Data
public class PriceRuleIsNewRequest {

    private String fareType;

    private Integer fareVersion;
}