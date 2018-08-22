package org.cn.kkl.mail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSender {

	private ApplicationContext applicationContext;
	private Sender sender;

	@Before
	public void init(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext_mail.xml");
		sender = applicationContext.getBean(Sender.class);
	}
	
	@Test
	public void send(){
		sender.sendMail();
	}
}
