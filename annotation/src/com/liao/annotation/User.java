package com.liao.annotation;

import java.lang.annotation.*;

/**
 * @author hongyangliao
 * @ClassName: User
 * @Date 17-11-3 下午4:15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface User {
	String value() default "张三";
}
