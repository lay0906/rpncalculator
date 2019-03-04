package com.x.ray.rpn.constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 运算符注解
 *
 * @author lay 2019-03-04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OpTypeAnno {
    String opcode() ;
    String desc() default "";
}
