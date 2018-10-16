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
@Table(name = "lotacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lotacao.findAll", query = "SELECT l FROM Lotacao l")
    , @NamedQuery(name = "Lotacao.findByIdlotacao", query = "SELECT l FROM Lotacao l WHERE l.idlotacao = :idlotacao")
    , @NamedQuery(name = "Lotacao.findByNomedepartamento", query = "SELECT l FROM Lotacao l WHERE l.nomedepartamento = :nomedepartamento")
    , @NamedQuery(name = "Lotacao.findBySigla", query = "SELECT l FROM Lotacao l WHERE l.sigla = :sigla")
    , @NamedQuery(name = "Lotacao.findByLotacaocol", query = "SELECT l FROM Lotacao l WHERE l.lotacaocol = :lotacaocol")})
public class Lotacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlotacao")
    private Integer idlotacao;
    @Size(max = 100)
    @Column(name = "nomedepartamento")
    private String nomedepartamento;
    @Size(max = 30)
    @Column(name = "sigla")
    private String sigla;
    @Size(max = 45)
    @Column(name = "lotacaocol")
    private String lotacaocol;
    @JoinColumn(name = "idunidadegestora_fk", referencedColumnName = "idunidadegestora")
    @ManyToOne
    private Unidadegestora idunidadegestoraFk;
    @OneToMany(mappedBy = "idlotacaoFk")
    private Collection<Usuario> usuarioCollection;

    public Lotacao() {
    }

    public Lotacao(Integer idlotacao) {
        this.idlotacao = idlotacao;
    }

    public Integer getIdlotacao() {
        return idlotacao;
    }

    public void setIdlotacao(Integer idlotacao) {
        this.idlotacao = idlotacao;
    }

    public String getNomedepartamento() {
        return nomedepartamento;
    }

    public void setNomedepartamento(String nomedepartamento) {
        this.nomedepartamento = nomedepartamento;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getLotacaocol() {
        return lotacaocol;
    }

    public void setLotacaocol(String lotacaocol) {
        this.lotacaocol = lotacaocol;
    }

    public Unidadegestora getIdunidadegestoraFk() {
        return idunidadegestoraFk;
    }

    public void setIdunidadegestoraFk(Unidadegestora idunidadegestoraFk) {
        this.idunidadegestoraFk = idunidadegestoraFk;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlotacao != null ? idlotacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lotacao)) {
            return false;
        }
        Lotacao other = (Lotacao) object;
        if ((this.idlotacao == null && other.idlotacao != null) || (this.idlotacao != null && !this.idlotacao.equals(other.idlotacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gerenciadorchamados.model.Lotacao[ idlotacao=" + idlotacao + " ]";
    }
    
}
