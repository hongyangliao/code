package com.liao.annotation;

import java.lang.annotation.*;

/**
 * 水果颜色注解类
 *
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-6 下午1:22
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FruitColor {
	enum Color {
		RED,
		GREEN,
		BLUE
	}

	Color value() default Color.RED;
}

