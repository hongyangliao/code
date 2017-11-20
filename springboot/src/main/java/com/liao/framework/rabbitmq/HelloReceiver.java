package com.liao.framework.rabbitmq;

import com.liao.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * 接收者
 *
 * @author hongyangliao
 * @ClassName: HelloReceiver
 * @Date 17-11-15 上午10:10
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

	@RabbitHandler
	public void process(User user) {
		System.out.println("Receiver:" + user);
	}
}
