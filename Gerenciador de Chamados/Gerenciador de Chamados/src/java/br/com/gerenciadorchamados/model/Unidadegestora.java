/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadorchamados.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MANOEL
 */
@Entity
@Table(name = "unidadegestora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidadegestora.findAll", query = "SELECT u FROM Unidadegestora u")
    , @NamedQuery(name = "Unidadegestora.findByIdunidadegestora", query = "SELECT u FROM Unidadegestora u WHERE u.idunidadegestora = :idunidadegestora")
    , @NamedQuery(name = "Unidadegestora.findByNomeunidade", query = "SELECT u FROM Unidadegestora u WHERE u.nomeunidade = :nomeunidade")
    , @NamedQuery(name = "Unidadegestora.findBySiglaunidade", query = "SELECT u FROM Unidadegestora u WHERE u.siglaunidade = :siglaunidade")})
public class Unidadegestora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idunidadegestora")
    private Integer idunidadegestora;
    @Size(max = 100)
    @Column(name = "nomeunidade")
    private String nomeunidade;
    @Size(max = 45)
    @Column(name = "siglaunidade")
    private String siglaunidade;
    @JoinColumn(name = "idenderecounidade_fk", referencedColumnName = "idenderecounidade")
    @ManyToOne
    private Enderecounidade idenderecounidadeFk;
    @OneToMany(mappedBy = "idunidadegestoraFk")
    private Collection<Lotacao> lotacaoCollection;

    public Unidadegestora() {
    }

    public Unidadegestora(Integer idunidadegestora) {
        this.idunidadegestora = idunidadegestora;
    }

    public Integer getIdunidadegestora() {
        return idunidadegestora;
    }

    public void setIdunidadegestora(Integer idunidadegestora) {
        this.idunidadegestora = idunidadegestora;
    }

    public String getNomeunidade() {
        return nomeunidade;
    }

    public void setNomeunidade(String nomeunidade) {
        this.nomeunidade = nomeunidade;
    }

    public String getSiglaunidade() {
        return siglaunidade;
    }

    public void setSiglaunidade(String siglaunidade) {
        this.siglaunidade = siglaunidade;
    }

    public Enderecounidade getIdenderecounidadeFk() {
        return idenderecounidadeFk;
    }

    public void setIdenderecounidadeFk(Enderecounidade idenderecounidadeFk) {
        this.idenderecounidadeFk = idenderecounidadeFk;
    }

    @XmlTransient
    public Collection<Lotacao> getLotacaoCollection() {
        return lotacaoCollection;
    }

    public void setLotacaoCollection(Collection<Lotacao> lotacaoCollection) {
        this.lotacaoCollection = lotacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idunidadegestora != null ? idunidadegestora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidadegestora)) {
            return false;
        }
        Unidadegestora other = (Unidadegestora) object;
        if ((this.idunidadegestora == null && other.idunidadegestora != null) || (this.idunidadegestora != null && !this.idunidadegestora.equals(other.idunidadegestora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gerenciadorchamados.model.Unidadegestora[ idunidadegestora=" + idunidadegestora + " ]";
    }
    
}
