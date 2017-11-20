package com.liao.framework.rabbitmq;

import com.liao.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 生产者
 *
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-15 上午10:01
 */
@Component
public class HelloSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(User user) {
		//String message = "hello" + i + new Date().toString();
		//amqpTemplate.convertAndSend("hello", message);
		amqpTemplate.convertAndSend("hello", user);
	}
}
