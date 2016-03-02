package com.finaceiro.controller;

import com.financeiro.ejb.LancamentoFacadeLocal;
import com.financeiro.model.Lancamento;
import com.financeiro.service.FacesUtil;
import com.financeiro.service.LancamentoService;
import com.financeiro.service.RegraNegocioException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class LancamentoConsultaController implements Serializable {

   private static final long serialVersionUID = 1L;

    @EJB
    private LancamentoFacadeLocal lancamentoFacadeLocal;
    @EJB
    private LancamentoService lancamentoService;
    
    private Lancamento lancamentoSelecionado;
    private List<Lancamento> lancamentos;
    private BigDecimal valorTotal;

    public void init() {
        this.lancamentos = lancamentoFacadeLocal.listarTodas();
        this.valorTotal = lancamentoFacadeLocal.valorTotal();
    }

    public void excluir() {
        try {
            lancamentoService.excluir(lancamentoSelecionado);
            init();
            FacesUtil.addInfoMessage("Lançamento excluido com sucesso");
        } catch (RegraNegocioException e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public Lancamento getLancamentoSelecionado() {
        return lancamentoSelecionado;
    }

    public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
        this.lancamentoSelecionado = lancamentoSelecionado;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
