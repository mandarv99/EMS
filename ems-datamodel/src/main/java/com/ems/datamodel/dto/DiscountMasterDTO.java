/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dto;

import java.util.Date;

public class DiscountMasterDTO extends AbstractDTO {

    private Integer discountId;
    private Date discountStartDate;
    private Date discountEndDate;
    private Double criteria;
    private Double criteriaValues;
    private Integer maxPeopeAvail;
    private int modifiedBy;
    private int eventId;
    private int ticketId;
    private String discountName;
    private int criteriaType;
    private int maxValue;


    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the discountId
     */
    public Integer getDiscountId() {
        return discountId;
    }

    /**
     * @param discountId the discountId to set
     */
    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    /**
     * @return the discountStartDate
     */
    public Date getDiscountStartDate() {
        return discountStartDate;
    }

    /**
     * @param discountStartDate the discountStartDate to set
     */
    public void setDiscountStartDate(Date discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    /**
     * @return the discountEndDate
     */
    public Date getDiscountEndDate() {
        return discountEndDate;
    }

    /**
     * @param discountEndDate the discountEndDate to set
     */
    public void setDiscountEndDate(Date discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    /**
     * @return the criteria
     */
    public Double getCriteria() {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(Double criteria) {
        this.criteria = criteria;
    }

    /**
     * @return the criteriaValues
     */
    public Double getCriteriaValues() {
        return criteriaValues;
    }

    /**
     * @param criteriaValues the criteriaValues to set
     */
    public void setCriteriaValues(Double criteriaValues) {
        this.criteriaValues = criteriaValues;
    }

    /**
     * @return the maxPeopeAvail
     */
    public Integer getMaxPeopeAvail() {
        return maxPeopeAvail;
    }

    /**
     * @param maxPeopeAvail the maxPeopeAvail to set
     */
    public void setMaxPeopeAvail(Integer maxPeopeAvail) {
        this.maxPeopeAvail = maxPeopeAvail;
    }

    /**
     * @return the modifiedBy
     */
    public int getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the eventId
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * @param eventId the eventId to set
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    /**
     * @return the ticketId
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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

	public int getCriteriaType() {
		return criteriaType;
	}

	public void setCriteriaType(int criteriaType) {
		this.criteriaType = criteriaType;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
}
