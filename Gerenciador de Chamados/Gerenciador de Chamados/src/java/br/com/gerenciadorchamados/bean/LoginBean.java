/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.bean;

import br.com.gerenciadorchamados.dao.DAOGenerica;
import br.com.gerenciadorchamados.model.Login;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author MANOEL
 */
@ManagedBean
public class LoginBean {
    private Login login = new Login();

    public Login getLogin() {
        return login;
    }
    
    public void salvar(){
       new DAOGenerica<Login>(Login.class).adiciona(login);
       this.login = new Login();
    }
}
