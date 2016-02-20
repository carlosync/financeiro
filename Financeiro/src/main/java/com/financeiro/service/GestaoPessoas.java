package com.financeiro.service;

import com.financeiro.model.Pessoa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

@Stateless
public class GestaoPessoas {
    
    private static Map<Integer, Pessoa> pessoas = new HashMap<>();
    
    static{
        pessoas.put(1, new Pessoa(1, "Cartão Mastecard"));
        pessoas.put(2, new Pessoa(2, "Faculdade Unopar"));
        pessoas.put(3, new Pessoa(3, "Maria Telma"));
    }
    
    public List<Pessoa> listaTodas(){
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.addAll(GestaoPessoas.pessoas.values());
        return  pessoas;
    }
    
    public Pessoa buscaPorCodigo(Integer codigo){
        return pessoas.get(codigo);
    }
}
