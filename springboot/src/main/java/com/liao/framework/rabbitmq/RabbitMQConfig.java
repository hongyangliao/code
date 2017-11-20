package com.liao.framework.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ设置
 *
 * @author hongyangliao
 * @ClassName: RabbitMQConfig
 * @Date 17-11-15 上午9:57
 */
@Configuration
public class RabbitMQConfig {

	@Bean
	public Queue queue() {
		return new Queue("hello");
	}
}
