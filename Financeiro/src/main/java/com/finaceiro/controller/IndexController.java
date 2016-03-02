package com.finaceiro.controller;

import com.financeiro.ejb.UsuarioFacadeLocal;
import com.financeiro.model.Usuario;
import com.financeiro.service.FacesUtil;
import com.financeiro.service.RegraNegocioException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable {

   private static final long serialVersionUID = 1L;

    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;

    @Inject
    private Usuario usuario;

    public String iniciarSessao() throws RegraNegocioException {
        Usuario us;
        String redirecionar = null;
        try {
            us = usuarioFacadeLocal.iniciarSessao(usuario);
            if (us != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
                flash.put("nomeUsuario", us.getNome());
                redirecionar = FacesUtil.redirect("home.xhtml");
            } else {
                FacesUtil.addErrorMessage("Usuário ou senha incorreto, tente novamente.");
            }
        } catch (Exception e) {
           throw new RegraNegocioException("Usuário não encontrado.");
        }
        return redirecionar;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
