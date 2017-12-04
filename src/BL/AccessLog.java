/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vegim
 */
@Entity
@Table(name = "access_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccessLog.findAll", query = "SELECT a FROM AccessLog a")
    , @NamedQuery(name = "AccessLog.findByAccessLogID", query = "SELECT a FROM AccessLog a WHERE a.accessLogID = :accessLogID")
    , @NamedQuery(name = "AccessLog.findByTimestamp", query = "SELECT a FROM AccessLog a WHERE a.timestamp = :timestamp")
    , @NamedQuery(name = "AccessLog.findByAction", query = "SELECT a FROM AccessLog a WHERE a.action = :action")})
public class AccessLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "accessLogID")
    private Integer accessLogID;
    @Basic(optional = false)
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Basic(optional = false)
    @Column(name = "action")
    private String action;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Collection<Log> logCollection;
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Data fileId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(mappedBy = "fid")
    private Collection<UserPerms> userPermsCollection;

    public AccessLog() {
    }

    public AccessLog(Integer accessLogID) {
        this.accessLogID = accessLogID;
    }

    public AccessLog(Integer accessLogID, Date timestamp, String action) {
        this.accessLogID = accessLogID;
        this.timestamp = timestamp;
        this.action = action;
    }

    public Integer getAccessLogID() {
        return accessLogID;
    }

    public void setAccessLogID(Integer accessLogID) {
        this.accessLogID = accessLogID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @XmlTransient
    public Collection<Log> getLogCollection() {
        return logCollection;
    }

    public void setLogCollection(Collection<Log> logCollection) {
        this.logCollection = logCollection;
    }

    public Data getFileId() {
        return fileId;
    }

    public void setFileId(Data fileId) {
        this.fileId = fileId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        hash += (accessLogID != null ? accessLogID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessLog)) {
            return false;
        }
        AccessLog other = (AccessLog) object;
        if ((this.accessLogID == null && other.accessLogID != null) || (this.accessLogID != null && !this.accessLogID.equals(other.accessLogID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.AccessLog[ accessLogID=" + accessLogID + " ]";
    }
    
}
