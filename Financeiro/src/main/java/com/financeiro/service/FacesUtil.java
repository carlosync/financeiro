package com.financeiro.service;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void addErrorMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
    }

    public static void addInfoMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
    }

    public static boolean isPostback() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public static boolean isNotPostback() {
        return !isPostback();
    }

    public static String redirect(String outcome) {
        return outcome + "?faces-redirect=true";
    }
}
