package org.example;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandlerBase {

    public static void senMail(String emailBody){

        Properties sysProperties = System.getProperties();

        sysProperties.put("mail.smtp.host","smtp.gmail.com");
        sysProperties.put("mail.smtp.port","465");
        sysProperties.put("mail.smtp.ssl.enable","true");
        sysProperties.put("mail.smtp.auth","true");

        Authenticator mailAuthenticator = new CustomizezAuthenticator();

        Session mailSession = Session.getInstance(sysProperties,mailAuthenticator);

        MimeMessage mailMessage = new MimeMessage(mailSession);

        try{
            mailMessage.setFrom("sandeshkawatwad6@gmail.com");
            mailMessage.setSubject("Hi i am Sandesh");
            mailMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("laxmankawatwad@gmail.com"));
            mailMessage.setText(emailBody);

            Transport.send(mailMessage);

            System.out.println("mail sent !!!!!");
        }
            catch (Exception e){
                System.out.println("ERROR");
                System.out.println(e.getMessage());
            }
    }
}
