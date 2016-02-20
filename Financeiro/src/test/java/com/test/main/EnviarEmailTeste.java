package com.test.main;

import com.outjected.email.api.MailMessage;
import com.outjected.email.impl.MailMessageImpl;
import com.outjected.email.impl.SimpleMailConfig;

public class EnviarEmailTeste {

   public static void main(String[] args) {
      SimpleMailConfig config = new SimpleMailConfig();
      config.setServerHost("smtp.mandrillapp.com");
      config.setServerPort(587);
      config.setEnableSsl(false);
      config.setEnableTls(true);
      config.setAuth(true);
      config.setUsername("carlosync@gmail.com");
      config.setPassword("nQeSl6MJBNg7Sdxynhpsgg");

      MailMessage message = new MailMessageImpl(config);

      message.from("carlosync@gmail.com")
              .to("carlosaurelio.assis@outlook.com")
              .subject("Seus Lançamentos - E-gestor")
              .bodyHtml("<h1>Seus Lançamentos</h1>"
                      + "Valor total: <strong>R$ 300,00</strong>").send();
   }
}
