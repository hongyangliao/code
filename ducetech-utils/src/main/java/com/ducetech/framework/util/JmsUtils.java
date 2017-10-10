package com.ducetech.framework.util;

import org.apache.activemq.ScheduledMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.io.Serializable;

/**
 * Jms工具类
 *
 * @ClassName: JmsUtils
 * @Date 17-10-10 下午3:33
 */
public class JmsUtils {

	/**
	 * 发送文本消息
	 *
	 * @param jmsTemplate JmsTemplate对象
	 * @param destination Destination对象
	 * @param textMessage 文本消息
	 * @return void
	 * @throws
	 * @Title: sendMessage
	 * @Date: 17-10-10 下午3:34
	 */
	public static void sendMessage(JmsTemplate jmsTemplate, Destination destination, final String textMessage) {
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(textMessage);
			}
		});
	}

	/**
	 * 发送对象消息
	 *
	 * @param jmsTemplate   JmsTemplate对象
	 * @param destination   Destination对象
	 * @param objectMessage 对象消息
	 * @return void
	 * @throws
	 * @Title: sendMessage
	 * @Date: 17-10-10 下午3:35
	 */
	public static void sendMessage(JmsTemplate jmsTemplate, Destination destination, final Serializable objectMessage) {
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(objectMessage);
			}
		});
	}

	/**
	 * 延迟发送对象消息
	 *
	 * @param jmsTemplate   JmsTemplate对象
	 * @param destination   Destination对象
	 * @param objectMessage 对象消息
	 * @param delay         延迟时间,单位ms
	 * @return void
	 * @throws
	 * @Title: sendMessageDelay
	 * @Date: 17-10-10 下午3:37
	 */
	public static void sendMessageDelay(JmsTemplate jmsTemplate, Destination destination, final Serializable objectMessage, final long delay) {
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage om = session.createObjectMessage(objectMessage);
				om.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
				om.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, 1*1000);
				om.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, 1);
				return om;
			}
		});
	}
}
