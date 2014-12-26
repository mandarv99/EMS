/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.ems.datamodel.dao.EventMasterDAO;
import com.ems.datamodel.dto.EventMasterDTO;

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
   
    @ManagedProperty(value="#{pageNavBean}")
	private PageNavigationBean pageNavBean ;

    
    @PostConstruct
    public void init()
    {
        eventMasterDAO = new EventMasterDAO();
        setEventMasterList(eventMasterDAO.getEventMasterList(pageNavBean.getLoggedInUserDTO().getSuperUserId()));
        setEventMasterDTO(new EventMasterDTO());
    }

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
    
    public void deleteEvent(int eventId){
        eventMasterDAO.deleteEventMaster(eventId);
        setEventMasterList(eventMasterDAO.getEventMasterList(pageNavBean.getLoggedInUserDTO().getSuperUserId()));
    }

	public PageNavigationBean getPageNavBean() {
		return pageNavBean;
	}

	public void setPageNavBean(PageNavigationBean pageNavBean) {
		this.pageNavBean = pageNavBean;
	}
}
