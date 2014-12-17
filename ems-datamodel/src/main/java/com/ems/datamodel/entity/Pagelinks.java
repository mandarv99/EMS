/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.entity;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author rupesht
 */
@Entity
@Table(name = "pagelinks")
@NamedQueries({
    @NamedQuery(name = "Pagelinks.findAll", query = "SELECT p FROM Pagelinks p"),
    @NamedQuery(name = "Pagelinks.findByPagelinkid", query = "SELECT p FROM Pagelinks p WHERE p.pagelinkid = :pagelinkid"),
    @NamedQuery(name = "Pagelinks.findByPagelinkname", query = "SELECT p FROM Pagelinks p WHERE p.pagelinkname = :pagelinkname"),
    @NamedQuery(name = "Pagelinks.findByPagelinkurl", query = "SELECT p FROM Pagelinks p WHERE p.pagelinkurl = :pagelinkurl"),
    @NamedQuery(name = "Pagelinks.findByPagelinkseq", query = "SELECT p FROM Pagelinks p WHERE p.pagelinkseq = :pagelinkseq")})
public class Pagelinks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pagelinkid")
    private Short pagelinkid;
    @Column(name = "pagelinkname")
    private String pagelinkname;
    @Column(name = "pagelinkurl")
    private String pagelinkurl;
    @Column(name = "pagelinkseq")
    private Short pagelinkseq;
    @JoinColumn(name = "pagelinkmasterid", referencedColumnName = "pagelinkmasterid")
    @ManyToOne
    private PagelinksMaster pagelinkmasterid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagelinks")
    private List<UserTypePagelinks> userTypePagelinksList;

    public Pagelinks() {
    }

    public Pagelinks(Short pagelinkid) {
        this.pagelinkid = pagelinkid;
    }

    public Short getPagelinkid() {
        return pagelinkid;
    }

    public void setPagelinkid(Short pagelinkid) {
        this.pagelinkid = pagelinkid;
    }

    public String getPagelinkname() {
        return pagelinkname;
    }

    public void setPagelinkname(String pagelinkname) {
        this.pagelinkname = pagelinkname;
    }

    public String getPagelinkurl() {
        return pagelinkurl;
    }

    public void setPagelinkurl(String pagelinkurl) {
        this.pagelinkurl = pagelinkurl;
    }

    public Short getPagelinkseq() {
        return pagelinkseq;
    }

    public void setPagelinkseq(Short pagelinkseq) {
        this.pagelinkseq = pagelinkseq;
    }

    public PagelinksMaster getPagelinkmasterid() {
        return pagelinkmasterid;
    }

    public void setPagelinkmasterid(PagelinksMaster pagelinkmasterid) {
        this.pagelinkmasterid = pagelinkmasterid;
    }

    public List<UserTypePagelinks> getUserTypePagelinksList() {
        return userTypePagelinksList;
    }

    public void setUserTypePagelinksList(List<UserTypePagelinks> userTypePagelinksList) {
        this.userTypePagelinksList = userTypePagelinksList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagelinkid != null ? pagelinkid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagelinks)) {
            return false;
        }
        Pagelinks other = (Pagelinks) object;
        if ((this.pagelinkid == null && other.pagelinkid != null) || (this.pagelinkid != null && !this.pagelinkid.equals(other.pagelinkid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.Pagelinks[ pagelinkid=" + pagelinkid + " ]";
    }
    
}
