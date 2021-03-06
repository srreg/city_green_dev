package com.citygreen.signupin;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailForgetPassword {
	
public void Mailsend(String tomail, int random_number) {
		
		final String senderEmail = "srlebreddy@gmail.com";
		final String password = "Admin@123";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(prop, 
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderEmail, password);
				}
					});
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress("srlebreddy@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tomail));
			message.setSubject("Verification Mail from City Green");
			message.setText("Here is Verfication number for Password Reset: "+random_number);
			
			Transport.send(message);
			System.out.println("Message sent Succesfully");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}

}
