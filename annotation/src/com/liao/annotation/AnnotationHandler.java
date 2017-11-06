package com.liao.annotation;

import java.lang.reflect.Field;

/**
 * 注解处理器
 *
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-6 下午2:32
 */
public class AnnotationHandler {

	public static void handle(Class clazz) throws NoSuchFieldException, IllegalAccessException {
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = field.getAnnotation(FruitName.class);
				System.out.println(fruitName.value());
			}

			if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = field.getAnnotation(FruitColor.class);
				System.out.println(fruitColor.value());
			}
		}
	}
}
