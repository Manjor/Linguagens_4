/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MANOEL
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c")
    , @NamedQuery(name = "Contato.findByIdcontato", query = "SELECT c FROM Contato c WHERE c.idcontato = :idcontato")
    , @NamedQuery(name = "Contato.findByTelefone", query = "SELECT c FROM Contato c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Contato.findByTelefonerecado", query = "SELECT c FROM Contato c WHERE c.telefonerecado = :telefonerecado")
    , @NamedQuery(name = "Contato.findByEmail", query = "SELECT c FROM Contato c WHERE c.email = :email")})
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idcontato;
    @Size(max = 30)
    private String telefone;
    @Size(max = 30)
    private String telefonerecado;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 150)
    private String email;
    @OneToMany(mappedBy = "idcontatoFk")
    private List<Usuario> usuarioList;

    public Contato() {
    }

    public Contato(Integer idcontato) {
        this.idcontato = idcontato;
    }

    public Integer getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(Integer idcontato) {
        this.idcontato = idcontato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefonerecado() {
        return telefonerecado;
    }

    public void setTelefonerecado(String telefonerecado) {
        this.telefonerecado = telefonerecado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontato != null ? idcontato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.idcontato == null && other.idcontato != null) || (this.idcontato != null && !this.idcontato.equals(other.idcontato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gerenciadorchamados.model.Contato[ idcontato=" + idcontato + " ]";
    }
    
}
