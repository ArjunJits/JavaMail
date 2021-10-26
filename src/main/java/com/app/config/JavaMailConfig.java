package com.app.config;

import java.util.Properties;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
//@PropertySource("classpath:google-mail.properties")
@ComponentScan(basePackages = "com.app.serviceImpl")
public class JavaMailConfig {
  
    @SuppressWarnings("null")
	@Bean
	public JavaMailSender javaMailSender()
	{
		JavaMailSenderImpl mailSender= new JavaMailSenderImpl();
		Properties mailprops = null;
		// host and port details
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		
		//user name and password
		mailSender.setUsername("mallikpdr@gmail.com");
		mailSender.setPassword("testtest");	    	    		
		
		mailprops= new Properties();
		mailprops.put("mail.transport.protocol", "smtp");
	    mailprops.put("mail.smtp.auth", "true");
	    mailprops.put("mail.smtp.starttls.enable", "true");
	    mailprops.put("mail.debug", "true");
	    mailSender.setJavaMailProperties(mailprops);
		return mailSender;
	}

}
