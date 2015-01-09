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
public class MapDTO  extends AbstractDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8908970247335616385L;
	private Double latitude;
    private Double longitude;
    private int zoom;
    private String title;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    
}
