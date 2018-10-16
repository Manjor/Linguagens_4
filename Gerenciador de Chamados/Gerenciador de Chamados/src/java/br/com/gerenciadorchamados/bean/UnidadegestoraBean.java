/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.bean;
import br.com.gerenciadorchamados.dao.DAOGenerica;
import br.com.gerenciadorchamados.model.Unidadegestora;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author MANOEL
 */
@ManagedBean
public class UnidadegestoraBean {
    private Unidadegestora unidadegestora = new Unidadegestora();

    public Unidadegestora getUnidadegestora() {
        return unidadegestora;
    }
    
    public void salvar(){
       new DAOGenerica<Unidadegestora>(Unidadegestora.class).adiciona(unidadegestora);
       this.unidadegestora = new Unidadegestora();
    }
}
