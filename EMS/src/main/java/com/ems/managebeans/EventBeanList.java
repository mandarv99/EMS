/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import com.ems.datamodel.dao.EventMasterDAO;
import com.ems.datamodel.dto.EventMasterDTO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "eventBeanList")
@ViewScoped
public class EventBeanList extends AbstractMB {

    private List<EventMasterDTO> eventMasterList;
    private EventMasterDTO eventMasterDTO;
    EventMasterDAO eventMasterDAO = null;
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;

    @PostConstruct
    public void init() {

        eventMasterDAO = new EventMasterDAO();
        setEventMasterList(eventMasterDAO.getEventMasterList(loginBean.getLoginUserId()));
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

    public String editEvent(EventMasterDTO eventMaster) {
        this.eventMasterDTO = eventMaster;
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EventMaster", eventMaster);
        return "Event.xhtml ";
    }

    public String addEventMaster() {
        return "Event.xhtml ";
    }
    public void deleteEvent(int eventId){
        eventMasterDAO.deleteEventMaster(eventId);
        setEventMasterList(eventMasterDAO.getEventMasterList(loginBean.getLoginUserId()));
    }

    /**
     * @return the loginBean
     */
    public LoginBean getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean the loginBean to set
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
}
