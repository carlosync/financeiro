package com.finaceiro.controller;

import com.finaceiro.mail.Mailer;
import com.financeiro.ejb.LancamentoFacadeLocal;
import com.financeiro.service.FacesUtil;
import com.outjected.email.api.MailMessage;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EnvioEmailController implements Serializable {

   private static final long serialVersionUID = 1L;

   @Inject
   private Mailer mailer;
   
   @EJB
   private LancamentoFacadeLocal lancamentoFacadeLocal;
   
   private BigDecimal valor;
   private String email;

   @PostConstruct
   public void init(){
      this.valor = lancamentoFacadeLocal.valorTotal();
   }
   
   public void enviarLancamento() {
      MailMessage message = mailer.novaMensagem();
      message.from("carlosync@gmail.com")
              .to(email)
              .subject("E-gestor - Seus Lançamentos")
              .bodyHtml("<h1>Lançamento Gerado para você</h1>"
                      + "Prezado,"
                      + " Valor Total: R$ " + this.valor + " Agradecemos sua preferência.").send();
      this.email = new String();
      FacesUtil.addInfoMessage("E-mail enviado com sucesso.");

   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public BigDecimal getValor() {
      return valor;
   }

   public void setValor(BigDecimal valor) {
      this.valor = valor;
   }

   
}
