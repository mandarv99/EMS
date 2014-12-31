/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ems.datamodel.dto;

import java.util.Date;

/**
 *
 * @author Rupesh
 */
public class DiscountsDTO extends AbstractDTO{
    private Date startDate;
    private Date endDate;
    private int criteria;
    private int maxPeopleAvail;
    private int value;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the criteria
     */
    public int getCriteria() {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(int criteria) {
        this.criteria = criteria;
    }

    /**
     * @return the maxPeopleAvail
     */
    public int getMaxPeopleAvail() {
        return maxPeopleAvail;
    }

    /**
     * @param maxPeopleAvail the maxPeopleAvail to set
     */
    public void setMaxPeopleAvail(int maxPeopleAvail) {
        this.maxPeopleAvail = maxPeopleAvail;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
    
}
