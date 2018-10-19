/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.bean;

import br.com.gerenciadorchamados.dao.DAOGenerica;
import br.com.gerenciadorchamados.model.Status;
import br.com.gerenciadorchamados.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author MANOEL
 */
@ManagedBean
public class StatusBean {
    private Status status = new Status();

    public Status getStatus() {
        return status;
    }

    public List<Status> buscaTodos(){
        List<Status> resultado = new DAOGenerica<Status>(Status.class).listaTodos();
        this.status = new Status();
        return resultado;
    } 
    
}
