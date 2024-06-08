package org.example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomizezAuthenticator extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication("sandeshkawatwad6@gmail.com"," ");
    }

}
