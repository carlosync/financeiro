package com.financeiro.converter;

import com.financeiro.ejb.LancamentoFacadeLocal;
import com.financeiro.model.Lancamento;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang3.StringUtils;

@FacesConverter(value = "lancamentoConverter")
public class LancamentoConverter implements Converter{

    @EJB
    private LancamentoFacadeLocal lancamentoFacadeLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Lancamento retorno = null;
        
        if(StringUtils.isNotBlank(value)){
            retorno = lancamentoFacadeLocal.find(new Integer(value));
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Integer codigo = ((Lancamento) value).getId();
            String retorno = (codigo == null ? null : codigo.toString());
            return retorno;
        }
        return "";
    }

}
