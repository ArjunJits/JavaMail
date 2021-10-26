package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.app.config.JavaMailConfig;
import com.app.service.MailService;
import com.app.serviceImpl.MailServiceImpl;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new 
				AnnotationConfigApplicationContext(JavaMailConfig.class);
	MailService mailService = context.getBean(MailServiceImpl.class);
	String senderEmail = "mallikpdr@gmail.com";
	String recipientEmail = "keerthanareddy139@gmail.com";
	String subject="Sample Test message from Nani ";
	String message="Hello Bangu How are you from Nani Java mail testing";
	mailService.sendEmail(senderEmail, recipientEmail, subject, message);
	
  
	}

}
