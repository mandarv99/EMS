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
@Table(name = "disclaimer")
@NamedQueries({
    @NamedQuery(name = "Disclaimer.findAll", query = "SELECT d FROM Disclaimer d"),
    @NamedQuery(name = "Disclaimer.findByDisclaimerId", query = "SELECT d FROM Disclaimer d WHERE d.disclaimerId = :disclaimerId"),
    @NamedQuery(name = "Disclaimer.findByDisclaimer", query = "SELECT d FROM Disclaimer d WHERE d.disclaimer = :disclaimer"),
    @NamedQuery(name = "Disclaimer.findByModifiedOn", query = "SELECT d FROM Disclaimer d WHERE d.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "Disclaimer.findByModifiedBy", query = "SELECT d FROM Disclaimer d WHERE d.modifiedBy = :modifiedBy")})
public class Disclaimer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "disclaimer_id")
    private Integer disclaimerId;
    @Column(name = "disclaimer")
    private String disclaimer;
    @Column(name = "modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @Column(name = "modified_by")
    private Integer modifiedBy;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false)
    private EventMaster eventId;
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    @ManyToOne(optional = false)
    private TicketMaster ticketId;

    public Disclaimer() {
    }

    public Disclaimer(Integer disclaimerId) {
        this.disclaimerId = disclaimerId;
    }

    public Integer getDisclaimerId() {
        return disclaimerId;
    }

    public void setDisclaimerId(Integer disclaimerId) {
        this.disclaimerId = disclaimerId;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public EventMaster getEventId() {
        return eventId;
    }

    public void setEventId(EventMaster eventId) {
        this.eventId = eventId;
    }

    public TicketMaster getTicketId() {
        return ticketId;
    }

    public void setTicketId(TicketMaster ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disclaimerId != null ? disclaimerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disclaimer)) {
            return false;
        }
        Disclaimer other = (Disclaimer) object;
        if ((this.disclaimerId == null && other.disclaimerId != null) || (this.disclaimerId != null && !this.disclaimerId.equals(other.disclaimerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.Disclaimer[ disclaimerId=" + disclaimerId + " ]";
    }
    
}
