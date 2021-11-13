package com.bartosz.gameteststudio.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bartosz.gameteststudio.beans.UserBean;

public abstract class Mailer {

	private static String from = "gameteststudiomail@gmail.com";
    private static String emailPassword = "Pa$$word1!"; 
    
    private static Properties properties = new Properties() {
		private static final long serialVersionUID = -9188315792919800888L;
		{
			put("mail.smtp.host", "smtp.gmail.com");
			put("mail.smtp.socketFactory.port", "465");
			put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			put("mail.smtp.auth", "true");
			put("mail.smtp.port", "465");
    	}
    }; 
    

    public static void sendNewAccountMail(UserBean user,String password) { 	
        
		String body = "Hello " + user.getFirstName() + " " + user.getLastName() + 
 			", your password to Game Test Studio is: " + password + " \nYour Role is: " + user.getRole().getName() + 
 			"\nTo confim Your email addres, please click at this link: http://localhost:8080/GameTestStudio/confirmEmail?itemID=" + user.getId(); 
	
		try {
           Session emailSession = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                 protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, emailPassword);
                 }
              }
           );

           Message message = new MimeMessage(emailSession);
           message.setFrom(new InternetAddress(from));
           message.setRecipients(Message.RecipientType.TO, 
              InternetAddress.parse(user.getEmail()));
           message.setSubject("Game Test Studio Password!");
           message.setText(body);
           Transport.send(message);
        } catch(Exception e) {
           e.printStackTrace();
        }
    } 
}
