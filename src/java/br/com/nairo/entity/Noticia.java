/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nairo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author eders
 */
@Entity
@Table(name = "noticia")
@NamedQueries({
    @NamedQuery(name = "Noticia.findAll", query = "SELECT n FROM Noticia n")
    , @NamedQuery(name = "Noticia.findByCodigoNoticia", query = "SELECT n FROM Noticia n WHERE n.codigoNoticia = :codigoNoticia")})
public class Noticia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoNoticia")
    private Integer codigoNoticia;
    @Basic(optional = false)
    @Lob
    @Column(name = "descricaoNoticia")
    private String descricaoNoticia;

    public Noticia() {
    }

    public Noticia(Integer codigoNoticia) {
        this.codigoNoticia = codigoNoticia;
    }

    public Noticia(Integer codigoNoticia, String descricaoNoticia) {
        this.codigoNoticia = codigoNoticia;
        this.descricaoNoticia = descricaoNoticia;
    }

    public Integer getCodigoNoticia() {
        return codigoNoticia;
    }

    public void setCodigoNoticia(Integer codigoNoticia) {
        this.codigoNoticia = codigoNoticia;
    }

    public String getDescricaoNoticia() {
        return descricaoNoticia;
    }

    public void setDescricaoNoticia(String descricaoNoticia) {
        this.descricaoNoticia = descricaoNoticia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoNoticia != null ? codigoNoticia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noticia)) {
            return false;
        }
        Noticia other = (Noticia) object;
        if ((this.codigoNoticia == null && other.codigoNoticia != null) || (this.codigoNoticia != null && !this.codigoNoticia.equals(other.codigoNoticia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.nairo.entity.Noticia[ codigoNoticia=" + codigoNoticia + " ]";
    }
    
}
