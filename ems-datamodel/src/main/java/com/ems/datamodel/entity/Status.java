/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ems.datamodel.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author snehalr
 *
 */
@Entity
@Table(name = "status")
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT u FROM Status u"),
    @NamedQuery(name = "Status.findByStatusId", query = "SELECT u FROM Status u WHERE u.statusId = :statusId"),
    @NamedQuery(name = "Status.findByStatusName", query = "SELECT u FROM Status u WHERE u.statusName = :statusName"),
    @NamedQuery(name = "Status.findByStatusFor", query = "SELECT u FROM Status u WHERE u.statusFor = :statusFor order by u.statusId")
})

public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "status_id")
    private Integer statusId;
    @Basic(optional = false)
    @Column(name = "status_name")
    private String statusName;
    @Column(name = "status_for")
    private String statusFor;

    @OneToMany(mappedBy="status")
    private Set<EventMaster> events;
    
    public Status() {
    }

    public Status(Integer statusId) {
        this.statusId = statusId;
    }

    public Status(Integer statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    public String getStatusFor() {
		return statusFor;
	}

	public void setStatusFor(String statusFor) {
		this.statusFor = statusFor;
	}

	@Override
    public String toString() {
        return "com.ems.datamodel.Status[ statusId=" + statusId + " ]";
    }
    
}
