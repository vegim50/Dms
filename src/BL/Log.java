/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vegim
 */
@Entity
@Table(name = "log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l")
    , @NamedQuery(name = "Log.findByLogID", query = "SELECT l FROM Log l WHERE l.logID = :logID")
    , @NamedQuery(name = "Log.findByModifiedOn", query = "SELECT l FROM Log l WHERE l.modifiedOn = :modifiedOn")
    , @NamedQuery(name = "Log.findByRevision", query = "SELECT l FROM Log l WHERE l.revision = :revision")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "logID")
    private String logID;
    @Basic(optional = false)
    @Column(name = "modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @Lob
    @Column(name = "note")
    private String note;
    @Column(name = "revision")
    private String revision;
    @JoinColumn(name = "id", referencedColumnName = "file_id")
    @ManyToOne(optional = false)
    private AccessLog id;
    @JoinColumn(name = "modified_by", referencedColumnName = "username")
    @ManyToOne
    private User modifiedBy;

    public Log() {
    }

    public Log(String logID) {
        this.logID = logID;
    }

    public Log(String logID, Date modifiedOn) {
        this.logID = logID;
        this.modifiedOn = modifiedOn;
    }

    public String getLogID() {
        return logID;
    }

    public void setLogID(String logID) {
        this.logID = logID;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public AccessLog getId() {
        return id;
    }

    public void setId(AccessLog id) {
        this.id = id;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logID != null ? logID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.logID == null && other.logID != null) || (this.logID != null && !this.logID.equals(other.logID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Log[ logID=" + logID + " ]";
    }
    
}
