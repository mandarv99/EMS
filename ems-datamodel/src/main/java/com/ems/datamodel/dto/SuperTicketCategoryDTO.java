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
public class SuperTicketCategoryDTO extends AbstractDTO{
    private String ticketCategoryName;
    private int ticketCategoryId;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
