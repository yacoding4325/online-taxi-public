package com.yacoding.apipassenger.interceptor;

import com.yacoding.internalcommon.constant.CommonStatusEnum;
import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @Author yaCoding
 * @create 2023-10-04 下午 12:55
 */
//异常处理类
@RestControllerAdvice
@Order(1)
public class GlobalValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult validationExceptionHandler(MethodArgumentNotValidException e){
        e.printStackTrace();
        return ResponseResult.fail(CommonStatusEnum.VALIDATION_EXCEPTION.getCode(),e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult ConstraintValidationExceptionHandler(ConstraintViolationException e){
        e.printStackTrace();
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        String message = "";
        for (ConstraintViolation c: constraintViolations ) {
            message = c.getMessage();
        }
        return ResponseResult.fail(CommonStatusEnum.VALIDATION_EXCEPTION.getCode(),message);
    }

}
