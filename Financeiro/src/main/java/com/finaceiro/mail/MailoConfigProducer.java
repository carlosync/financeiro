package com.finaceiro.mail;

import com.outjected.email.api.SessionConfig;
import com.outjected.email.impl.SimpleMailConfig;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class MailoConfigProducer {

   @Produces
   @ApplicationScoped
   public SessionConfig getMailConfig() {
      SimpleMailConfig config = new SimpleMailConfig();
      config.setServerHost("smtp.mandrillapp.com");
      config.setServerPort(587);
      config.setEnableSsl(false);
      config.setEnableTls(true);
      config.setAuth(true);
      config.setUsername("carlosync@gmail.com");
      config.setPassword("nQeSl6MJBNg7Sdxynhpsgg");
      return config;
   }
}
