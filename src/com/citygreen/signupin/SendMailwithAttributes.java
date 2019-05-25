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

public class SendMailwithAttributes extends Thread {
	
	String tomail, name, voln_name;
	
	public SendMailwithAttributes(String tomail, String name) {
		this.tomail = tomail;
		this.name= name;
	}
	
	@Override
	public void run() {
		
		Mailsend();
		
	}
	
public void Mailsend() {
		
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
			message.setSubject("Details Updated - City Green");
			message.setText("Greetings to "+name+" ,thanks for Participating in Planting Trees. \n\n your details has been received by City Green team . . .\n\n Thanks&Regards \n\n City Green");
			
			Transport.send(message);
			System.out.println("Message sent Succesfully");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static void main(String[] args) {
	
		SendMailwithAttributes sma = new SendMailwithAttributes("poornima.thota31@gmail.com", "Poornima");
		sma.start();
		/*"sateeshreddy.leburu@gmail.com", "Sateesh & Sharma", "Poornima"*/
}

}
