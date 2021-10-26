package com.app.service;

public interface MailService {
public void sendEmail(final String senderEmail,final String recieverEmail,
		final String subject ,final String message);
}
