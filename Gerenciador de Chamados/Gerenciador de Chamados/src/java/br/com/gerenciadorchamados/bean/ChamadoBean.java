/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.bean;

import br.com.gerenciadorchamados.model.Chamado;
import javax.faces.bean.ManagedBean;
import br.com.gerenciadorchamados.dao.DAOGenerica;
import br.com.gerenciadorchamados.model.Usuario;
import java.util.List;

/**
 *
 * @author MANOEL
 */
@ManagedBean
public class ChamadoBean {
    private Chamado chamado = new Chamado();

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
    
    public void salvar(){
       new DAOGenerica<Chamado>(Chamado.class).adiciona(chamado);
       this.chamado = new Chamado();
    }
    public List<Chamado> buscaTodos(){
        List<Chamado> resultado = new DAOGenerica<Chamado>(Chamado.class).listaTodos();
        this.chamado = new Chamado();
        return resultado;
    } 
    
    
}
