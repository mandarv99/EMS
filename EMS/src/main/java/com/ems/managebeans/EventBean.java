/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.ems.datamodel.dao.CompanyDetailsDAO;
import com.ems.datamodel.dao.EventMasterDAO;
import com.ems.datamodel.dao.EventTypeDAO;
import com.ems.datamodel.dao.ParticipantMasterDAO;
import com.ems.datamodel.dao.ParticipantSpecimenMasterDAO;
import com.ems.datamodel.dao.SuperCategoryDAO;
import com.ems.datamodel.dao.TicketDAO;
import com.ems.datamodel.dto.CompanyDetailsDTO;
import com.ems.datamodel.dto.DiscountMasterDTO;
import com.ems.datamodel.dto.EventMasterDTO;
import com.ems.datamodel.dto.EventTypesDTO;
import com.ems.datamodel.dto.MapDTO;
import com.ems.datamodel.dto.SuperCategoryTktDTO;
import com.ems.datamodel.dto.TicketDTO;
import com.ems.datamodel.entity.ParticipantSpecimenMaster;

@ManagedBean(name = "eventBean")
@ViewScoped
public class EventBean extends AbstractMB {

    /**
     *
     */
    private static final long serialVersionUID = 7671523986670245517L;
    private EventMasterDTO eventMasterDTO;
    EventMasterDAO eventMasterDAO = null;
    private TicketDTO ticket;
    private List<TicketDTO> ticketDTOList;
    private SuperCategoryTktDTO superCategoryTktDTO;
    private List<SuperCategoryTktDTO> superTicketCategoryDTOList;
    private DiscountMasterDTO discountMasterDTO;
    private SuperCategoryDAO superCategoryDAO;
    private EventTypeDAO eventTypeDAO;
    private List<EventTypesDTO> eventTypesDTOList;
    private CompanyDetailsDAO companyDetailsDAO;
    private List<CompanyDetailsDTO> companyDetailsDTOList;
    private ParticipantSpecimenMasterDAO participantSpecimenMasterDAO;
    private List<ParticipantSpecimenMaster> participantSpecimenMasterList;
    private Map<Integer, Boolean> participantSpecimanMap;
    private Map<Integer, Map<Integer, Boolean>> parentMap;
    
    @ManagedProperty(value = "#{pageNavBean}")
    private PageNavigationBean pageNavBean;
    
    private TicketDAO ticketDAO;
    private ParticipantMasterDAO participantMasterDAO;
    private MapModel mapModel;
    private MapDTO mapDto;

  	@PostConstruct
    public void init() {

        eventMasterDAO = new EventMasterDAO();
        eventMasterDTO = new EventMasterDTO();        
        getDataFromRequestMap();

        ticket = new TicketDTO();
        superCategoryTktDTO = new SuperCategoryTktDTO();
        superTicketCategoryDTOList = new ArrayList<>();
        ticketDTOList = new ArrayList<>();
        superTicketCategoryDTOList = new ArrayList<>();

        discountMasterDTO = new DiscountMasterDTO();

        eventTypeDAO = new EventTypeDAO();
        eventTypesDTOList = eventTypeDAO.getEventTypesList();
        companyDetailsDAO = new CompanyDetailsDAO();
        setCompanyDetailsDTOList(companyDetailsDAO.getCompanyDetailsList(pageNavBean.getLoggedInUserDTO().getSuperUserId()));
        superCategoryDAO = new SuperCategoryDAO();
        ticketDAO = new TicketDAO();
        participantSpecimanMap = new HashMap<>();
        parentMap = new HashMap<>();
        participantSpecimenMasterDAO = new ParticipantSpecimenMasterDAO();
        participantMasterDAO = new ParticipantMasterDAO();
        participantSpecimenMasterList = participantSpecimenMasterDAO.getParticipantSpecimenMasterList();
        
        initialiseMap();
     }
	
	// to initialize the map parameters
	private void initialiseMap()
	{
		mapDto =  new MapDTO();
        mapModel =  new DefaultMapModel();
        mapDto.setLatitude(21.000000);
        mapDto.setLongitude(78.000000);
        mapDto.setZoom(6);
	}

    private void getDataFromRequestMap() {
        Object obj = getObjectFromFlash("eventMaster");
        if (obj != null) {
            this.eventMasterDTO = (EventMasterDTO) obj;
        }
    }

    public MapDTO getMapDto() {
  		return mapDto;
  	}

  	public void setMapDto(MapDTO mapDto) {
  		this.mapDto = mapDto;
  	}

  	public PageNavigationBean getPageNavBean() {
          return pageNavBean;
      }

      public void setPageNavBean(PageNavigationBean pageNavBean) {
          this.pageNavBean = pageNavBean;
      }

      public MapModel getMapModel() {
  		return mapModel;
  	}

  	public void setMapModel(MapModel mapModel) {
  		this.mapModel = mapModel;
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

    /**
     * @return the ticket
     */
    public TicketDTO getTicket() {
        return ticket;
    }

    /**
     * @param ticket the ticket to set
     */
    public void setTicket(TicketDTO ticket) {
        this.ticket = ticket;
    }

    /**
     * @return the ticketDTOList
     */
    public List<TicketDTO> getTicketDTOList() {
        return ticketDTOList;
    }

    /**
     * @param ticketDTOList the ticketDTOList to set
     */
    public void setTicketDTOList(List<TicketDTO> ticketDTOList) {
        this.ticketDTOList = ticketDTOList;
    }

    /**
     * @return the superCategoryTktDTO
     */
    public SuperCategoryTktDTO getSuperCategoryTktDTO() {
        return superCategoryTktDTO;
    }

    /**
     * @param superCategoryTktDTO the superCategoryTktDTO to set
     */
    public void setSuperCategoryTktDTO(SuperCategoryTktDTO superCategoryTktDTO) {
        this.superCategoryTktDTO = superCategoryTktDTO;
    }

    /**
     * @return the superTicketCategoryDTOList
     */
    public List<SuperCategoryTktDTO> getSuperTicketCategoryDTOList() {
        return superTicketCategoryDTOList;
    }

    /**
     * @param superTicketCategoryDTOList the superTicketCategoryDTOList to set
     */
    public void setSuperTicketCategoryDTOList(List<SuperCategoryTktDTO> superTicketCategoryDTOList) {
        this.superTicketCategoryDTOList = superTicketCategoryDTOList;
    }

    /**
     * @return the discountMasterDTO
     */
    public DiscountMasterDTO getDiscountMasterDTO() {
        return discountMasterDTO;
    }

    /**
     * @param discountMasterDTO the discountMasterDTO to set
     */
    public void setDiscountMasterDTO(DiscountMasterDTO discountMasterDTO) {
        this.discountMasterDTO = discountMasterDTO;
    }

    /**
     * @return the eventTypesDTOList
     */
    public List<EventTypesDTO> getEventTypesDTOList() {
        return eventTypesDTOList;
    }

    /**
     * @param eventTypesDTOList the eventTypesDTOList to set
     */
    public void setEventTypesDTOList(List<EventTypesDTO> eventTypesDTOList) {
        this.eventTypesDTOList = eventTypesDTOList;
    }

    /**
     * @return the companyDetailsDTOList
     */
    public List<CompanyDetailsDTO> getCompanyDetailsDTOList() {
        return companyDetailsDTOList;
    }

    /**
     * @param companyDetailsDTOList the companyDetailsDTOList to set
     */
    public void setCompanyDetailsDTOList(List<CompanyDetailsDTO> companyDetailsDTOList) {
        this.companyDetailsDTOList = companyDetailsDTOList;
    }

    /**
     * @return the participantSpecimenMasterList
     */
    public List<ParticipantSpecimenMaster> getParticipantSpecimenMasterList() {
        return participantSpecimenMasterList;
    }

    /**
     * @param participantSpecimenMasterList the participantSpecimenMasterList to
     * set
     */
    public void setParticipantSpecimenMasterList(List<ParticipantSpecimenMaster> participantSpecimenMasterList) {
        this.participantSpecimenMasterList = participantSpecimenMasterList;
    }

    /**
     * @return the participantSpecimanMap
     */
    public Map<Integer, Boolean> getParticipantSpecimanMap() {
        return participantSpecimanMap;
    }

    /**
     * @param participantSpecimanMap the participantSpecimanMap to set
     */
    public void setParticipantSpecimanMap(Map<Integer, Boolean> participantSpecimanMap) {
        this.participantSpecimanMap = participantSpecimanMap;
    }

    /**
     * @return the parentMap
     */
    public Map<Integer, Map<Integer, Boolean>> getParentMap() {
        return parentMap;
    }

    /**
     * @param parentMap the parentMap to set
     */
    public void setParentMap(Map<Integer, Map<Integer, Boolean>> parentMap) {
        this.parentMap = parentMap;
    }
    public void saveEvent() {
        try {
            eventMasterDTO.setAddedBy(pageNavBean.getLoggedInUserDTO().getUserId());
            if (eventMasterDAO.insertEventMaster(eventMasterDTO)) {
                displayInfoMessageToUser("Event added successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String onFlowProcess(FlowEvent event) {
        if (event.getOldStep().equals("event")) {
            if (eventMasterDTO != null && eventMasterDTO.getEventId() == null) {
                saveEvent();
            } else {
                // validate event start and end date
                if (eventMasterDTO.getEventStartDatetime().after(eventMasterDTO.getEventEndDatetime()) || eventMasterDTO.getEventStartDatetime().equals(eventMasterDTO.getEventEndDatetime())) {
                    displayErrorMessageToUser("Please Check Event Start and End Date");
                    return event.getOldStep();
                }

                updateEvent();
                superTicketCategoryDTOList = superCategoryDAO.getSuperCategoryList(eventMasterDTO.getEventId());
                superCategoryTktDTO = new SuperCategoryTktDTO();
                ticketDTOList = ticketDAO.getTicketList(eventMasterDTO.getEventId());
            }
        } else if (event.getNewStep().equals("participant")) {            
            for (TicketDTO ticketDTO : ticketDTOList) {
                participantSpecimanMap = participantMasterDAO.getParticipantMapByTicketId(ticketDTO.getTicketCategoryId());
                 if(participantSpecimanMap==null || participantSpecimanMap.isEmpty()){
                     participantSpecimanMap= new TreeMap<>();
                     for (ParticipantSpecimenMaster participantSpecimenMaster : participantSpecimenMasterList) {
                         participantSpecimanMap.put(participantSpecimenMaster.getParticipantSpecimenId(), Boolean.FALSE);
                     }
                }
                parentMap.put(ticketDTO.getTicketCategoryId(), participantSpecimanMap);
                participantSpecimanMap = new HashMap<>();
            }
        }
        return event.getNewStep();
    }

    public void insertSuperCategory() {
        try {
            if (eventMasterDTO != null && eventMasterDTO.getEventId() != null) {
                superCategoryTktDTO.setEventId(eventMasterDTO.getEventId());
                superCategoryTktDTO.setUpdatedBy(pageNavBean.getLoggedInUserDTO().getUserId());
                superCategoryTktDTO.setUpdatedOn(new Date());
                if (superCategoryDAO.insertSuperCategory(superCategoryTktDTO)) {
                    displayInfoMessageToUser("Super category inserted successfully");
                    superTicketCategoryDTOList = superCategoryDAO.getSuperCategoryList(eventMasterDTO.getEventId());
                    superCategoryTktDTO = new SuperCategoryTktDTO();
                }
            } else {
                displayErrorMessageToUser("Please Enter event first");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSuperCategory(int superCategotyId) {
        try {
            if (superCategoryTktDTO != null) {
                if (superCategoryDAO.deleteSuperCategory(superCategotyId)) {
                    displayInfoMessageToUser("Super category Deleted successfully");
                    superTicketCategoryDTOList = superCategoryDAO.getSuperCategoryList(eventMasterDTO.getEventId());
                }
            } else {
                displayErrorMessageToUser("Please Enter event first");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveTicketDetails() {
        try {
            if (ticket.isDiscount() && discountMasterDTO == null) {
                displayErrorMessageToUser("Please enter the discount.");
                return;
            }
            if (discountMasterDTO.getDiscountName() != null) {
                ticket.setDiscountMaster(discountMasterDTO);
            }
            ticket.setEventId(eventMasterDTO.getEventId());
            discountMasterDTO.setModifiedBy(pageNavBean.getLoggedInUserDTO().getUserId());
            ticket.setModifiedBy(pageNavBean.getLoggedInUserDTO().getUserId());
            if (ticketDAO.insertTicketMaster(ticket)) {
                participantMasterDAO.saveParticipantMaster(ticket.getTicketCategoryId(), participantSpecimenMasterList, eventMasterDTO, pageNavBean.getLoggedInUserDTO().getUserId());
                displayInfoMessageToUser("Ticket added successfully");
                ticketDTOList = ticketDAO.getTicketList(eventMasterDTO.getEventId());
                ticket = new TicketDTO();
                discountMasterDTO = new DiscountMasterDTO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTicketDetails() {
        try {
            if (ticket.isDiscount() && discountMasterDTO != null) {
                displayErrorMessageToUser("Please enter the discount.");
            }
            if (discountMasterDTO.getName() != null) {
                ticket.setDiscountMaster(discountMasterDTO);
            }
            if (ticketDAO.updateTicketMaster(ticket)) {
                displayInfoMessageToUser("Ticket updated successfully");
                ticketDTOList = ticketDAO.getTicketList(eventMasterDTO.getEventId());
                ticket = new TicketDTO();
                discountMasterDTO = new DiscountMasterDTO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void companyDetails() {
    }

    public void deleteTicketDetails(int ticketCategoryId) {
        try {
            if (ticketDAO.deleteTicketMaster(ticketCategoryId)) {
                displayInfoMessageToUser("Ticket deleted successfully");
                ticketDTOList = ticketDAO.getTicketList(eventMasterDTO.getEventId());
                ticket = new TicketDTO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDisclaimerChange() {
        if (eventMasterDTO != null && eventMasterDTO.getRequireDisclaimer() == 0) {
            eventMasterDTO.setDisclaimerRequired(true);
        } else {
            eventMasterDTO.setDisclaimerRequired(false);
        }
    }

    public String editEvent(EventMasterDTO eventMaster) {
        this.eventMasterDTO = eventMaster;
        return "Event.xhtml ";
    }

    public void updateEvent() {
        if (this.eventMasterDTO != null) {
            eventMasterDAO.updateEventMaster(eventMasterDTO);
            displayInfoMessageToUser("Event updated successfully");
        }
    }

    public void processCriteriaValue(AjaxBehaviorEvent event) {
        discountMasterDTO.setCriteriaValues(null);
        if (discountMasterDTO.getCriteriaType() == 1) {
            discountMasterDTO.setMaxValue(ticket.getTicketPrice().intValue());
        } else if (discountMasterDTO.getCriteriaType() == 2) {
            discountMasterDTO.setMaxValue(100);
        }
    }

    public void validateCriteriaValue(AjaxBehaviorEvent event) {
        if (discountMasterDTO.getCriteriaValues() != null && discountMasterDTO.getCriteriaValues() > discountMasterDTO.getMaxValue()) {
            displayErrorMessageToUser("Maximum Discount which can be availed :  " + discountMasterDTO.getMaxValue());
        }
    }


    public void saveParticipantDetails() {
        try {
            participantMasterDAO.saveParticipantMaster(parentMap, participantSpecimenMasterList, eventMasterDTO, pageNavBean.getLoggedInUserDTO().getUserId());
            displayInfoMessageToUser("Participant Information Updated Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // add marker on point select on the map
    public void onPointSelect(PointSelectEvent event)
    {
        LatLng latlng = event.getLatLng();
        eventMasterDTO.getMapDetails().setLatitude(latlng.getLat());
        eventMasterDTO.getMapDetails().setLongitude(latlng.getLng());
       
        // refresh map center & zoom
        mapDto.setLatitude(latlng.getLat());
        mapDto.setLongitude(latlng.getLng());
        mapDto.setZoom(15);
      
        // remove earlier marker & add new markers
        mapModel = new DefaultMapModel();
	    Marker marker = new Marker(latlng, "");
	    mapModel.addOverlay(marker);
   }
}