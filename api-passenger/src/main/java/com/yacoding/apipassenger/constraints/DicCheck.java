package com.yacoding.apipassenger.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author yaCoding
 * @create 2023-10-04 下午 1:12
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DicCheckValidator.class)
public @interface DicCheck {
    /**
     * 车辆类型的选项
     * @return
     */
    String[] dicValue() default {};

    /**
     * 提示信息
     * @return
     */
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

