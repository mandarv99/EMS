/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author rupesht
 */
@Embeddable
public class UserTypePagelinksPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "user_type_id")
    private int userTypeId;
    @Basic(optional = false)
    @Column(name = "pagelinkid")
    private short pagelinkid;

    public UserTypePagelinksPK() {
    }

    public UserTypePagelinksPK(int userTypeId, short pagelinkid) {
        this.userTypeId = userTypeId;
        this.pagelinkid = pagelinkid;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public short getPagelinkid() {
        return pagelinkid;
    }

    public void setPagelinkid(short pagelinkid) {
        this.pagelinkid = pagelinkid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userTypeId;
        hash += (int) pagelinkid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTypePagelinksPK)) {
            return false;
        }
        UserTypePagelinksPK other = (UserTypePagelinksPK) object;
        if (this.userTypeId != other.userTypeId) {
            return false;
        }
        if (this.pagelinkid != other.pagelinkid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.UserTypePagelinksPK[ userTypeId=" + userTypeId + ", pagelinkid=" + pagelinkid + " ]";
    }
    
}
