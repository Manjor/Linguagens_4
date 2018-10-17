/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MANOEL
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
    , @NamedQuery(name = "Login.findByIdlogin", query = "SELECT l FROM Login l WHERE l.idlogin = :idlogin")
    , @NamedQuery(name = "Login.findByUsuario", query = "SELECT l FROM Login l WHERE l.usuario = :usuario")
    , @NamedQuery(name = "Login.findBySenha", query = "SELECT l FROM Login l WHERE l.senha = :senha")
    , @NamedQuery(name = "Login.findByNivelacesso", query = "SELECT l FROM Login l WHERE l.nivelacesso = :nivelacesso")
    , @NamedQuery(name = "Login.findByAtivo", query = "SELECT l FROM Login l WHERE l.ativo = :ativo")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlogin")
    private Integer idlogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "senha")
    private String senha;
    @Column(name = "nivelacesso")
    private Integer nivelacesso;
    @Column(name = "ativo")
    private Integer ativo;
    @JoinColumn(name = "idusuario_fk", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuarioFk;

    public Login() {
    }

    public Login(Integer idlogin) {
        this.idlogin = idlogin;
    }

    public Login(Integer idlogin, String usuario, String senha) {
        this.idlogin = idlogin;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Integer getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(Integer idlogin) {
        this.idlogin = idlogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(Integer nivelacesso) {
        this.nivelacesso = nivelacesso;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public Usuario getIdusuarioFk() {
        return idusuarioFk;
    }

    public void setIdusuarioFk(Usuario idusuarioFk) {
        this.idusuarioFk = idusuarioFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlogin != null ? idlogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idlogin == null && other.idlogin != null) || (this.idlogin != null && !this.idlogin.equals(other.idlogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gerenciadorchamados.model.Login[ idlogin=" + idlogin + " ]";
    }
    
}
