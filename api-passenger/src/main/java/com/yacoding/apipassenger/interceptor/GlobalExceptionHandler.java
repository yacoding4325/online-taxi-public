package com.yacoding.apipassenger.interceptor;

/**
 * @Author yaCoding
 * @create 2023-10-04 下午 1:50
 */

import com.yacoding.internalcommon.constant.CommonStatusEnum;
import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理类
 */
@RestControllerAdvice
@Order(99)
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e){

        e.printStackTrace();
        return ResponseResult.fail(CommonStatusEnum.FAIL.getCode(),CommonStatusEnum.FAIL.getValue());
    }

}
