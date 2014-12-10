/*
 * PageLinkMasterDTO.java
 *
 * Created on July 10, 2008, 10:58 AM
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
public class PageLinkMasterDTO extends AbstractDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1628391759333554943L;
	/** Creates a new instance of PageLinkMasterDTO */
	private Integer pageLinkMasterId;
	private String pageLinkMasterName;
	private Integer pageLinkMasterSeq;
	private Integer parentMasterId;
	private Date lastUpdated;
	private Integer updatedBy;
	private String imageName;
	private String linkUrl;
	private int noOfLinks;
	

	public String toString() {
		String strObj = "\n" + " pageLinkMasterId :" + getPageLinkMasterId()
				+ "\n" + " pageLinkMasterSeq :" + getPageLinkMasterSeq() + "\n"
				+ " pageLinkMasterName :" + getPageLinkMasterName() + "\n"
				+ " parentMasterId :" + getParentMasterId() + "\n"
				+ " imageName :" + getImageName() + "\n"
				+ " lastUpdated :" + getLastUpdated() + "\n" + " updatedBy :"
				+ getUpdatedBy();

		return strObj;
	}

	public Integer getParentMasterId() {
		return parentMasterId;
	}

	public void setParentMasterId(Integer parentMasterId) {
		this.parentMasterId = parentMasterId;
	}

	public Integer getPageLinkMasterId() {
		return pageLinkMasterId;
	}

	public void setPageLinkMasterId(Integer pageLinkMasterId) {
		this.pageLinkMasterId = pageLinkMasterId;
	}

	public String getPageLinkMasterName() {
		return pageLinkMasterName;
	}

	public void setPageLinkMasterName(String pageLinkMasterName) {
		this.pageLinkMasterName = pageLinkMasterName;
	}

	public Integer getPageLinkMasterSeq() {
		return pageLinkMasterSeq;
	}

	public void setPageLinkMasterSeq(Integer pageLinkMasterSeq) {
		this.pageLinkMasterSeq = pageLinkMasterSeq;
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
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public int getNoOfLinks() {
		return noOfLinks;
	}

	public void setNoOfLinks(int noOfLinks) {
		this.noOfLinks = noOfLinks;
	}

}
