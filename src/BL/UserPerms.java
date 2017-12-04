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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vegim
 */
@Entity
@Table(name = "user_perms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPerms.findAll", query = "SELECT u FROM UserPerms u")
    , @NamedQuery(name = "UserPerms.findByUserPermissionID", query = "SELECT u FROM UserPerms u WHERE u.userPermissionID = :userPermissionID")})
public class UserPerms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "userPermissionID")
    private Integer userPermissionID;
    @JoinColumn(name = "fid", referencedColumnName = "file_id")
    @ManyToOne
    private AccessLog fid;
    @JoinColumn(name = "uid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User uid;
    @JoinColumn(name = "rights", referencedColumnName = "RightId")
    @ManyToOne(optional = false)
    private Rights rights;

    public UserPerms() {
    }

    public UserPerms(Integer userPermissionID) {
        this.userPermissionID = userPermissionID;
    }

    public Integer getUserPermissionID() {
        return userPermissionID;
    }

    public void setUserPermissionID(Integer userPermissionID) {
        this.userPermissionID = userPermissionID;
    }

    public AccessLog getFid() {
        return fid;
    }

    public void setFid(AccessLog fid) {
        this.fid = fid;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userPermissionID != null ? userPermissionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPerms)) {
            return false;
        }
        UserPerms other = (UserPerms) object;
        if ((this.userPermissionID == null && other.userPermissionID != null) || (this.userPermissionID != null && !this.userPermissionID.equals(other.userPermissionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.UserPerms[ userPermissionID=" + userPermissionID + " ]";
    }
    
}
