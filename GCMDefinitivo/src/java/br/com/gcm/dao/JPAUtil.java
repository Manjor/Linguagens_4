package br.com.gcm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Frederico
 */
public class JPAUtil {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication3PU");
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
