/*
 * PageLinksDTO.java
 *
 * Created on July 10, 2008, 11:05 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.ems.datamodel.dto;

import java.util.Date;
 
/**
 * @author snehalr
 *
 */
public class PageLinksDTO extends AbstractDTO{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3606982162877651524L;
	/** Creates a new instance of PageLinkDTO */
    private Integer pageLinkId;
    private String pageLinkName;
    private String pageLinkUrl;
    private Integer pageLinkSeq;
    private Integer pageLinkMasterId;
    private Date lastUpdated;
    private Integer updatedBy;
    private Integer pageLinkType;
    private Boolean pageLinkAllowed;
    
   

	public String toString() {
        String strObj="\n" + " pageLinkId :" + getPageLinkId()+
                      "\n" + " pageLinkName :"+ getPageLinkName()+
                      "\n" + " pageLinkUrl :"+ getPageLinkUrl()+
                      "\n" + " pageLinkMasterId :"+getPageLinkMasterId()+
                      "\n" + " pageLinkMasterSeq :"+getPageLinkSeq()+
                      "\n" + " lastUpdated :" + getLastUpdated()+
                      "\n" + " pageLinkType :" + getPageLinkType()+
                      "\n" + " updatedBy :" + getUpdatedBy();
        return strObj;
    }

    public Integer getPageLinkId() {
        return pageLinkId;
    }

    public void setPageLinkId(Integer pageLinkId) {
        this.pageLinkId = pageLinkId;
    }

    public String getPageLinkName() {
        return pageLinkName;
    }

    public void setPageLinkName(String pageLinkName) {
        this.pageLinkName = pageLinkName;
    }

    public String getPageLinkUrl() {
        return pageLinkUrl;
    }

    public void setPageLinkUrl(String pageLinkUrl) {
        this.pageLinkUrl = pageLinkUrl;
    }

    public Integer getPageLinkSeq() {
        return pageLinkSeq;
    }

    public void setPageLinkSeq(Integer pageLinkSeq) {
        this.pageLinkSeq = pageLinkSeq;
    }

    public Integer getPageLinkMasterId() {
        return pageLinkMasterId;
    }

    public void setPageLinkMasterId(Integer pageLinkMasterId) {
        this.pageLinkMasterId = pageLinkMasterId;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Integer getPageLinkType() {
		return pageLinkType;
	}

	public void setPageLinkType(Integer pageLinkType) {
		this.pageLinkType = pageLinkType;
	}

	public Boolean getPageLinkAllowed() {
		return pageLinkAllowed;
	}

	public void setPageLinkAllowed(Boolean pageLinkAllowed) {
		this.pageLinkAllowed = pageLinkAllowed;
	}
    
}
