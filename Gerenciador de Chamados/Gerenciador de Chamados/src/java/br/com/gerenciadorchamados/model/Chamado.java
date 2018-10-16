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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MANOEL
 */
@Entity
@Table(name = "chamado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chamado.findAll", query = "SELECT c FROM Chamado c")
    , @NamedQuery(name = "Chamado.findByIdchamado", query = "SELECT c FROM Chamado c WHERE c.idchamado = :idchamado")
    , @NamedQuery(name = "Chamado.findByAssunto", query = "SELECT c FROM Chamado c WHERE c.assunto = :assunto")
    , @NamedQuery(name = "Chamado.findByDescricao", query = "SELECT c FROM Chamado c WHERE c.descricao = :descricao")})
public class Chamado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchamado")
    private Integer idchamado;
    @Size(max = 200)
    @Column(name = "assunto")
    private String assunto;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "idcategoria_fk", referencedColumnName = "idcategoria")
    @ManyToOne
    private Categoria idcategoriaFk;
    @JoinColumn(name = "idusuario_fk", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuarioFk;

    public Chamado() {
    }
    
    public Chamado(Integer idchamado) {
        this.idchamado = idchamado;
    }
    public Chamado(Integer idchamado, String assunto, String descricao, Categoria idcategoriaFk, Usuario idusuarioFk) {
        this.idchamado = idchamado;
        this.assunto = assunto;
        this.descricao = descricao;
        this.idcategoriaFk = idcategoriaFk;
        this.idusuarioFk = idusuarioFk;
    }
    


    public Integer getIdchamado() {
        return idchamado;
    }

    public void setIdchamado(Integer idchamado) {
        this.idchamado = idchamado;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getIdcategoriaFk() {
        return idcategoriaFk;
    }

    public void setIdcategoriaFk(Categoria idcategoriaFk) {
        this.idcategoriaFk = idcategoriaFk;
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
        hash += (idchamado != null ? idchamado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chamado)) {
            return false;
        }
        Chamado other = (Chamado) object;
        if ((this.idchamado == null && other.idchamado != null) || (this.idchamado != null && !this.idchamado.equals(other.idchamado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gerenciadorchamados.model.Chamado[ idchamado=" + idchamado + " ]";
    }
    
}
