package com.financeiro.converter;

import com.financeiro.ejb.PessoaFacadeLocal;
import com.financeiro.model.Pessoa;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("pessoaConverter")
public class PessoaConverter implements Converter {

    @EJB
    private PessoaFacadeLocal pessoaFacadeLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Pessoa retorno = null;

        if (value != null) {
            retorno = pessoaFacadeLocal.find(new Integer(value));
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Integer codigo = ((Pessoa) value).getId();
            String retorno = (codigo == null ? null : codigo.toString());
            return retorno;
        }
        return "";
    }

}
