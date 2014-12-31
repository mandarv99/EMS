/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ems.datamodel.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rupesht
 */
@Entity
@Table(name = "user_password_request")
@NamedQueries({
    @NamedQuery(name = "UserPasswordRequest.findAll", query = "SELECT u FROM UserPasswordRequest u"),
    @NamedQuery(name = "UserPasswordRequest.findByRequestId", query = "SELECT u FROM UserPasswordRequest u WHERE u.requestId = :requestId"),
    @NamedQuery(name = "UserPasswordRequest.findByCreatedOn", query = "SELECT u FROM UserPasswordRequest u WHERE u.createdOn = :createdOn"),
    @NamedQuery(name = "UserPasswordRequest.findByStatus", query = "SELECT u FROM UserPasswordRequest u WHERE u.status = :status")})
public class UserPasswordRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "request_id")
    private Integer requestId;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userId;

    public UserPasswordRequest() {
    }

    public UserPasswordRequest(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestId != null ? requestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPasswordRequest)) {
            return false;
        }
        UserPasswordRequest other = (UserPasswordRequest) object;
        if ((this.requestId == null && other.requestId != null) || (this.requestId != null && !this.requestId.equals(other.requestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.UserPasswordRequest[ requestId=" + requestId + " ]";
    }
    
}
