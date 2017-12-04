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
@Table(name = "dept_perms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeptPerms.findAll", query = "SELECT d FROM DeptPerms d")
    , @NamedQuery(name = "DeptPerms.findByDeptPermissionID", query = "SELECT d FROM DeptPerms d WHERE d.deptPermissionID = :deptPermissionID")})
public class DeptPerms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "deptPermissionID")
    private String deptPermissionID;
    @JoinColumn(name = "fid", referencedColumnName = "id")
    @ManyToOne
    private Data fid;
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    @ManyToOne
    private Departament deptId;
    @JoinColumn(name = "rights", referencedColumnName = "RightId")
    @ManyToOne(optional = false)
    private Rights rights;

    public DeptPerms() {
    }

    public DeptPerms(String deptPermissionID) {
        this.deptPermissionID = deptPermissionID;
    }

    public String getDeptPermissionID() {
        return deptPermissionID;
    }

    public void setDeptPermissionID(String deptPermissionID) {
        this.deptPermissionID = deptPermissionID;
    }

    public Data getFid() {
        return fid;
    }

    public void setFid(Data fid) {
        this.fid = fid;
    }

    public Departament getDeptId() {
        return deptId;
    }

    public void setDeptId(Departament deptId) {
        this.deptId = deptId;
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
        hash += (deptPermissionID != null ? deptPermissionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptPerms)) {
            return false;
        }
        DeptPerms other = (DeptPerms) object;
        if ((this.deptPermissionID == null && other.deptPermissionID != null) || (this.deptPermissionID != null && !this.deptPermissionID.equals(other.deptPermissionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.DeptPerms[ deptPermissionID=" + deptPermissionID + " ]";
    }
    
}
