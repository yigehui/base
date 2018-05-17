package com.ygh.shop.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;


import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("mailUtil")
public class MailUtilImpl implements MailUtil {
	@Value(value="#{prop.mail}")
	private String mail;
	@Value(value="#{prop.host}")
	private String host;
	@Value(value="#{prop.user}")
	private String user;
	@Value(value="#{prop.pass}")
	private String pass;
	
	/* (non-Javadoc)
	 * @see com.ygh.shop.util.MailUtil#sendMail(int, java.lang.String)
	 */
	public void sendMail(String id, String receiveMail) {
		Properties prop = new Properties();
		Session session = null;
		Message message = null;
		Transport transport = null;
		//1.登录邮件客户端（创建会话）
		prop.setProperty("mail.transport.protocol", "smtp");
		//2.创建一个session会话
		session = Session.getDefaultInstance(prop);
		//设置debug模式
		//session.setDebug(true);
		//3.创建一封邮件
		message = new MimeMessage(session);
		//4.写信
	
		try {
			message.setSubject("订单支付成功邮件");
			message.setContent("订单" + id + "已经支付成功","text/html;charset=UTF-8");
			//5.发件人地址
			message.setFrom(new InternetAddress(mail));
			//6.链接邮件服务器的认证信息
			transport = session.getTransport();
			//7.完成登录工作
			transport.connect(host, user, pass);
			transport.sendMessage(message, new Address[]{new InternetAddress(receiveMail)});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			try {
				transport.close();
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
		
	}

}
