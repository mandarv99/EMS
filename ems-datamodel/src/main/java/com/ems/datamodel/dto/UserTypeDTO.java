/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ems.datamodel.dto;

/**
 *
 * @author Rupesh
 */
public class UserTypeDTO  extends AbstractDTO{
    private Integer userTypeId;    
    private String userTypeName;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the userTypeId
     */
    public Integer getUserTypeId() {
        return userTypeId;
    }

    /**
     * @param userTypeId the userTypeId to set
     */
    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    /**
     * @return the userTypeName
     */
    public String getUserTypeName() {
        return userTypeName;
    }

    /**
     * @param userTypeName the userTypeName to set
     */
    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
}
