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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "event_master")
@NamedQueries({
    @NamedQuery(name = "EventMaster.findAll", query = "SELECT e FROM EventMaster e"),
    @NamedQuery(name = "EventMaster.findByEventId", query = "SELECT e FROM EventMaster e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "EventMaster.findByEventCode", query = "SELECT e FROM EventMaster e WHERE e.eventCode = :eventCode"),
    @NamedQuery(name = "EventMaster.findByEventName", query = "SELECT e FROM EventMaster e WHERE e.eventName = :eventName"),
    @NamedQuery(name = "EventMaster.findByEventTypeId", query = "SELECT e FROM EventMaster e WHERE e.eventTypeId = :eventTypeId"),
    @NamedQuery(name = "EventMaster.findByEventStatus", query = "SELECT e FROM EventMaster e WHERE e.eventStatus = :eventStatus"),
    @NamedQuery(name = "EventMaster.findByEventStartDatetime", query = "SELECT e FROM EventMaster e WHERE e.eventStartDatetime = :eventStartDatetime"),
    @NamedQuery(name = "EventMaster.findByEventEndDatetime", query = "SELECT e FROM EventMaster e WHERE e.eventEndDatetime = :eventEndDatetime"),
    @NamedQuery(name = "EventMaster.findByEventDescription", query = "SELECT e FROM EventMaster e WHERE e.eventDescription = :eventDescription"),
    @NamedQuery(name = "EventMaster.findByEventUrl", query = "SELECT e FROM EventMaster e WHERE e.eventUrl = :eventUrl"),
    @NamedQuery(name = "EventMaster.findByEventAddress", query = "SELECT e FROM EventMaster e WHERE e.eventAddress = :eventAddress"),
    @NamedQuery(name = "EventMaster.findByBibNumbering", query = "SELECT e FROM EventMaster e WHERE e.bibNumbering = :bibNumbering"),
    @NamedQuery(name = "EventMaster.findByRequireDisclaimer", query = "SELECT e FROM EventMaster e WHERE e.requireDisclaimer = :requireDisclaimer"),
    @NamedQuery(name = "EventMaster.findByIsDiscounted", query = "SELECT e FROM EventMaster e WHERE e.isDiscounted = :isDiscounted"),
    @NamedQuery(name = "EventMaster.findByAddedBy", query = "SELECT c FROM EventMaster c WHERE c.addedBy = :addedBy")})
public class EventMaster implements Serializable {

    @Column(name = "event_header_image")
    private String eventHeaderImage;
    @Column(name = "photo_url")
    private String photoUrl;
    @Column(name = "is_free_event")
    private Boolean isFreeEvent;
    @Column(name = "required_sitting_arrangement")
    private Boolean requiredSittingArrangement;
    @Column(name = "disclaimer")
    private String disclaimer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Collection<ParticipantMaster> participantMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Collection<SuperCategoryTkt> superCategoryTktCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Collection<TicketMaster> ticketMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Collection<DiscountMaster> discountMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Collection<Disclaimer> disclaimerCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "event_id")
    private Integer eventId;
    @Column(name = "event_code")
    private String eventCode;
    @Basic(optional = false)
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_type_id")
    private Integer eventTypeId;
    @Column(name = "event_status")
    private Integer eventStatus;
    @Column(name = "event_start_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventStartDatetime;
    @Column(name = "event_end_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventEndDatetime;
    @Column(name = "event_description")
    private String eventDescription;
    @Basic(optional = false)
    @Column(name = "event_url")
    private String eventUrl;
    @Column(name = "event_address")
    private String eventAddress;
    @Column(name = "bib_numbering")
    private Boolean bibNumbering;
    @Column(name = "require_disclaimer")
    private Integer requireDisclaimer;
    @Column(name = "is_discounted")
    private Integer isDiscounted;
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CompanyDetails companyId;
    @Column(name = "added_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedOn;
    @Column(name = "added_by")
    private Integer addedBy;

    public EventMaster() {
    }

    public EventMaster(Integer eventId) {
        this.eventId = eventId;
    }

    public EventMaster(Integer eventId, String eventName, String eventUrl) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventUrl = eventUrl;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    public Date getEventStartDatetime() {
        return eventStartDatetime;
    }

    public void setEventStartDatetime(Date eventStartDatetime) {
        this.eventStartDatetime = eventStartDatetime;
    }

    public Date getEventEndDatetime() {
        return eventEndDatetime;
    }

    public void setEventEndDatetime(Date eventEndDatetime) {
        this.eventEndDatetime = eventEndDatetime;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public String getEventHeaderImage() {
        return eventHeaderImage;
    }

    public void setEventHeaderImage(String eventHeaderImage) {
        this.eventHeaderImage = eventHeaderImage;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public Boolean getBibNumbering() {
        return bibNumbering;
    }

    public void setBibNumbering(Boolean bibNumbering) {
        this.bibNumbering = bibNumbering;
    }

    public Integer getRequireDisclaimer() {
        return requireDisclaimer;
    }

    public void setRequireDisclaimer(Integer requireDisclaimer) {
        this.requireDisclaimer = requireDisclaimer;
    }

    public Integer getIsDiscounted() {
        return isDiscounted;
    }

    public void setIsDiscounted(Integer isDiscounted) {
        this.isDiscounted = isDiscounted;
    }

    public CompanyDetails getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyDetails companyId) {
        this.companyId = companyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventMaster)) {
            return false;
        }
        EventMaster other = (EventMaster) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.EventMaster[ eventId=" + eventId + " ]";
    }

    public Collection<TicketMaster> getTicketMasterCollection() {
        return ticketMasterCollection;
    }

    public void setTicketMasterCollection(Collection<TicketMaster> ticketMasterCollection) {
        this.ticketMasterCollection = ticketMasterCollection;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Boolean getIsFreeEvent() {
        return isFreeEvent;
    }

    public void setIsFreeEvent(Boolean isFreeEvent) {
        this.isFreeEvent = isFreeEvent;
    }

    public Boolean getRequiredSittingArrangement() {
        return requiredSittingArrangement;
    }

    public void setRequiredSittingArrangement(Boolean requiredSittingArrangement) {
        this.requiredSittingArrangement = requiredSittingArrangement;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Collection<ParticipantMaster> getParticipantMasterCollection() {
        return participantMasterCollection;
    }

    public void setParticipantMasterCollection(Collection<ParticipantMaster> participantMasterCollection) {
        this.participantMasterCollection = participantMasterCollection;
    }

    public Collection<SuperCategoryTkt> getSuperCategoryTktCollection() {
        return superCategoryTktCollection;
    }

    public void setSuperCategoryTktCollection(Collection<SuperCategoryTkt> superCategoryTktCollection) {
        this.superCategoryTktCollection = superCategoryTktCollection;
    }

    /**
     * @return the addedOn
     */
    public Date getAddedOn() {
        return addedOn;
    }

    /**
     * @param addedOn the addedOn to set
     */
    public void setAddedOn(Date addedOn) {
        this.addedOn = new Date();
    }

    /**
     * @return the addedBy
     */
    public Integer getAddedBy() {
        return addedBy;
    }

    /**
     * @param addedBy the addedBy to set
     */
    public void setAddedBy(Integer addedBy) {
        this.addedBy = addedBy;
    }
}
