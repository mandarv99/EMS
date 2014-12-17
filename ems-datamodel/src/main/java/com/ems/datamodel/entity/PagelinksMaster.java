/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rupesht
 */
@Entity
@Table(name = "pagelinks_master")
@NamedQueries({
    @NamedQuery(name = "PagelinksMaster.findAll", query = "SELECT p FROM PagelinksMaster p"),
    @NamedQuery(name = "PagelinksMaster.findByPagelinkmasterid", query = "SELECT p FROM PagelinksMaster p WHERE p.pagelinkmasterid = :pagelinkmasterid"),
    @NamedQuery(name = "PagelinksMaster.findByPagelinkmastername", query = "SELECT p FROM PagelinksMaster p WHERE p.pagelinkmastername = :pagelinkmastername"),
    @NamedQuery(name = "PagelinksMaster.findByPagelinkmasterseq", query = "SELECT p FROM PagelinksMaster p WHERE p.pagelinkmasterseq = :pagelinkmasterseq"),
    @NamedQuery(name = "PagelinksMaster.findByEnable", query = "SELECT p FROM PagelinksMaster p WHERE p.enable = :enable")})
public class PagelinksMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pagelinkmasterid")
    private Short pagelinkmasterid;
    @Column(name = "pagelinkmastername")
    private String pagelinkmastername;
    @Column(name = "pagelinkmasterseq")
    private Short pagelinkmasterseq;
    @Column(name = "enable")
    private Boolean enable;
    @OneToMany(mappedBy = "pagelinkmasterid")
    private List<Pagelinks> pagelinksList;

    public PagelinksMaster() {
    }

    public PagelinksMaster(Short pagelinkmasterid) {
        this.pagelinkmasterid = pagelinkmasterid;
    }

    public Short getPagelinkmasterid() {
        return pagelinkmasterid;
    }

    public void setPagelinkmasterid(Short pagelinkmasterid) {
        this.pagelinkmasterid = pagelinkmasterid;
    }

    public String getPagelinkmastername() {
        return pagelinkmastername;
    }

    public void setPagelinkmastername(String pagelinkmastername) {
        this.pagelinkmastername = pagelinkmastername;
    }

    public Short getPagelinkmasterseq() {
        return pagelinkmasterseq;
    }

    public void setPagelinkmasterseq(Short pagelinkmasterseq) {
        this.pagelinkmasterseq = pagelinkmasterseq;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public List<Pagelinks> getPagelinksList() {
        return pagelinksList;
    }

    public void setPagelinksList(List<Pagelinks> pagelinksList) {
        this.pagelinksList = pagelinksList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagelinkmasterid != null ? pagelinkmasterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagelinksMaster)) {
            return false;
        }
        PagelinksMaster other = (PagelinksMaster) object;
        if ((this.pagelinkmasterid == null && other.pagelinkmasterid != null) || (this.pagelinkmasterid != null && !this.pagelinkmasterid.equals(other.pagelinkmasterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.PagelinksMaster[ pagelinkmasterid=" + pagelinkmasterid + " ]";
    }
    
}
