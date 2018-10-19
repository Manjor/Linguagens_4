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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Enderecounidade.findAll", query = "SELECT e FROM Enderecounidade e")
    , @NamedQuery(name = "Enderecounidade.findByIdenderecounidade", query = "SELECT e FROM Enderecounidade e WHERE e.idenderecounidade = :idenderecounidade")
    , @NamedQuery(name = "Enderecounidade.findByLogradouro", query = "SELECT e FROM Enderecounidade e WHERE e.logradouro = :logradouro")
    , @NamedQuery(name = "Enderecounidade.findByBairro", query = "SELECT e FROM Enderecounidade e WHERE e.bairro = :bairro")
    , @NamedQuery(name = "Enderecounidade.findByCep", query = "SELECT e FROM Enderecounidade e WHERE e.cep = :cep")})
public class Enderecounidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idenderecounidade;
    @Size(max = 150)
    private String logradouro;
    @Size(max = 150)
    private String bairro;
    @Size(max = 20)
    private String cep;
    @JoinColumn(name = "idcidade_fk", referencedColumnName = "idcidade")
    @ManyToOne
    private Cidade idcidadeFk;
    @OneToMany(mappedBy = "idenderecounidadeFk")
    private List<Unidadegestora> unidadegestoraList;

    public Enderecounidade() {
    }

    public Enderecounidade(Integer idenderecounidade) {
        this.idenderecounidade = idenderecounidade;
    }

    public Integer getIdenderecounidade() {
        return idenderecounidade;
    }

    public void setIdenderecounidade(Integer idenderecounidade) {
        this.idenderecounidade = idenderecounidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getIdcidadeFk() {
        return idcidadeFk;
    }

    public void setIdcidadeFk(Cidade idcidadeFk) {
        this.idcidadeFk = idcidadeFk;
    }

    @XmlTransient
    public List<Unidadegestora> getUnidadegestoraList() {
        return unidadegestoraList;
    }

    public void setUnidadegestoraList(List<Unidadegestora> unidadegestoraList) {
        this.unidadegestoraList = unidadegestoraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idenderecounidade != null ? idenderecounidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enderecounidade)) {
            return false;
        }
        Enderecounidade other = (Enderecounidade) object;
        if ((this.idenderecounidade == null && other.idenderecounidade != null) || (this.idenderecounidade != null && !this.idenderecounidade.equals(other.idenderecounidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gerenciadorchamados.model.Enderecounidade[ idenderecounidade=" + idenderecounidade + " ]";
    }
    
}
