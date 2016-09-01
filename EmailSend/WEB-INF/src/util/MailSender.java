package util;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Message.RecipientType;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;

public class MailSender{
	public static void sendMail(String toEmails, String msg){
		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new GmailAuthenticator());

		Message message = new MimeMessage(session);

		try{
			message.setFrom(new InternetAddress("ganeshji22922@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmails));
			message.setSubject("Hello.. Java people... mail sender");
			message.setText(msg);

			Transport.send(message);
		}catch(AddressException e){
			e.printStackTrace();
		}catch(MessagingException e){
			e.printStackTrace();	
		}		
	}
}

class GmailAuthenticator extends Authenticator{
	public PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication("ganeshji22922@gmail.com","Krishna2992");
	}
}