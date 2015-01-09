/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ems.datamodel.dto;


/**
 * @author snehalr
 *
 */
public class StatusDTO  extends AbstractDTO
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8745716756478870507L;
	private Integer statusId;    
    private String statusName;
    private String statusFor;


    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


	public Integer getStatusId() {
		return statusId;
	}


	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}


	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}


	public String getStatusFor() {
		return statusFor;
	}


	public void setStatusFor(String statusFor) {
		this.statusFor = statusFor;
	} 
}