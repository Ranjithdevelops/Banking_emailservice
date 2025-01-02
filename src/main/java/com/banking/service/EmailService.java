package com.banking.service;


import java.util.Properties;
import java.util.Random;

import javax.mail.*; 
import javax.mail.internet.*;  
import javax.mail.Session; 
import javax.mail.Transport; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.banking.model.EmailConfig;



@Service
public class EmailService {

	@Autowired
	private EmailConfig emailConfig;
	@KafkaListener(topics = "email-verification-code-topic",groupId = "email-group")
	public void generateEmail(String email) {
		Properties emailproperties=new Properties();
		emailproperties.put("mail.smtp.host", emailConfig.getHost());
        emailproperties.put("mail.smtp.port", emailConfig.getPort());
        emailproperties.put("mail.smtp.auth", "true");
        emailproperties.put("mail.smtp.starttls.enable", "true");
        Random random=new Random();
        // Create a session with authentication
        Session session = Session.getInstance(emailproperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailConfig.getUsername(), emailConfig.getPassword());
            }
        });

        try {
            // Create an email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailConfig.getUsername()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(emailConfig.getSubject());
            message.setText(emailConfig.getMessage()+": "+(100000+random.nextInt(900000)));

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Error while sending email: " + e.getMessage());
        }
	}
}
