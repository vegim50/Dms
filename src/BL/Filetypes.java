/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vegim
 */
@Entity
@Table(name = "filetypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filetypes.findAll", query = "SELECT f FROM Filetypes f")
    , @NamedQuery(name = "Filetypes.findById", query = "SELECT f FROM Filetypes f WHERE f.id = :id")
    , @NamedQuery(name = "Filetypes.findByType", query = "SELECT f FROM Filetypes f WHERE f.type = :type")
    , @NamedQuery(name = "Filetypes.findByActive", query = "SELECT f FROM Filetypes f WHERE f.active = :active")})
public class Filetypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Column(name = "Active")
    private Boolean active;

    public Filetypes() {
    }

    public Filetypes(Integer id) {
        this.id = id;
    }

    public Filetypes(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filetypes)) {
            return false;
        }
        Filetypes other = (Filetypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Filetypes[ id=" + id + " ]";
    }
    
}
