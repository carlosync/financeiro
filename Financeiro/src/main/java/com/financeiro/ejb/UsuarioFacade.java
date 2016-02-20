package com.financeiro.ejb;

import com.financeiro.model.Usuario;
import com.financeiro.service.RegraNegocioException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "financeiroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario iniciarSessao(Usuario u){
        Usuario usuario = null;
        try {
            Query query = em.createQuery("from Usuario u where u.email = ?1 and u.senha = ?2");
            query.setParameter(1, u.getEmail());
            query.setParameter(2, u.getSenha());
            List<Usuario> usuarios = query.getResultList();
            if(!usuarios.isEmpty()){
                usuario = usuarios.get(0);
            }
        } catch (NoResultException e) {
            throw e;
        }
        
        return usuario;
    }

}
