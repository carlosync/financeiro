package com.finaceiro.mail;

import com.outjected.email.api.MailMessage;
import com.outjected.email.api.SessionConfig;
import com.outjected.email.impl.MailMessageImpl;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class Mailer implements Serializable{

   @Inject
   private SessionConfig mailConfig;
   
   public MailMessage novaMensagem(){
      return new MailMessageImpl(this.mailConfig);
   }
}
