package com.liao.framework.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 邮件服务实现类
 *
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-15 下午5:02
 */
@Component
public class MailServiceImpl implements MailService {
	private final Logger logger = LoggerFactory.getLogger(MailService.class);

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${mail.fromMail.addr}")
	private String from;

	@Override
	public void sendMail(String to, String subject, String content) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(from);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);
		try {
			javaMailSender.send(simpleMailMessage);
			logger.info("邮件发送成功");
		} catch (Exception e) {
			logger.info("邮件发送失败:" + e.getMessage());
		}
	}
}
