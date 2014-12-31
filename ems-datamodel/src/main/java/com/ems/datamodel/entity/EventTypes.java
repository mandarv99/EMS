/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "event_types")
@NamedQueries({
    @NamedQuery(name = "EventTypes.findAll", query = "SELECT e FROM EventTypes e"),
    @NamedQuery(name = "EventTypes.findByEventTypeId", query = "SELECT e FROM EventTypes e WHERE e.eventTypeId = :eventTypeId"),
    @NamedQuery(name = "EventTypes.findByEventTypeName", query = "SELECT e FROM EventTypes e WHERE e.eventTypeName = :eventTypeName"),
    @NamedQuery(name = "EventTypes.findByUpdatedOn", query = "SELECT e FROM EventTypes e WHERE e.updatedOn = :updatedOn"),
    @NamedQuery(name = "EventTypes.findByUpdatedBy", query = "SELECT e FROM EventTypes e WHERE e.updatedBy = :updatedBy")})
public class EventTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "event_type_id")
    private Integer eventTypeId;
    @Basic(optional = false)
    @Column(name = "event_type_name")
    private String eventTypeName;
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @Column(name = "updated_by")
    private Integer updatedBy;

    public EventTypes() {
    }

    public EventTypes(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public EventTypes(Integer eventTypeId, String eventTypeName) {
        this.eventTypeId = eventTypeId;
        this.eventTypeName = eventTypeName;
    }

    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventTypeId != null ? eventTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventTypes)) {
            return false;
        }
        EventTypes other = (EventTypes) object;
        if ((this.eventTypeId == null && other.eventTypeId != null) || (this.eventTypeId != null && !this.eventTypeId.equals(other.eventTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.EventTypes[ eventTypeId=" + eventTypeId + " ]";
    }
    
}
