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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d")
    , @NamedQuery(name = "Data.findById", query = "SELECT d FROM Data d WHERE d.id = :id")
    , @NamedQuery(name = "Data.findByRealname", query = "SELECT d FROM Data d WHERE d.realname = :realname")
    , @NamedQuery(name = "Data.findByCreated", query = "SELECT d FROM Data d WHERE d.created = :created")
    , @NamedQuery(name = "Data.findByDescription", query = "SELECT d FROM Data d WHERE d.description = :description")
    , @NamedQuery(name = "Data.findByDefaultRights", query = "SELECT d FROM Data d WHERE d.defaultRights = :defaultRights")
    , @NamedQuery(name = "Data.findByPath", query = "SELECT d FROM Data d WHERE d.path = :path")
    , @NamedQuery(name = "Data.findByStatus", query = "SELECT d FROM Data d WHERE d.status = :status")
    , @NamedQuery(name = "Data.findByIsDeleted", query = "SELECT d FROM Data d WHERE d.isDeleted = :isDeleted")})
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "realname")
    private String realname;
    @Basic(optional = false)
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "description")
    private String description;
    @Column(name = "default_rights")
    private Short defaultRights;
    @Column(name = "path")
    private String path;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "isDeleted")
    private Boolean isDeleted;
    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category category;
    @JoinColumn(name = "owner", referencedColumnName = "id")
    @ManyToOne
    private User owner;
    @JoinColumn(name = "department", referencedColumnName = "id")
    @ManyToOne
    private Departament department;
    @JoinColumn(name = "reviewer", referencedColumnName = "id")
    @ManyToOne
    private User reviewer;
    @OneToMany(mappedBy = "fid")
    private Collection<DeptPerms> deptPermsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fileId")
    private Collection<AccessLog> accessLogCollection;

    public Data() {
    }

    public Data(Integer id) {
        this.id = id;
    }

    public Data(Integer id, String realname, Date created) {
        this.id = id;
        this.realname = realname;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getDefaultRights() {
        return defaultRights;
    }

    public void setDefaultRights(Short defaultRights) {
        this.defaultRights = defaultRights;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Departament getDepartment() {
        return department;
    }

    public void setDepartment(Departament department) {
        this.department = department;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    @XmlTransient
    public Collection<DeptPerms> getDeptPermsCollection() {
        return deptPermsCollection;
    }

    public void setDeptPermsCollection(Collection<DeptPerms> deptPermsCollection) {
        this.deptPermsCollection = deptPermsCollection;
    }

    @XmlTransient
    public Collection<AccessLog> getAccessLogCollection() {
        return accessLogCollection;
    }

    public void setAccessLogCollection(Collection<AccessLog> accessLogCollection) {
        this.accessLogCollection = accessLogCollection;
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
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Data[ id=" + id + " ]";
    }
    
}
