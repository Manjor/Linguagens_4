/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.bean;


import br.com.gerenciadorchamados.model.Lotacao;
import javax.faces.bean.ManagedBean;
import br.com.gerenciadorchamados.dao.DAOGenerica;

/**
 *
 * @author MANOEL
 */
@ManagedBean
public class LotacaoBean {
    private Lotacao lotacao = new Lotacao();

    public Lotacao getLotacao() {
        return lotacao;
    }
    
    public void salvar(){
       new DAOGenerica<Lotacao>(Lotacao.class).adiciona(lotacao);
       this.lotacao = new Lotacao();
    }
}