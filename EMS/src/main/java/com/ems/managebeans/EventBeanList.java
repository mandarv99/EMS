/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.ems.datamodel.dao.EventMasterDAO;
import com.ems.datamodel.dao.StatusDAO;
import com.ems.datamodel.dto.EventMasterDTO;
import com.ems.datamodel.dto.StatusDTO;
import com.ems.util.StatusConstant;

@ManagedBean(name = "eventBeanList")
@ViewScoped
public class EventBeanList extends AbstractMB {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8658025445945975898L;
	private List<EventMasterDTO> eventMasterList;
    private EventMasterDTO eventMasterDTO;
    EventMasterDAO eventMasterDAO = null;
    StatusDAO statusDAO = null;
   
    @ManagedProperty(value="#{pageNavBean}")
	private PageNavigationBean pageNavBean ;
    
	private List<StatusDTO> statusList;

       /**
     * @return the eventMasterList
     */
    public List<EventMasterDTO> getEventMasterList() {
        return eventMasterList;
    }

    /**
     * @param eventMasterList the eventMasterList to set
     */
    public void setEventMasterList(List<EventMasterDTO> eventMasterList) {
        this.eventMasterList = eventMasterList;
    }

    /**
     * @return the eventMasterDTO
     */
    public EventMasterDTO getEventMasterDTO() {
        return eventMasterDTO;
    }

    /**
     * @param eventMasterDTO the eventMasterDTO to set
     */
    public void setEventMasterDTO(EventMasterDTO eventMasterDTO) {
        this.eventMasterDTO = eventMasterDTO;
    }
    
 	public PageNavigationBean getPageNavBean() {
		return pageNavBean;
	}

	public void setPageNavBean(PageNavigationBean pageNavBean) {
		this.pageNavBean = pageNavBean;
	}
	 
    public List<StatusDTO> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<StatusDTO> statusList) {
		this.statusList = statusList;
	}

	@PostConstruct
    public void init()
    {
        eventMasterDAO = new EventMasterDAO();
        setEventMasterDTO(new EventMasterDTO());
        statusDAO = new StatusDAO();
        searchEventListing();
        populateStatusList();
    }

    // to search events
    public void searchEventListing()
    {
    	 setEventMasterList(eventMasterDAO.searchEvents(getEventMasterDTO(),pageNavBean.getLoggedInUserDTO()));	
    }
    
    // to reset search listing
    public void resetEventList()
    {
    	 setEventMasterDTO(new EventMasterDTO());
    	 setEventMasterList(new ArrayList<EventMasterDTO>());
    }
    
    // to delete an event
   public void deleteEvent(int eventId)
   {
        eventMasterDAO.deleteEventMaster(eventId);
       // setEventMasterList(eventMasterDAO.getEventMasterList(pageNavBean.getLoggedInUserDTO().getSuperUserId()));
        searchEventListing();
   }
   
   public void populateStatusList()
   {
	   setStatusList(statusDAO.getStatusListFor(StatusConstant.EVENT_STATUS.getStatusValue()));
   }
}