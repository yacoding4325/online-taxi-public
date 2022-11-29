package com.yacoding.serviceorder.service;

import com.yacoding.internalcommon.constant.CommonStatusEnum;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.request.OrderRequest;
import com.yacoding.internalcommon.request.PriceRuleIsNewRequest;
import com.yacoding.internalcommon.util.RedisPrefixUtils;
import com.yacoding.serviceorder.mapper.OrderInfoMapper;
import com.yacoding.serviceorder.remote.ServiceDriverUserClient;
import com.yacoding.serviceorder.remote.ServicePriceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author yaCoding
 * @create 2022-11-29 下午 7:44
 */

@Service
@Slf4j
public class OrderInfoService {

    @Autowired
    ServiceDriverUserClient serviceDriverUserClient;

    @Autowired
    ServicePriceClient servicePriceClient;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public ResponseResult add(OrderRequest orderRequest) {
        // 测试当前城市是否有可用的司机
        ResponseResult<Boolean> availableDriver = serviceDriverUserClient.isAvailableDriver(orderRequest.getAddress());
        log.info("测试城市是否有司机结果："+availableDriver.getData());
        if (!availableDriver.getData()){
            return ResponseResult.fail(CommonStatusEnum.CITY_DRIVER_EMPTY.getCode(),CommonStatusEnum.CITY_DRIVER_EMPTY.getValue());
        }

        //需要判断计价规则的版本是否为最新
        final PriceRuleIsNewRequest priceRuleIsNewRequest = new PriceRuleIsNewRequest();
        priceRuleIsNewRequest.setFareType(orderRequest.getFareType());
        priceRuleIsNewRequest.setFareVersion(orderRequest.getFareVersion());
        ResponseResult<Boolean> aNew = servicePriceClient.isNew(priceRuleIsNewRequest);
        if (!(aNew.getData())) {
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_CHANGED.getCode(),CommonStatusEnum.PRICE_RULE_CHANGED.getValue());
        }
        // 需要判断 下单的设备是否是 黑名单设备
        if (isBlackDevice(orderRequest)) {
            return ResponseResult.fail(CommonStatusEnum.DEVICE_IS_BLACK.getCode(), CommonStatusEnum.DEVICE_IS_BLACK.getValue());
        }
        return ResponseResult.success();
    }

    /**
     * 是否是黑名单
     * @param orderRequest
     * @return
     */
    private boolean isBlackDevice(OrderRequest orderRequest) {
        String deviceCode = orderRequest.getDeviceCode();
        //生成key
        String deviceCodeKey = RedisPrefixUtils.blackDeviceCodePrefix + deviceCode;
        Boolean aBoolean = stringRedisTemplate.hasKey(deviceCodeKey);
        if (aBoolean) {
            String s = stringRedisTemplate.opsForValue().get(deviceCodeKey);
            int i = Integer.parseInt(s);
            if (i >= 2) {
                //当前设备超过下单次数
                return true;
            } else {
                stringRedisTemplate.opsForValue().increment(deviceCodeKey);
            }
        }else {
            stringRedisTemplate.opsForValue().setIfAbsent(deviceCodeKey,"1",1L, TimeUnit.HOURS);
        }
        return false;
    }

}
