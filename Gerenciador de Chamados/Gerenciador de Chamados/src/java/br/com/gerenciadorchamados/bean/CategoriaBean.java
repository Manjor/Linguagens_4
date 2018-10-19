/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.bean;

import br.com.gerenciadorchamados.model.Categoria;
import javax.faces.bean.ManagedBean;
import br.com.gerenciadorchamados.dao.DAOGenerica;
import br.com.gerenciadorchamados.model.Chamado;
import java.util.List;

/**
 *
 * @author MANOEL
 */
@ManagedBean
public class CategoriaBean {
    
    private Categoria categoria = new Categoria();
    
    public Categoria getCategoria(){
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    /**
     *Salva uma nova categoria no banco de dados
     */
    public void salvar(){
       new DAOGenerica<Categoria>(Categoria.class).adiciona(categoria);
       this.categoria = new Categoria();
    }
    public List<Categoria> buscaTodos(){
        List<Categoria> resultado = new DAOGenerica<Categoria>(Categoria.class).listaTodos();
        this.categoria = new Categoria();
        return resultado;
    } 
    
    
}
