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
import javax.persistence.GeneratedValue;
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
@Table(name = "participant_master")
@NamedQueries({
    @NamedQuery(name = "ParticipantMaster.findAll", query = "SELECT p FROM ParticipantMaster p"),
    @NamedQuery(name = "ParticipantMaster.findByParticipantId", query = "SELECT p FROM ParticipantMaster p WHERE p.participantId = :participantId"),
    @NamedQuery(name = "ParticipantMaster.findByFieldName", query = "SELECT p FROM ParticipantMaster p WHERE p.fieldName = :fieldName"),
    @NamedQuery(name = "ParticipantMaster.findByFieldType", query = "SELECT p FROM ParticipantMaster p WHERE p.fieldType = :fieldType"),
    @NamedQuery(name = "ParticipantMaster.findByFieldRequired", query = "SELECT p FROM ParticipantMaster p WHERE p.fieldRequired = :fieldRequired"),
    @NamedQuery(name = "ParticipantMaster.findByTicketId", query = "SELECT p FROM ParticipantMaster p WHERE p.ticketId = :ticketId"),
    @NamedQuery(name = "ParticipantMaster.findByModifiedOn", query = "SELECT p FROM ParticipantMaster p WHERE p.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "ParticipantMaster.findByModifiedBy", query = "SELECT p FROM ParticipantMaster p WHERE p.modifiedBy = :modifiedBy")})
public class ParticipantMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "participant_id")
    private Integer participantId;
    @Column(name = "field_name")
    private String fieldName;
    @Column(name = "field_type")
    private String fieldType;
    @Column(name = "field_required")
    private Boolean fieldRequired;
    @Column(name = "modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @Column(name = "modified_by")
    private Integer modifiedBy;
    @Column(name = "ticket_id", nullable = false)
    private Integer ticketId;
    @Column(name = "participant_specimen_id")
    private Integer participantSpecimenId;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false)
    private EventMaster eventId;

    public ParticipantMaster() {
    }

    public ParticipantMaster(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Boolean getFieldRequired() {
        return fieldRequired;
    }

    public void setFieldRequired(Boolean fieldRequired) {
        this.fieldRequired = fieldRequired;
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

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getParticipantSpecimenId() {
        return participantSpecimenId;
    }

    public void setParticipantSpecimenId(Integer participantSpecimenId) {
        this.participantSpecimenId = participantSpecimenId;
    }

    public EventMaster getEventId() {
        return eventId;
    }

    public void setEventId(EventMaster eventId) {
        this.eventId = eventId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participantId != null ? participantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipantMaster)) {
            return false;
        }
        ParticipantMaster other = (ParticipantMaster) object;
        if ((this.participantId == null && other.participantId != null) || (this.participantId != null && !this.participantId.equals(other.participantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.ParticipantMaster[ participantId=" + participantId + " ]";
    }
}
