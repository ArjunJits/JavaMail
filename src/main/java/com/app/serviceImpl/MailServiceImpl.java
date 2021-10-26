package com.app.serviceImpl;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.app.service.MailService;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
	private JavaMailSender javaMailsender;
	
	@Override
	public void sendEmail(String senderEmail, String recieverEmail, 
			String subject, String message) {
		MimeMessagePreparator mimeMessage = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				mimeMessage.setFrom(senderEmail);
				mimeMessage.setRecipient(Message.RecipientType.TO,
						 new InternetAddress(recieverEmail));
				mimeMessage.setSubject(subject);
				mimeMessage.setText(message);
			}
		};
		
		try {
			javaMailsender.send(mimeMessage);
			System.out.println("Mail sent success to Keerthana Reddy Banda");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
