package com.finaceiro.controller;

import com.financeiro.ejb.PessoaFacadeLocal;
import com.financeiro.service.FacesUtil;
import com.financeiro.model.Lancamento;
import com.financeiro.model.Pessoa;
import com.financeiro.model.TipoLancamento;
import com.financeiro.service.LancamentoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class LancamentoController implements Serializable {

    @Inject
    private Lancamento lancamento;
    
    private List<Pessoa> pessoas = new ArrayList<>();
    
    @EJB
    private LancamentoService lancamentoService;

    @EJB
    private PessoaFacadeLocal pessoaFacadeLocal;

    public void init() {
        this.pessoas = pessoaFacadeLocal.buscarTodas();
    }
    
    public void limparCampos(){
        this.lancamento = new Lancamento();
    }

    public void lancamentoPagoModificado(ValueChangeEvent event) {
        this.lancamento.setPago((Boolean) event.getNewValue()); // Obter o valor atual do checkbox
        this.lancamento.setDataPagamento(null);
        FacesContext.getCurrentInstance().renderResponse(); // Avançar a fase de rederen do JSF
    }

    public void salvar(){
        try {
            lancamentoService.salvar(lancamento);
            FacesUtil.addInfoMessage("Registro salvo com sucesso.");
            limparCampos();
        } catch (Exception e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }

    }

    public TipoLancamento[] getTipos() {
        return TipoLancamento.values();
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    
}
