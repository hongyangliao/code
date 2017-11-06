package com.liao.annotation;

import org.junit.Test;


/**
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-6 下午2:14
 */
public class TestMain {
	@Test
	public void show() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
		Class clazz = Class.forName("com.liao.annotation.Apple");
		AnnotationHandler.handle(clazz);
	}
}
