package org.cn.kkl.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Sender {
	
	private JavaMailSender javaMailSender;

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	/**
	 * @description 
	 * 1. create mimeMessage
	 * 2. wrap mimeMessage use mail wrap tool
	 * 2. set sender
	 * 3. set receiver
	 * 4. set title
	 * 5. set content
	 * 6. invoke javaMailSender instance send email method  send mail
	 */
	public void sendMail(){
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
		try {
			messageHelper.setFrom("fadali@zoho.com.cn");
		} catch (MessagingException e) {
			System.out.println("set mail sender exception");
			e.printStackTrace();
		}
		try {
			messageHelper.setTo("kukulonggg@hotmail.com");
		} catch (MessagingException e) {
			System.out.println("set mail receiver exception");
			e.printStackTrace();
		}
		try {
			messageHelper.setSubject("mail test");
		} catch (MessagingException e1) {
			System.out.println("set mail title(subject) exception");
			e1.printStackTrace();
		}
		try {
			messageHelper.setText("this is java code send mail,please check ok");
		} catch (MessagingException e) {
			System.out.println("set mail content(text) exception");
			e.printStackTrace();
		}
		javaMailSender.send(mimeMessage);
		
	}

}
