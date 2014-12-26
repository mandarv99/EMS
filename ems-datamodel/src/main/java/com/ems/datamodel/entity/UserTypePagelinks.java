/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rupesht
 */
@Entity
@Table(name = "user_type_pagelinks")
@NamedQueries({
    @NamedQuery(name = "UserTypePagelinks.findAll", query = "SELECT u FROM UserTypePagelinks u"),
    @NamedQuery(name = "UserTypePagelinks.findByUserTypeId", query = "SELECT u FROM UserTypePagelinks u WHERE u.userTypePagelinksPK.userTypeId = :userTypeId"),
    @NamedQuery(name = "UserTypePagelinks.findByPagelinkid", query = "SELECT u FROM UserTypePagelinks u WHERE u.userTypePagelinksPK.pagelinkid = :pagelinkid")})
 public class UserTypePagelinks implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserTypePagelinksPK userTypePagelinksPK;
    @JoinColumn(name = "user_type_id", referencedColumnName = "user_type_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserType userType;
    @JoinColumn(name = "pagelinkid", referencedColumnName = "pagelinkid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pagelinks pagelinks;

    public UserTypePagelinks() {
    }

    public UserTypePagelinks(UserTypePagelinksPK userTypePagelinksPK) {
        this.userTypePagelinksPK = userTypePagelinksPK;
    }

    public UserTypePagelinks(int userTypeId, short pagelinkid) {
        this.userTypePagelinksPK = new UserTypePagelinksPK(userTypeId, pagelinkid);
    }

    public UserTypePagelinksPK getUserTypePagelinksPK() {
        return userTypePagelinksPK;
    }

    public void setUserTypePagelinksPK(UserTypePagelinksPK userTypePagelinksPK) {
        this.userTypePagelinksPK = userTypePagelinksPK;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Pagelinks getPagelinks() {
        return pagelinks;
    }

    public void setPagelinks(Pagelinks pagelinks) {
        this.pagelinks = pagelinks;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userTypePagelinksPK != null ? userTypePagelinksPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTypePagelinks)) {
            return false;
        }
        UserTypePagelinks other = (UserTypePagelinks) object;
        if ((this.userTypePagelinksPK == null && other.userTypePagelinksPK != null) || (this.userTypePagelinksPK != null && !this.userTypePagelinksPK.equals(other.userTypePagelinksPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.UserTypePagelinks[ userTypePagelinksPK=" + userTypePagelinksPK + " ]";
    }
    
}
