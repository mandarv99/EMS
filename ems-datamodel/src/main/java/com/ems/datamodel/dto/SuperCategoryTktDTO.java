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
public class SuperCategoryTktDTO extends AbstractDTO {

    private Integer superCategotyId;
    private String superCategoryName;
    private Date updatedOn;
    private Integer updatedBy;
    private int eventId;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the superCategotyId
     */
    public Integer getSuperCategotyId() {
        return superCategotyId;
    }

    /**
     * @param superCategotyId the superCategotyId to set
     */
    public void setSuperCategotyId(Integer superCategotyId) {
        this.superCategotyId = superCategotyId;
    }

    /**
     * @return the superCategoryName
     */
    public String getSuperCategoryName() {
        return superCategoryName;
    }

    /**
     * @param superCategoryName the superCategoryName to set
     */
    public void setSuperCategoryName(String superCategoryName) {
        this.superCategoryName = superCategoryName;
    }

    /**
     * @return the updatedOn
     */
    public Date getUpdatedOn() {
        return updatedOn;
    }

    /**
     * @param updatedOn the updatedOn to set
     */
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    /**
     * @return the updatedBy
     */
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
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

}
