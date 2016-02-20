package com.financeiro.ejb;

import com.financeiro.model.Pessoa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PessoaFacade extends AbstractFacade<Pessoa> implements PessoaFacadeLocal {

    @PersistenceContext(unitName = "financeiroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PessoaFacade() {
        super(Pessoa.class);
    }

    @Override
    public List<Pessoa> buscarTodas() {
        return this.em.createQuery("from Pessoa p order by p.nome", Pessoa.class).getResultList();
    }

    


}
