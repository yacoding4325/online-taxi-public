package com.yacoding.apipassenger.controller;

import com.yacoding.apipassenger.service.OrderService;
import com.yacoding.internalcommon.constant.CommonStatusEnum;
import com.yacoding.internalcommon.constant.IdentityConstants;
import com.yacoding.internalcommon.dto.OrderInfo;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.dto.TokenResult;
import com.yacoding.internalcommon.request.OrderRequest;
import com.yacoding.internalcommon.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @Author yaCoding
 * @create 2022-11-27 下午 2:07
 */

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 创建订单/下单
     * @return
     */
    @PostMapping("/add")
    public ResponseResult add(@Validated @RequestBody OrderRequest orderRequest){
        System.out.println(orderRequest);
//        return ResponseResult.fail(9,"参数校验通过");
        return orderService.add(orderRequest);
    }

    /**
     * 乘客创建预约单
     * @return
     */
    @PostMapping("/book")
    public ResponseResult book(@Validated @RequestBody OrderRequest orderRequest){
        return orderService.book(orderRequest);
    }

    /**
     * 乘客取消订单
     * @param orderId
     * @return
     */
    @PostMapping("/cancel")
    public ResponseResult cancel(@NotNull(message = "订单id不能为空") @Positive(message = "订单id格式不正确")  Long orderId){
        return orderService.cancel(orderId);
    }

    @GetMapping("/detail")
    public ResponseResult<OrderInfo> detail(@NotNull(message = "订单id不能为空") @Positive(message = "订单id格式不正确") Long orderId){
        return orderService.detail(orderId);
    }

    @GetMapping("/current")
    public ResponseResult<OrderInfo> currentOrder(HttpServletRequest httpServletRequest){
        String authorization = httpServletRequest.getHeader("Authorization");
        TokenResult tokenResult = JwtUtils.parseToken(authorization);
        String identity = tokenResult.getIdentity();
        if (!identity.equals(IdentityConstants.PASSENGER_IDENTITY)){
            return ResponseResult.fail(CommonStatusEnum.TOKEN_ERROR.getCode(),CommonStatusEnum.TOKEN_ERROR.getValue());
        }
        String phone = tokenResult.getPhone();
        return orderService.currentOrder(phone,IdentityConstants.PASSENGER_IDENTITY);
    }

}
