package com.financeiro.ejb;

import com.financeiro.model.Pessoa;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PessoaFacadeLocal {

    void create(Pessoa pessoa);

    void edit(Pessoa pessoa);

    void remove(Pessoa pessoa);

    Pessoa find(Object id);
    
    List<Pessoa> findAll();
    
    List<Pessoa> buscarTodas();

  
}
