/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rupesht
 */
@Entity
@Table(name = "super_category_tkt")
@NamedQueries({
    @NamedQuery(name = "SuperCategoryTkt.findAll", query = "SELECT s FROM SuperCategoryTkt s"),
    @NamedQuery(name = "SuperCategoryTkt.findBySuperCategotyId", query = "SELECT s FROM SuperCategoryTkt s WHERE s.superCategotyId = :superCategotyId"),
    @NamedQuery(name = "SuperCategoryTkt.findBySuperCategoryName", query = "SELECT s FROM SuperCategoryTkt s WHERE s.superCategoryName = :superCategoryName"),
    @NamedQuery(name = "SuperCategoryTkt.findByUpdatedOn", query = "SELECT s FROM SuperCategoryTkt s WHERE s.updatedOn = :updatedOn"),
    @NamedQuery(name = "SuperCategoryTkt.findByEventId", query = "SELECT s FROM SuperCategoryTkt s WHERE s.eventId.eventId = :eventId"),
    @NamedQuery(name = "SuperCategoryTkt.findByUpdatedBy", query = "SELECT s FROM SuperCategoryTkt s WHERE s.updatedBy = :updatedBy")})
public class SuperCategoryTkt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "super_categoty_id")
    private Integer superCategotyId;
    @Basic(optional = false)
    @Column(name = "super_category_name")
    private String superCategoryName;
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false)
    private EventMaster eventId;
    @OneToMany(mappedBy = "superCategotyId")
    private Collection<TicketMaster> ticketMasterCollection;

    public SuperCategoryTkt() {
    }

    public SuperCategoryTkt(Integer superCategotyId) {
        this.superCategotyId = superCategotyId;
    }

    public SuperCategoryTkt(Integer superCategotyId, String superCategoryName) {
        this.superCategotyId = superCategotyId;
        this.superCategoryName = superCategoryName;
    }

    public Integer getSuperCategotyId() {
        return superCategotyId;
    }

    public void setSuperCategotyId(Integer superCategotyId) {
        this.superCategotyId = superCategotyId;
    }

    public String getSuperCategoryName() {
        return superCategoryName;
    }

    public void setSuperCategoryName(String superCategoryName) {
        this.superCategoryName = superCategoryName;
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

    public EventMaster getEventId() {
        return eventId;
    }

    public void setEventId(EventMaster eventId) {
        this.eventId = eventId;
    }

    public Collection<TicketMaster> getTicketMasterCollection() {
        return ticketMasterCollection;
    }

    public void setTicketMasterCollection(Collection<TicketMaster> ticketMasterCollection) {
        this.ticketMasterCollection = ticketMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (superCategotyId != null ? superCategotyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuperCategoryTkt)) {
            return false;
        }
        SuperCategoryTkt other = (SuperCategoryTkt) object;
        if ((this.superCategotyId == null && other.superCategotyId != null) || (this.superCategotyId != null && !this.superCategotyId.equals(other.superCategotyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.SuperCategoryTkt[ superCategotyId=" + superCategotyId + " ]";
    }
    
}
