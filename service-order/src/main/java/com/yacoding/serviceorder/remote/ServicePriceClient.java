package com.yacoding.serviceorder.remote;

import com.yacoding.internalcommon.dto.PriceRule;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.PriceRuleIsNewRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author yaCoding
 * @create 2022-11-29 下午 8:31
 */

@FeignClient("service-price")
public interface ServicePriceClient {

    @PostMapping("/price-rule/is-new")
    ResponseResult<Boolean> isNew(@RequestBody PriceRuleIsNewRequest priceRuleIsNewRequest);

    @RequestMapping(method = RequestMethod.GET,value = "/price-rule/if-exists")
    ResponseResult<Boolean> ifPriceExists(@RequestBody PriceRule priceRule);
}
