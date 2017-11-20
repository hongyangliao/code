package com.liao.framework.mail;

/**
 * 邮件服务接口
 *
 * @author hongyangliao
 * @ClassName: MailService
 * @Date 17-11-15 下午5:04
 */
public interface MailService {
	/**
	 * 发送邮件
	 *
	 * @param to 发送地址
	 * @param subject 主题
	 * @param content 内容
	 * @return void
	 * @throws
	 * @Title: sendMail
	 * @author: hongyangliao
	 * @Date: 17-11-15 下午5:07
	 */
	void sendMail(String to, String subject, String content);
}
