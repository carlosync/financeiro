package com.financeiro.ejb;

import com.financeiro.model.Lancamento;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LancamentoFacadeLocal {

    void create(Lancamento lancamento);

    void edit(Lancamento lancamento);

    void remove(Lancamento lancamento);
    
    Lancamento verificaExisteLancamento(Lancamento lancamento);
    
    Lancamento find(Object id);

    List<Lancamento> listarTodas();
    
    BigDecimal valorTotal();

}
