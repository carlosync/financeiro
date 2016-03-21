package com.finaceiro.mail;

import com.outjected.email.api.MailMessage;
import com.outjected.email.api.SessionConfig;
import com.outjected.email.impl.MailMessageImpl;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class Mailer implements Serializable{

   private static final long serialVersionUID = 1L;

   @Inject
   private SessionConfig mailConfig;
   
   public MailMessage novaMensagem(){
      return new MailMessageImpl(this.mailConfig);
   }
}
