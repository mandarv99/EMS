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
import javax.persistence.CascadeType;
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
@Table(name = "ticket_master")
@NamedQueries({
    @NamedQuery(name = "TicketMaster.findAll", query = "SELECT t FROM TicketMaster t"),
    @NamedQuery(name = "TicketMaster.findByTicketId", query = "SELECT t FROM TicketMaster t WHERE t.ticketId = :ticketId"),
    @NamedQuery(name = "TicketMaster.findByTicketName", query = "SELECT t FROM TicketMaster t WHERE t.ticketName = :ticketName"),
    @NamedQuery(name = "TicketMaster.findBySalesStartDate", query = "SELECT t FROM TicketMaster t WHERE t.salesStartDate = :salesStartDate"),
    @NamedQuery(name = "TicketMaster.findBySalesEndDate", query = "SELECT t FROM TicketMaster t WHERE t.salesEndDate = :salesEndDate"),
    @NamedQuery(name = "TicketMaster.findByAgeLimitFrom", query = "SELECT t FROM TicketMaster t WHERE t.ageLimitFrom = :ageLimitFrom"),
    @NamedQuery(name = "TicketMaster.findByAgeLimitTo", query = "SELECT t FROM TicketMaster t WHERE t.ageLimitTo = :ageLimitTo"),
    @NamedQuery(name = "TicketMaster.findByTicketPrice", query = "SELECT t FROM TicketMaster t WHERE t.ticketPrice = :ticketPrice"),
    @NamedQuery(name = "TicketMaster.findByIsRefundable", query = "SELECT t FROM TicketMaster t WHERE t.isRefundable = :isRefundable"),
    @NamedQuery(name = "TicketMaster.findByIsDiscount", query = "SELECT t FROM TicketMaster t WHERE t.isDiscount = :isDiscount"),
    @NamedQuery(name = "TicketMaster.findByTotalTickets", query = "SELECT t FROM TicketMaster t WHERE t.totalTickets = :totalTickets"),
    @NamedQuery(name = "TicketMaster.findByMinTktTransactions", query = "SELECT t FROM TicketMaster t WHERE t.minTktTransactions = :minTktTransactions"),
    @NamedQuery(name = "TicketMaster.findByMaxTktTransactions", query = "SELECT t FROM TicketMaster t WHERE t.maxTktTransactions = :maxTktTransactions"),
    @NamedQuery(name = "TicketMaster.findByModifiedOn", query = "SELECT t FROM TicketMaster t WHERE t.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "TicketMaster.findByEventId", query = "SELECT t FROM TicketMaster t WHERE t.eventId.eventId = :eventId"),
    @NamedQuery(name = "TicketMaster.findByModifiedBy", query = "SELECT t FROM TicketMaster t WHERE t.modifiedBy = :modifiedBy")})
public class TicketMaster implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Column(name = "ticket_price")
    private Double ticketPrice;
    @Column(name = "disclaimer")
    private String disclaimer; 
    @JoinColumn(name = "super_categoty_id", referencedColumnName = "super_categoty_id")
    @ManyToOne
    private SuperCategoryTkt superCategotyId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private Integer ticketId;
    @Basic(optional = false)
    @Column(name = "ticket_name")
    private String ticketName;
    @Column(name = "sales_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date salesStartDate;
    @Column(name = "sales_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date salesEndDate;
    @Column(name = "age_limit_from")
    private Integer ageLimitFrom;
    @Column(name = "age_limit_to")
    private Integer ageLimitTo;
    @Column(name = "is_refundable")
    private boolean isRefundable;
    @Column(name = "is_discount")
    private boolean isDiscount;
    @Column(name = "total_tickets")
    private Integer totalTickets;
    @Column(name = "min_tkt_transactions")
    private Integer minTktTransactions;
    @Column(name = "max_tkt_transactions")
    private Integer maxTktTransactions;
    @Column(name = "modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @Column(name = "modified_by")
    private Integer modifiedBy;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false)
    private EventMaster eventId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId")
    private Collection<DiscountMaster> discountMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId")
    private Collection<Disclaimer> disclaimerCollection;

    public TicketMaster() {
    }

    public TicketMaster(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public TicketMaster(Integer ticketId, String ticketName) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Date getSalesStartDate() {
        return salesStartDate;
    }

    public void setSalesStartDate(Date salesStartDate) {
        this.salesStartDate = salesStartDate;
    }

    public Date getSalesEndDate() {
        return salesEndDate;
    }

    public void setSalesEndDate(Date salesEndDate) {
        this.salesEndDate = salesEndDate;
    }

    public Integer getAgeLimitFrom() {
        return ageLimitFrom;
    }

    public void setAgeLimitFrom(Integer ageLimitFrom) {
        this.ageLimitFrom = ageLimitFrom;
    }

    public Integer getAgeLimitTo() {
        return ageLimitTo;
    }

    public void setAgeLimitTo(Integer ageLimitTo) {
        this.ageLimitTo = ageLimitTo;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean getIsRefundable() {
        return isRefundable;
    }

    public void setIsRefundable(boolean isRefundable) {
        this.isRefundable = isRefundable;
    }

    public boolean getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(boolean isDiscount) {
        this.isDiscount = isDiscount;
    }

    public Integer getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(Integer totalTickets) {
        this.totalTickets = totalTickets;
    }

    public Integer getMinTktTransactions() {
        return minTktTransactions;
    }

    public void setMinTktTransactions(Integer minTktTransactions) {
        this.minTktTransactions = minTktTransactions;
    }

    public Integer getMaxTktTransactions() {
        return maxTktTransactions;
    }

    public void setMaxTktTransactions(Integer maxTktTransactions) {
        this.maxTktTransactions = maxTktTransactions;
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

    public Collection<DiscountMaster> getDiscountMasterCollection() {
        return discountMasterCollection;
    }

    public void setDiscountMasterCollection(Collection<DiscountMaster> discountMasterCollection) {
        this.discountMasterCollection = discountMasterCollection;
    }

    public Collection<Disclaimer> getDisclaimerCollection() {
        return disclaimerCollection;
    }

    public void setDisclaimerCollection(Collection<Disclaimer> disclaimerCollection) {
        this.disclaimerCollection = disclaimerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketMaster)) {
            return false;
        }
        TicketMaster other = (TicketMaster) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.TicketMaster[ ticketId=" + ticketId + " ]";
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public SuperCategoryTkt getSuperCategotyId() {
        return superCategotyId;
    }

    public void setSuperCategotyId(SuperCategoryTkt superCategotyId) {
        this.superCategotyId = superCategotyId;
    }
}
