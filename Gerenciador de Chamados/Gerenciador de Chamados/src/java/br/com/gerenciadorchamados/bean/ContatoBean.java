/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.bean;


import br.com.gerenciadorchamados.model.Contato;
import javax.faces.bean.ManagedBean;
import br.com.gerenciadorchamados.dao.DAOGenerica;

/**
 *
 * @author MANOEL
 */
@ManagedBean
public class ContatoBean {
    private Contato contato = new Contato();

    public Contato getContato() {
        return contato;
    }
    public void salvar(){
       new DAOGenerica<Contato>(Contato.class).adiciona(contato);
       this.contato = new Contato();
    }
    
    
}
