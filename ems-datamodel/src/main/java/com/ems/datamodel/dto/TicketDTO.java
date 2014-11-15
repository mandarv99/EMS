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
public class TicketDTO extends AbstractDTO {

    private int superCategory;
    private int ticketCategoryId;
    private String ticketCategoryName;
    private Date salesStartDate;
    private Date salesEndDate;
    private Integer ageFrom;
    private Integer ageTo;
    private Double ticketPrice;
    private boolean discount;
    private boolean refundable;
    private Integer totalTickets;
    private Integer minTicketsPerTransaction;
    private Integer maxTicketsPerTransaction;
    private String disclaimer;
    private DiscountMasterDTO discountMaster;
    private int eventId;
    private int modifiedBy;
    
    public TicketDTO(){
       
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the superCategory
     */
    public int getSuperCategory() {
        return superCategory;
    }

    /**
     * @param superCategory the superCategory to set
     */
    public void setSuperCategory(int superCategory) {
        this.superCategory = superCategory;
    }

    /**
     * @return the salesStartDate
     */
    public Date getSalesStartDate() {
        return salesStartDate;
    }

    /**
     * @param salesStartDate the salesStartDate to set
     */
    public void setSalesStartDate(Date salesStartDate) {
        this.salesStartDate = salesStartDate;
    }

    /**
     * @return the ageFrom
     */
    public Integer getAgeFrom() {
        return ageFrom;
    }

    /**
     * @param ageFrom the ageFrom to set
     */
    public void setAgeFrom(Integer ageFrom) {
        this.ageFrom = ageFrom;
    }

    /**
     * @return the ageTo
     */
    public Integer getAgeTo() {
        return ageTo;
    }

    /**
     * @param ageTo the ageTo to set
     */
    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
    }

    /**
     * @return the ticketPrice
     */
    public Double getTicketPrice() {
        return ticketPrice;
    }

    /**
     * @param ticketPrice the ticketPrice to set
     */
    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /**
     * @return the discount
     */
    public boolean isDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    /**
     * @return the refundable
     */
    public boolean isRefundable() {
        return refundable;
    }

    /**
     * @param refundable the refundable to set
     */
    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    /**
     * @return the totalTickets
     */
    public Integer getTotalTickets() {
        return totalTickets;
    }

    /**
     * @param totalTickets the totalTickets to set
     */
    public void setTotalTickets(Integer totalTickets) {
        this.totalTickets = totalTickets;
    }

    /**
     * @return the minTicketsPerTransaction
     */
    public Integer getMinTicketsPerTransaction() {
        return minTicketsPerTransaction;
    }

    /**
     * @param minTicketsPerTransaction the minTicketsPerTransaction to set
     */
    public void setMinTicketsPerTransaction(Integer minTicketsPerTransaction) {
        this.minTicketsPerTransaction = minTicketsPerTransaction;
    }

    /**
     * @return the maxTicketsPerTransaction
     */
    public Integer getMaxTicketsPerTransaction() {
        return maxTicketsPerTransaction;
    }

    /**
     * @param maxTicketsPerTransaction the maxTicketsPerTransaction to set
     */
    public void setMaxTicketsPerTransaction(Integer maxTicketsPerTransaction) {
        this.maxTicketsPerTransaction = maxTicketsPerTransaction;
    }

    /**
     * @return the disclaimer
     */
    public String getDisclaimer() {
        return disclaimer;
    }

    /**
     * @param disclaimer the disclaimer to set
     */
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    /**
     * @return the ticketCategoryId
     */
    public int getTicketCategoryId() {
        return ticketCategoryId;
    }

    /**
     * @param ticketCategoryId the ticketCategoryId to set
     */
    public void setTicketCategoryId(int ticketCategoryId) {
        this.ticketCategoryId = ticketCategoryId;
    }

    /**
     * @return the ticketCategoryName
     */
    public String getTicketCategoryName() {
        return ticketCategoryName;
    }

    /**
     * @param ticketCategoryName the ticketCategoryName to set
     */
    public void setTicketCategoryName(String ticketCategoryName) {
        this.ticketCategoryName = ticketCategoryName;
    }

    /**
     * @return the salesEndDate
     */
    public Date getSalesEndDate() {
        return salesEndDate;
    }

    /**
     * @param salesEndDate the salesEndDate to set
     */
    public void setSalesEndDate(Date salesEndDate) {
        this.salesEndDate = salesEndDate;
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
     * @return the discountMaster
     */
    public DiscountMasterDTO getDiscountMaster() {
        return discountMaster;
    }

    /**
     * @param discountMaster the discountMaster to set
     */
    public void setDiscountMaster(DiscountMasterDTO discountMaster) {
        this.discountMaster = discountMaster;
    }

}
