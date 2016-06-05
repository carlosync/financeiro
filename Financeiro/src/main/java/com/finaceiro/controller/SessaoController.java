package com.finaceiro.controller;

import com.financeiro.model.Usuario;
import com.financeiro.service.FacesUtil;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

@Named
@ViewScoped
public class SessaoController implements Serializable {

   private static final long serialVersionUID = 1L;

   public void verificarSessao() throws Exception {
      try {
         FacesContext context = FacesContext.getCurrentInstance();
         Usuario usuarioSesao = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
         if (usuarioSesao == null) {
            context.getExternalContext().redirect("login.xhtml");
         }
      } catch (Exception e) {
         throw new Exception(e.getMessage());
      }
   }

   public String logout() throws ServletException {
      FacesContext fc = FacesContext.getCurrentInstance();
      ExternalContext ex = fc.getExternalContext();
      HttpSession session = (HttpSession) ex.getSession(false);
      session.invalidate();
      return FacesUtil.redirect("login.xhtml");
   }

}
