package com.ems.util;

/**
 * @author snehalr
 *
 */
public enum StatusConstant 
{

	EVENT_STATUS ("event_status");
	
	private final String statusValue;

    StatusConstant(String statusValue) {
        this.statusValue = statusValue;
    }

	public String getStatusValue() {
		return this.statusValue;
	}
}
