package com.liao.annotation;

import java.lang.annotation.*;

/**
 * 水果名字注解类
 *
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-6 下午1:19
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitName {
	String value() default "";
}
