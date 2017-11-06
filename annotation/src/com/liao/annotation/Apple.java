package com.liao.annotation;

/**
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-6 下午1:28
 */
public class Apple {
	@FruitName("apple")
	public String name;

	@FruitColor(value = FruitColor.Color.GREEN)
	public String color;
}
