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
@Table(name = "discount_master")
@NamedQueries({
    @NamedQuery(name = "DiscountMaster.findAll", query = "SELECT d FROM DiscountMaster d"),
    @NamedQuery(name = "DiscountMaster.findByDiscountId", query = "SELECT d FROM DiscountMaster d WHERE d.discountId = :discountId"),
    @NamedQuery(name = "DiscountMaster.findByDiscountStartDate", query = "SELECT d FROM DiscountMaster d WHERE d.discountStartDate = :discountStartDate"),
    @NamedQuery(name = "DiscountMaster.findByDiscountEndDate", query = "SELECT d FROM DiscountMaster d WHERE d.discountEndDate = :discountEndDate"),
    @NamedQuery(name = "DiscountMaster.findByCriteria", query = "SELECT d FROM DiscountMaster d WHERE d.criteria = :criteria"),
    @NamedQuery(name = "DiscountMaster.findByCriteriaValues", query = "SELECT d FROM DiscountMaster d WHERE d.criteriaValues = :criteriaValues"),
    @NamedQuery(name = "DiscountMaster.findByMaxPeopeAvail", query = "SELECT d FROM DiscountMaster d WHERE d.maxPeopeAvail = :maxPeopeAvail"),
    @NamedQuery(name = "DiscountMaster.findByModifiedOn", query = "SELECT d FROM DiscountMaster d WHERE d.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "DiscountMaster.findByModifiedBy", query = "SELECT d FROM DiscountMaster d WHERE d.modifiedBy = :modifiedBy")})
public class DiscountMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "discount_id")
    private Integer discountId;
    @Basic(optional = false)
    @Column(name = "discount_name")
    private String discountName;
    @Column(name = "discount_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discountStartDate;
    @Column(name = "discount_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discountEndDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "criteria")
    private Double criteria;
    @Column(name = "criteria_values")
    private Double criteriaValues;
    @Column(name = "max_peope_avail")
    private Integer maxPeopeAvail;
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

    public DiscountMaster() {
    }

    public DiscountMaster(Integer discountId) {
        this.discountId = discountId;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Date getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(Date discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public Date getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(Date discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public Double getCriteria() {
        return criteria;
    }

    public void setCriteria(Double criteria) {
        this.criteria = criteria;
    }

    public Double getCriteriaValues() {
        return criteriaValues;
    }

    public void setCriteriaValues(Double criteriaValues) {
        this.criteriaValues = criteriaValues;
    }

    public Integer getMaxPeopeAvail() {
        return maxPeopeAvail;
    }

    public void setMaxPeopeAvail(Integer maxPeopeAvail) {
        this.maxPeopeAvail = maxPeopeAvail;
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
        hash += (discountId != null ? discountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountMaster)) {
            return false;
        }
        DiscountMaster other = (DiscountMaster) object;
        if ((this.discountId == null && other.discountId != null) || (this.discountId != null && !this.discountId.equals(other.discountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.DiscountMaster[ discountId=" + discountId + " ]";
    }

    /**
     * @return the discountName
     */
    public String getDiscountName() {
        return discountName;
    }

    /**
     * @param discountName the discountName to set
     */
    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }
    
}
