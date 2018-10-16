package br.com.gerenciadorchamados.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.gerenciadorchamados.dao.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author MANOEL
 */
public class DAOGenerica<T> {
    private final Class<T> classe;
//private final Class<T> classe;
    
    public DAOGenerica(Class<T> classe){
        this.classe = classe;
    }
    
    public void adiciona(T t){
        //consegue a entity manager
        EntityManager em = new JPAUtil().getEntityManager();
        
        //abre transação
        em.getTransaction().begin();
        
        //persiste o objeto
        em.persist(t);
        
        //commita a transação
        em.getTransaction().commit();
        
        //fechar a entity manager
        em.close();
    }
    
    public void remove(T t){
        EntityManager em = new JPAUtil().getEntityManager();
        
        em.getTransaction().begin();
        
        em.remove(em.merge(t));
        
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void atualiza(T t){
        EntityManager em = new JPAUtil().getEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(t);
        
        em.getTransaction().commit();
        
        em.close();
    }
    
    public List<T> listaTodos(){
        EntityManager em = new JPAUtil().getEntityManager();
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));
        
        List<T> lista = em.createQuery(query).getResultList();
        
        em.close();
        
        return lista;
    }
    public T buscaPorId(Integer id){
        EntityManager em = new JPAUtil().getEntityManager();
        
        T instancia = em.find(classe, id);
        
        em.close();
        
        return instancia;
    }
     
    /*public Long contaLivros(){
        EntityManager em = new JPAUtil().getEntityManager();
        
        Long result = (Long) em.createQuery("SELECT count(n) FROM livro n").getSingleResult();
        
        em.close();
        
        return result;
    }*/
}
