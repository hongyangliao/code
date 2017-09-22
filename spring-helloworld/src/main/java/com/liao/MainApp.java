package com.liao;

import com.liao.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	@Test
	public void show() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
		User user = context.getBean("com.liao.model.User",User.class);
	}
}
