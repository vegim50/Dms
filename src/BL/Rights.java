/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vegim
 */
@Entity
@Table(name = "rights")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rights.findAll", query = "SELECT r FROM Rights r")
    , @NamedQuery(name = "Rights.findByRightId", query = "SELECT r FROM Rights r WHERE r.rightId = :rightId")
    , @NamedQuery(name = "Rights.findByDescription", query = "SELECT r FROM Rights r WHERE r.description = :description")})
public class Rights implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RightId")
    private Short rightId;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rights")
    private Collection<DeptPerms> deptPermsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rights")
    private Collection<UserPerms> userPermsCollection;

    public Rights() {
    }

    public Rights(Short rightId) {
        this.rightId = rightId;
    }

    public Short getRightId() {
        return rightId;
    }

    public void setRightId(Short rightId) {
        this.rightId = rightId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<DeptPerms> getDeptPermsCollection() {
        return deptPermsCollection;
    }

    public void setDeptPermsCollection(Collection<DeptPerms> deptPermsCollection) {
        this.deptPermsCollection = deptPermsCollection;
    }

    @XmlTransient
    public Collection<UserPerms> getUserPermsCollection() {
        return userPermsCollection;
    }

    public void setUserPermsCollection(Collection<UserPerms> userPermsCollection) {
        this.userPermsCollection = userPermsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rightId != null ? rightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rights)) {
            return false;
        }
        Rights other = (Rights) object;
        if ((this.rightId == null && other.rightId != null) || (this.rightId != null && !this.rightId.equals(other.rightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Rights[ rightId=" + rightId + " ]";
    }
    
}
