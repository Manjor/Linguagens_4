/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.bean;

import br.com.gerenciadorchamados.dao.DAOGenerica;
import br.com.gerenciadorchamados.model.Contato;
import br.com.gerenciadorchamados.model.Login;
import br.com.gerenciadorchamados.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author MANOEL
 */
@ManagedBean
public class UsuarioBean {
    private Usuario usuario = new Usuario();
  
    public Usuario getUsuario() {
        return usuario;
    }
    
    
    public void salvar(){
     
       new DAOGenerica<Usuario>(Usuario.class).adiciona(usuario);
       
       this.usuario = new Usuario();
      
    }
    public void deletar(){
       new DAOGenerica<Usuario>(Usuario.class).remove(usuario);
       this.usuario = new Usuario();
    }
    public List<Usuario> buscaTodos(){
        List<Usuario> resultado = new DAOGenerica<Usuario>(Usuario.class).listaTodos();
        this.usuario = new Usuario();
        return resultado;
    } 
    
}
