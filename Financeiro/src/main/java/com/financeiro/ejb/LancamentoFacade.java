package com.financeiro.ejb;

import com.financeiro.model.Lancamento;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@Stateless
public class LancamentoFacade extends AbstractFacade<Lancamento> implements LancamentoFacadeLocal {

    @PersistenceContext(unitName = "financeiroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LancamentoFacade() {
        super(Lancamento.class);
    }

    @Override
    public List<Lancamento> listarTodas() {
        return this.em.createQuery("from Lancamento l inner join fetch l.pessoa "
                + "order by l.dataVencimento", Lancamento.class).getResultList();
    }
    
    @Override
    public BigDecimal valorTotal(){
        BigDecimal valor = this.em.createQuery("select sum(valor) from Lancamento", BigDecimal.class).getSingleResult();
        return valor;
    }

    @Override
    public Lancamento verificaExisteLancamento(Lancamento lancamento) {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Lancamento.class)
                .add(Restrictions.eq("tipoLancamento", lancamento.getTipoLancamento()))
                .add(Restrictions.eq("pessoa", lancamento.getPessoa()))
                .add(Restrictions.ilike("descricao", lancamento.getDescricao()))
                .add(Restrictions.eq("valor", lancamento.getValor()))
                .add(Restrictions.eq("dataVencimento", lancamento.getDataVencimento()));
        
        return (Lancamento) criteria.uniqueResult();
    }

}
