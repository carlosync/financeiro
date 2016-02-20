package com.financeiro.service;

import com.financeiro.ejb.LancamentoFacadeLocal;
import com.financeiro.model.Lancamento;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class LancamentoService {

    @EJB
    private LancamentoFacadeLocal lancamentoFacadeLocal;
    
    public void salvar(Lancamento lancamento) throws RegraNegocioException{
        if(existeLancamento(lancamento)){
            throw new RegraNegocioException("Esse Lançamento já estar registardo");
        }
        this.lancamentoFacadeLocal.create(lancamento);
    }
    
    private boolean existeLancamento(Lancamento lancamento){
        Lancamento lancamentoExiste = lancamentoFacadeLocal.verificaExisteLancamento(lancamento);
        return lancamentoExiste != null && !lancamentoExiste.equals(lancamento);
    }
    
    public void excluir(Lancamento lancamento) throws RegraNegocioException{
        if(lancamento.isPago()){
            throw new RegraNegocioException("Lançamento pago não pode ser excluído");
        }else{
            this.lancamentoFacadeLocal.remove(lancamento);
        }
    }
    
}
