/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rupesh
 */
public class EventMasterDTO extends AbstractDTO {

    /**
	 * 
	 */
	private static final long serialVersionUID = 960109282100568371L;
	private Integer eventId;
    private String eventCode;
    private String eventName;
    private Integer eventTypeId;
    private Integer eventStatus;
    private Date eventStartDatetime;
    private Date eventEndDatetime;
    private int eventCategoryId;
    private String eventCategory;
    private String eventDescription;
    private String eventUrl;
    private String eventHeaderImage;
    private String eventAddress;
    private boolean bibNumbering;
    private Integer requireDisclaimer;
    private Integer isDiscounted;
    private String eventLocation;
    private boolean isSittingArrangmentRequired;
    private String desclaimer;
    private boolean paidEvent;
    private boolean tktGroupingCategory;
    private List<TicketDTO> ticketMasterDTOList;
    private Integer companyId;
    private boolean disclaimerRequired;
    private Date addedOn;    
    private Integer addedBy;
    private  MapDTO mapDetails;

    public EventMasterDTO() {
        ticketMasterDTOList = new ArrayList<TicketDTO>();
        mapDetails = new MapDTO();
    }

    /**
     * @return the eventId
     */
    public Integer getEventId() {
        return eventId;
    }

    /**
     * @param eventId the eventId to set
     */
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    /**
     * @return the eventCode
     */
    public String getEventCode() {
        return eventCode;
    }

    /**
     * @param eventCode the eventCode to set
     */
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the eventTypeId
     */
    public Integer getEventTypeId() {
        return eventTypeId;
    }

    /**
     * @param eventTypeId the eventTypeId to set
     */
    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    /**
     * @return the eventStatus
     */
    public Integer getEventStatus() {
        return eventStatus;
    }

    /**
     * @param eventStatus the eventStatus to set
     */
    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    /**
     * @return the eventStartDatetime
     */
    public Date getEventStartDatetime() {
        return eventStartDatetime;
    }

    /**
     * @param eventStartDatetime the eventStartDatetime to set
     */
    public void setEventStartDatetime(Date eventStartDatetime) {
        this.eventStartDatetime = eventStartDatetime;
    }

    /**
     * @return the eventEndDatetime
     */
    public Date getEventEndDatetime() {
        return eventEndDatetime;
    }

    /**
     * @param eventEndDatetime the eventEndDatetime to set
     */
    public void setEventEndDatetime(Date eventEndDatetime) {
        this.eventEndDatetime = eventEndDatetime;
    }

    /**
     * @return the eventCategoryId
     */
    public int getEventCategoryId() {
        return eventCategoryId;
    }

    /**
     * @param eventCategoryId the eventCategoryId to set
     */
    public void setEventCategoryId(int eventCategoryId) {
        this.eventCategoryId = eventCategoryId;
    }

    /**
     * @return the eventCategory
     */
    public String getEventCategory() {
        return eventCategory;
    }

    /**
     * @param eventCategory the eventCategory to set
     */
    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    /**
     * @return the eventDescription
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * @param eventDescription the eventDescription to set
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    /**
     * @return the eventUrl
     */
    public String getEventUrl() {
        return eventUrl;
    }

    /**
     * @param eventUrl the eventUrl to set
     */
    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    /**
     * @return the eventHeaderImage
     */
    public String getEventHeaderImage() {
        return eventHeaderImage;
    }

    /**
     * @param eventHeaderImage the eventHeaderImage to set
     */
    public void setEventHeaderImage(String eventHeaderImage) {
        this.eventHeaderImage = eventHeaderImage;
    }

    /**
     * @return the eventAddress
     */
    public String getEventAddress() {
        return eventAddress;
    }

    /**
     * @param eventAddress the eventAddress to set
     */
    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    /**
     * @return the requireDisclaimer
     */
    public Integer getRequireDisclaimer() {
        return requireDisclaimer;
    }

    /**
     * @param requireDisclaimer the requireDisclaimer to set
     */
    public void setRequireDisclaimer(Integer requireDisclaimer) {
        this.requireDisclaimer = requireDisclaimer;
    }

    /**
     * @return the isDiscounted
     */
    public Integer getIsDiscounted() {
        return isDiscounted;
    }

    /**
     * @param isDiscounted the isDiscounted to set
     */
    public void setIsDiscounted(Integer isDiscounted) {
        this.isDiscounted = isDiscounted;
    }

    /**
     * @return the eventLocation
     */
    public String getEventLocation() {
        return eventLocation;
    }

    /**
     * @param eventLocation the eventLocation to set
     */
    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    /**
     * @return the isSittingArrangmentRequired
     */
    public boolean isIsSittingArrangmentRequired() {
        return isSittingArrangmentRequired;
    }

    /**
     * @param isSittingArrangmentRequired the isSittingArrangmentRequired to set
     */
    public void setIsSittingArrangmentRequired(boolean isSittingArrangmentRequired) {
        this.isSittingArrangmentRequired = isSittingArrangmentRequired;
    }

    /**
     * @return the desclaimer
     */
    public String getDesclaimer() {
        return desclaimer;
    }

    /**
     * @param desclaimer the desclaimer to set
     */
    public void setDesclaimer(String desclaimer) {
        this.desclaimer = desclaimer;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the paidEvent
     */
    public boolean isPaidEvent() {
        return paidEvent;
    }

    /**
     * @param paidEvent the paidEvent to set
     */
    public void setPaidEvent(boolean paidEvent) {
        this.paidEvent = paidEvent;
    }

    /**
     * @return the tktGroupingCategory
     */
    public boolean isTktGroupingCategory() {
        return tktGroupingCategory;
    }

    /**
     * @param tktGroupingCategory the tktGroupingCategory to set
     */
    public void setTktGroupingCategory(boolean tktGroupingCategory) {
        this.tktGroupingCategory = tktGroupingCategory;
    }

    /**
     * @return the bibNumbering
     */
    public boolean isBibNumbering() {
        return bibNumbering;
    }

    /**
     * @param bibNumbering the bibNumbering to set
     */
    public void setBibNumbering(boolean bibNumbering) {
        this.bibNumbering = bibNumbering;
    }

    /**
     * @return the ticketMasterDTOList
     */
    public List<TicketDTO> getTicketMasterDTOList() {
        return ticketMasterDTOList;
    }

    /**
     * @param ticketMasterDTOList the ticketMasterDTOList to set
     */
    public void setTicketMasterDTOList(List<TicketDTO> ticketMasterDTOList) {
        this.ticketMasterDTOList = ticketMasterDTOList;
    }

    /**
     * @return the companyId
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the disclaimerRequired
     */
    public boolean isDisclaimerRequired() {
        return disclaimerRequired;
    }

    /**
     * @param disclaimerRequired the disclaimerRequired to set
     */
    public void setDisclaimerRequired(boolean disclaimerRequired) {
        this.disclaimerRequired = disclaimerRequired;
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
        this.addedOn = addedOn;
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

	public void setMapDetails(MapDTO mapDetails) {
		this.mapDetails = mapDetails;
	}

	public MapDTO getMapDetails() {
		return mapDetails;
	}
}