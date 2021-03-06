package com.bartosz.gameteststudio.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bartosz.gameteststudio.beans.UserBean;

/**
 * Klasa obsługująca wysyłkę e-mail.
 * @author Bartosz
 *
 */
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
    
    /**
     * Metoda zwraca treść wiadomości dla nowego użytkownika.
     * @param user
     * @return
     */
    private static String newAccountMailBody(UserBean user) {
    	return "Hello " + user.getFirstName() + " " + user.getLastName() + 
     			" \nYour Role is: " + user.getRole().getName() + 
     			"\nTo set your password to Game Test Studio and activate your account" +
     			" please click at this link:\n http://localhost:8080/GameTestStudio/confirmEmail?hash="
     			+ user.getHashKey() + 
     			"\n\nSincerely,\nGame Test Studio";
    }
    
    /**
     * Metoda zwraca treść wiadomości dla odzyskiwania hasła.
     * @param userHash
     * @return
     */
    private static String resetPasswordMailBody(String userHash) {
    	return "Hello, " +
     			"to reset your password, please click at this link: "
     			+ "http://localhost:8080/GameTestStudio/confirmEmail?hash=" +  userHash + 
     			"\n\nSincerely,\nGame Test Studio";
    }
    
    /**
     * Metoda zwraca treść wiadomości informującej o zmianie hasła. 
     * @param user
     * @return
     */
    private static String passwordChangeMailBody(UserBean user) {
    	return "Hello " + user.getFirstName() + " " + user.getLastName() + " \nYour password has been changed." + 
    			"\n If it was your action, please ignore this email.\nIf it was not Your action, plase contact "
    			+ "system administrator.\n\nSincerely,\nGame Test Studio";
    }
   
    /**
     * Metoda odpowida za wysłanie e-maila informującego o zmianie hasła. 
     * @param user
     */
    public static void sendPasswordChangeMail(UserBean user) { 	
		String body = passwordChangeMailBody(user);
		sendMail(body, user.getEmail(), "Game Test Studio - Password change.");
    } 
    
    /**
     * Metoda odpowida za wysłanie e-maila potwierdzenia i aktywacji konta. 
     * @param user
     */
    public static void sendNewAccountMail(UserBean user) { 	
		String body = newAccountMailBody(user);
		
		sendMail(body, user.getEmail(), "Game Test Studio - Confirm email adress.");
    } 
    
    /**
     * Metoda odpowida za wysłanie e-maila w celu odzyskania hasła. 
     * @param user
     */
    public static void sendResetPasswordEmail(UserBean user) {
    	String body = resetPasswordMailBody(user.getHashKey());
    	
    	sendMail(body,user.getEmail(), "Game Test Studio - Verify email adress.");
    } 
    
    /**
     * Metoda wysyła e-mail o podanej treści i tytule na podany adres.
     * @param body
     * @param adress
     * @param subject
     */
    private static void sendMail(String body, String adress, String subject) {
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
               InternetAddress.parse(adress));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
         } catch(Exception e) {
            e.printStackTrace();
         }
    }
}
