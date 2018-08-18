/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.model.Livro;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author FC20162861
 */
@ManagedBean(name="LivroBean")
public class LivroBean {
    
    private Livro livro = new Livro();
    
    public Livro getLivro()
    {
        return livro;
    }
    
    public void salvar()
    {
        System.out.println("Salvando livro: " + getLivro().getTitulo());
        
        
    }
    
}
