/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ems.datamodel.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rupesht
 */
@Entity
@Table(name = "participant_specimen_master")
@NamedQueries({
    @NamedQuery(name = "ParticipantSpecimenMaster.findAll", query = "SELECT p FROM ParticipantSpecimenMaster p"),
    @NamedQuery(name = "ParticipantSpecimenMaster.findByParticipantSpecimenId", query = "SELECT p FROM ParticipantSpecimenMaster p WHERE p.participantSpecimenId = :participantSpecimenId"),
    @NamedQuery(name = "ParticipantSpecimenMaster.findByFieldName", query = "SELECT p FROM ParticipantSpecimenMaster p WHERE p.fieldName = :fieldName"),
    @NamedQuery(name = "ParticipantSpecimenMaster.findByFieldType", query = "SELECT p FROM ParticipantSpecimenMaster p WHERE p.fieldType = :fieldType"),
    @NamedQuery(name = "ParticipantSpecimenMaster.findByModifiedOn", query = "SELECT p FROM ParticipantSpecimenMaster p WHERE p.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "ParticipantSpecimenMaster.findByModifiedBy", query = "SELECT p FROM ParticipantSpecimenMaster p WHERE p.modifiedBy = :modifiedBy")})
public class ParticipantSpecimenMaster implements Serializable {
    @OneToMany(mappedBy = "participantSpecimenId")
    private Collection<ParticipantMaster> participantMasterCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "participant_specimen_id")
    private Integer participantSpecimenId;
    @Basic(optional = false)
    @Column(name = "field_name")
    private String fieldName;
    @Basic(optional = false)
    @Column(name = "field_type")
    private String fieldType;
    @Column(name = "modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @Column(name = "modified_by")
    private Integer modifiedBy;

    public ParticipantSpecimenMaster() {
    }

    public ParticipantSpecimenMaster(Integer participantSpecimenId) {
        this.participantSpecimenId = participantSpecimenId;
    }

    public ParticipantSpecimenMaster(Integer participantSpecimenId, String fieldName, String fieldType) {
        this.participantSpecimenId = participantSpecimenId;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    public Integer getParticipantSpecimenId() {
        return participantSpecimenId;
    }

    public void setParticipantSpecimenId(Integer participantSpecimenId) {
        this.participantSpecimenId = participantSpecimenId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participantSpecimenId != null ? participantSpecimenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipantSpecimenMaster)) {
            return false;
        }
        ParticipantSpecimenMaster other = (ParticipantSpecimenMaster) object;
        if ((this.participantSpecimenId == null && other.participantSpecimenId != null) || (this.participantSpecimenId != null && !this.participantSpecimenId.equals(other.participantSpecimenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.ParticipantSpecimenMaster[ participantSpecimenId=" + participantSpecimenId + " ]";
    }

    public Collection<ParticipantMaster> getParticipantMasterCollection() {
        return participantMasterCollection;
    }

    public void setParticipantMasterCollection(Collection<ParticipantMaster> participantMasterCollection) {
        this.participantMasterCollection = participantMasterCollection;
    }
    
}
