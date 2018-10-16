/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.bean;


import br.com.gerenciadorchamados.model.Enderecounidade;
import javax.faces.bean.ManagedBean;
import br.com.gerenciadorchamados.dao.DAOGenerica;
/**
 *
 * @author MANOEL
 */
@ManagedBean
public class EnderecounidadeBean {
    private Enderecounidade endereco = new Enderecounidade();

    public Enderecounidade getEndereco() {
        return endereco;
    }
    
    public void salvar(){
       new DAOGenerica<Enderecounidade>(Enderecounidade.class).adiciona(endereco);
       this.endereco = new Enderecounidade();
    }
}
