package com.liao.javamail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * 邮件详解
 *
 * @author hongyangliao
 * @ClassName: MailTest
 * @Date 18-1-26 下午3:17
 */
public class MailTest {
    public static void main(String[] args) throws MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", "smtp.163.com");
        Session session = Session.getInstance(properties);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("hongyangliao163@163.com"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("1454275545@qq.com"));
        message.setSubject("这是邮件的主题");
        //message.setContent("这是邮件的正文");
        MimeMultipart mimeMultipart = new MimeMultipart();
        BodyPart text = new MimeBodyPart();
        text.setText("这是邮件的正文");
        BodyPart image = new MimeBodyPart();
        DataHandler dataHandler = new DataHandler(new FileDataSource("/home/hongyangliao/Pictures/21017339.png"));
        image.setDataHandler(dataHandler);
        mimeMultipart.addBodyPart(text);
        mimeMultipart.addBodyPart(image);
        mimeMultipart.setSubType("related");
        MimeBodyPart text_image = new MimeBodyPart();
        text_image.setContent(mimeMultipart);
        BodyPart attachment = new MimeBodyPart();
        DataHandler attachmentDataHandler = new DataHandler(new FileDataSource("/home/hongyangliao/Pictures/Linux命令壁纸.rar"));
        attachment.setDataHandler(attachmentDataHandler);
        MimeMultipart mimeMultipart1 = new MimeMultipart();
        mimeMultipart1.addBodyPart(text_image);
        mimeMultipart1.addBodyPart(attachment);
        mimeMultipart1.setSubType("mixed");
        message.setContent(mimeMultipart1);
        Transport transport = session.getTransport();
        transport.connect("hongyangliao163@163.com", "xxxxxx");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
