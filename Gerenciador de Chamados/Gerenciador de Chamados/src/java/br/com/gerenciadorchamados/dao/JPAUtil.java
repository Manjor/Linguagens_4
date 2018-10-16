package br.com.gerenciadorchamados.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Frederico
 */
public class JPAUtil {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gerenciador_de_ChamadosPU");
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
