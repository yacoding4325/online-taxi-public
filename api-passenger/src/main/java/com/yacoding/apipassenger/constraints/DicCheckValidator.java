package com.yacoding.apipassenger.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yaCoding
 * @create 2023-10-04 下午 1:14
 */

public class DicCheckValidator implements ConstraintValidator<DicCheck,Object> {

    private List<String> dicValue = null;

    @Override
    public void initialize(DicCheck constraintAnnotation) {
        dicValue = Arrays.asList(constraintAnnotation.dicValue());
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("自定义注解校验开始");

        if ((s instanceof String) && dicValue.contains(s)){
            return true;
        }
        if ((s instanceof Integer)){
            String str = String.valueOf(s);
            return dicValue.contains(str);
        }
        return false;
    }

}
