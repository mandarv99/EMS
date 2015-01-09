/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ems.datamodel.dto.DiscountMasterDTO;
import com.ems.datamodel.dto.EventMasterDTO;
import com.ems.datamodel.dto.SignUpDTO;
import com.ems.datamodel.dto.TicketDTO;
import com.ems.datamodel.entity.CompanyDetails;
import com.ems.datamodel.entity.DiscountMaster;
import com.ems.datamodel.entity.EventMaster;
import com.ems.datamodel.entity.SuperCategoryTkt;
import com.ems.datamodel.entity.TicketMaster;

public class EventMasterDAO extends GenericDAO<EventMaster> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -203790128008665235L;
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	public EventMasterDAO() {
        super(EventMaster.class);
    }

    public List<EventMasterDTO> getEventMasterList(Integer addedBy) {
        List<EventMasterDTO> eventMasterList = new ArrayList<EventMasterDTO>();
        try {
            beginTransaction();
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("addedBy", addedBy);
            List<EventMaster> eventMasterEnList = super.findResults("EventMaster.findByAddedBy", parameters);
            for (EventMaster eventMaster : eventMasterEnList) {
                EventMasterDTO eventMasterDTO = new EventMasterDTO();
                eventMasterDTO.setEventId(eventMaster.getEventId());
                eventMasterDTO.setEventName(eventMaster.getEventName());
                eventMasterDTO.setEventStartDatetime(eventMaster.getEventStartDatetime());
                eventMasterDTO.setEventEndDatetime(eventMaster.getEventEndDatetime());
                eventMasterDTO.setEventDescription(eventMaster.getEventDescription());
                eventMasterDTO.setPaidEvent(eventMaster.getIsFreeEvent());
                eventMasterDTO.setEventLocation(eventMaster.getEventAddress());
                eventMasterDTO.setEventTypeId(eventMaster.getEventTypeId());
                eventMasterDTO.setCompanyId(eventMaster.getCompanyId().getCompanyId());
                eventMasterDTO.setIsSittingArrangmentRequired(eventMaster.getRequiredSittingArrangement());
                eventMasterDTO.setRequireDisclaimer(eventMaster.getRequireDisclaimer());
                eventMasterDTO.setBibNumbering(eventMaster.getBibNumbering());
                eventMasterDTO.setEventStatus(eventMaster.getEventStatus());
                eventMasterDTO.setIsDiscounted(eventMaster.getIsDiscounted());
                eventMasterDTO.setEventAddress(eventMaster.getEventAddress());
                eventMasterDTO.setDesclaimer(eventMaster.getDisclaimer());
                  	eventMasterDTO.getMapDetails().setLatitude(eventMaster.getLatitude());
                  	eventMasterDTO.getMapDetails().setLongitude(eventMaster.getLongitude());
                eventMasterList.add(eventMasterDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return eventMasterList;
    }

    // to search based on search criteria
    public List<EventMasterDTO> searchEvents(EventMasterDTO eventMasterDTO, SignUpDTO loggedInUser)
    {
     	Date startDate = new Date();
    	Date endDate =  new Date();

        List<EventMasterDTO> eventMasterList = new ArrayList<EventMasterDTO>();
        try 
        { 
        	beginTransaction();
            EntityManager em = getEntityManager();

            String sql ="select c FROM EventMaster c  "
            		+ " , CompanyDetails cd  " 
					+"  , Users u "
					+" where c.companyId = cd.companyId " 
					+"	and cd.superUserId = u.superUserId " 
					+"	and u.superUserId = :superUserId ";
              
            if(eventMasterDTO.getEventName()!=null && !eventMasterDTO.getEventName().trim().isEmpty())
            	sql+=" and c.eventName like :eventName ";
            
            if (eventMasterDTO.getEventTypeId() != null)  
            	sql+=" and c.eventTypeId = :eventTypeId ";
            
            if (eventMasterDTO.getEventStatus() != null && eventMasterDTO.getEventStatus() != 0)  
            	sql+=" and c.eventStatus = :eventStatus ";
            
            if (eventMasterDTO.getEventStartDatetime() != null) 
            {
            	sql+=" and c.eventStartDatetime >= :eventStartDatetime ";
            	String sDAte = sdf1.format(eventMasterDTO.getEventStartDatetime()) + " 00:00:00";
	        	startDate = sdf2.parse(sDAte);
            }
            
            if (eventMasterDTO.getEventEndDatetime() != null) 
            {
            	sql+=" and c.eventEndDatetime <= :eventEndDatetime ";
            	String eDAte = sdf1.format(eventMasterDTO.getEventEndDatetime()) + " 23:59:59";
            	endDate = sdf2.parse(eDAte);
            }

        	TypedQuery<EventMaster> query = (TypedQuery<EventMaster>) em.createQuery(sql);
        	
    		query.setParameter("superUserId", loggedInUser.getSuperUserId());
 		
        	if(eventMasterDTO.getEventName()!=null && !eventMasterDTO.getEventName().trim().isEmpty())
        		query.setParameter("eventName", eventMasterDTO.getEventName()+"%");
        	
            if (eventMasterDTO.getEventTypeId() != null)  
            	query.setParameter("eventTypeId", eventMasterDTO.getEventTypeId());
            
            if (eventMasterDTO.getEventStatus() != null && eventMasterDTO.getEventStatus() != 0)  
            	query.setParameter("eventStatus", eventMasterDTO.getEventStatus());
            
            if (eventMasterDTO.getEventStartDatetime() != null) 
            	query.setParameter("eventStartDatetime", startDate);
             
            if (eventMasterDTO.getEventEndDatetime() != null) 
            	query.setParameter("eventEndDatetime", endDate );
            
        	List<EventMaster> eventEnList = query.getResultList();
              
            for (EventMaster eventMasterD : eventEnList) {
            	 EventMasterDTO evMasterDTO = new EventMasterDTO();
            	 evMasterDTO.setEventId(eventMasterD.getEventId());
            	 evMasterDTO.setEventName(eventMasterD.getEventName());
            	 evMasterDTO.setEventStartDatetime(eventMasterD.getEventStartDatetime());
            	 evMasterDTO.setEventEndDatetime(eventMasterD.getEventEndDatetime());
            	 evMasterDTO.setEventDescription(eventMasterD.getEventDescription());
            	 evMasterDTO.setPaidEvent(eventMasterD.getIsFreeEvent());
                 evMasterDTO.setEventLocation(eventMasterD.getEventAddress());
                 evMasterDTO.setEventTypeId(eventMasterD.getEventTypeId());
                 evMasterDTO.setCompanyId(eventMasterD.getCompanyId().getCompanyId());
                 evMasterDTO.setIsSittingArrangmentRequired(eventMasterD.getRequiredSittingArrangement());
                 evMasterDTO.setRequireDisclaimer(eventMasterD.getRequireDisclaimer());
                 evMasterDTO.setBibNumbering(eventMasterD.getBibNumbering());
                 evMasterDTO.setEventStatus(eventMasterD.getEventStatus());
                 evMasterDTO.setIsDiscounted(eventMasterD.getIsDiscounted());
                 evMasterDTO.setEventAddress(eventMasterD.getEventAddress());
                 evMasterDTO.setDesclaimer(eventMasterD.getDisclaimer());
                  	eventMasterDTO.getMapDetails().setLatitude(eventMasterD.getLatitude());
                  	eventMasterDTO.getMapDetails().setLongitude(eventMasterD.getLongitude());
                 eventMasterList.add(evMasterDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return eventMasterList;
    }
    
    public EventMaster getEventMaster(int eventId) {
        EventMaster eventMaster = null;
        try {
            beginTransaction();
            eventMaster = find(eventId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return eventMaster;
    }

    public EventMaster getEventMaster(EventMasterDTO eventMasterDTO) {
        EventMaster eventMaster = null;
        try {
            beginTransaction();
            eventMaster = find(eventMasterDTO.getEventId());
            eventMasterDTO.setEventName(eventMaster.getEventName());
            eventMasterDTO.setEventStartDatetime(eventMaster.getEventStartDatetime());
            eventMasterDTO.setEventEndDatetime(eventMaster.getEventEndDatetime());
            eventMasterDTO.setEventLocation(eventMaster.getEventAddress());
            eventMasterDTO.setEventHeaderImage(eventMaster.getEventHeaderImage());
            eventMasterDTO.setEventTypeId(eventMaster.getEventTypeId());
            eventMasterDTO.setBibNumbering(eventMaster.getBibNumbering());
            eventMasterDTO.setDesclaimer(eventMaster.getDisclaimer());
            eventMasterDTO.setEventAddress(eventMaster.getEventAddress());
            eventMasterDTO.setEventDescription(eventMaster.getEventDescription());
            eventMasterDTO.setEventStatus(eventMaster.getEventStatus());
            eventMasterDTO.setIsDiscounted(eventMaster.getIsDiscounted());
            eventMasterDTO.setPaidEvent(eventMaster.getIsFreeEvent());
            eventMasterDTO.setRequireDisclaimer(eventMaster.getRequireDisclaimer());
            eventMasterDTO.setIsSittingArrangmentRequired(eventMaster.getRequiredSittingArrangement());
            eventMasterDTO.setTicketMasterDTOList(getTicketList((List<TicketMaster>) eventMaster.getTicketMasterCollection()));
             	eventMasterDTO.getMapDetails().setLatitude(eventMaster.getLatitude());
             	eventMasterDTO.getMapDetails().setLongitude(eventMaster.getLongitude());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return eventMaster;
    }

    public boolean deleteEventMaster(int eventId) {
        EventMaster eventMaster = null;
        boolean result = false;
        try {
            beginTransaction();
            eventMaster = find(eventId);
            delete(eventMaster);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return result;
    }

    public boolean insertEventMaster(EventMasterDTO eventMasterDTO) {
        boolean result = false;
        EventMaster eventMaster = null;
        try {
            beginTransaction();
            eventMaster = new EventMaster();
            eventMaster.setBibNumbering(eventMasterDTO.isBibNumbering());
            eventMaster.setDisclaimer(eventMasterDTO.getDesclaimer());
            eventMaster.setEventAddress(eventMasterDTO.getEventAddress());
            eventMaster.setEventDescription(eventMasterDTO.getEventDescription());
            eventMaster.setEventEndDatetime(eventMasterDTO.getEventEndDatetime());
            eventMaster.setEventName(eventMasterDTO.getEventName());
            eventMaster.setEventStartDatetime(eventMasterDTO.getEventStartDatetime());
            eventMaster.setEventStatus(eventMasterDTO.getEventStatus());
            eventMaster.setEventTypeId(eventMasterDTO.getEventTypeId());
            eventMaster.setIsDiscounted(eventMasterDTO.getIsDiscounted());
            eventMaster.setIsFreeEvent(eventMasterDTO.isPaidEvent());
            eventMaster.setRequireDisclaimer(eventMasterDTO.getRequireDisclaimer());
            eventMaster.setRequiredSittingArrangement(eventMasterDTO.isIsSittingArrangmentRequired());
            eventMaster.setEventUrl("dhd");
            eventMaster.setAddedBy(eventMasterDTO.getAddedBy());
            eventMaster.setAddedOn(new Date());
            CompanyDetailsDAO companyDetailsDAO = new CompanyDetailsDAO();
            CompanyDetails companyDetails = companyDetailsDAO.getCompanyDetails(eventMasterDTO.getCompanyId());
            eventMaster.setCompanyId(companyDetails);
//            eventMaster.setTicketMasterCollection(getTicketMaster(eventMasterDTO.getTicketMasterDTOList(), eventMaster));
           
            	eventMaster.setLatitude(eventMasterDTO.getMapDetails().getLatitude());
            	eventMaster.setLongitude(eventMasterDTO.getMapDetails().getLongitude());
               
            save(eventMaster);
            eventMasterDTO.setEventId(eventMaster.getEventId());
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return result;
    }

    public List<TicketMaster> getTicketMaster(List<TicketDTO> ticketMasterDTOList, EventMaster eventMaster) {
        List<TicketMaster> ticketMasterList = new ArrayList<TicketMaster>();
        try {
            for (TicketDTO ticketDTO : ticketMasterDTOList) {
                TicketMaster ticketMaster = new TicketMaster();
                ticketMaster.setAgeLimitFrom(ticketDTO.getAgeFrom());
                ticketMaster.setAgeLimitTo(ticketDTO.getAgeTo());
                ticketMaster.setEventId(ticketMaster.getEventId());
                ticketMaster.setIsDiscount(ticketDTO.isDiscount());
                ticketMaster.setSalesEndDate(ticketDTO.getSalesEndDate());
                ticketMaster.setMaxTktTransactions(ticketDTO.getMaxTicketsPerTransaction());
                ticketMaster.setMinTktTransactions(ticketDTO.getMinTicketsPerTransaction());
                ticketMaster.setIsRefundable(ticketDTO.isRefundable());
                ticketMaster.setSalesStartDate(ticketDTO.getSalesStartDate());
                SuperCategoryDAO superCategoryDAO = new SuperCategoryDAO();
                SuperCategoryTkt superCategoryTkt = superCategoryDAO.getSuperCategory(ticketDTO.getSuperCategory());
                ticketMaster.setSuperCategotyId(superCategoryTkt);
                ticketMaster.setTicketPrice(ticketDTO.getTicketPrice());
                ticketMaster.setTotalTickets(ticketDTO.getTotalTickets());
                ticketMaster.setTicketName(ticketDTO.getTicketCategoryName());
                ticketMaster.setEventId(eventMaster);
                ticketMaster.setDiscountMasterCollection(getDiscountMasterList(ticketDTO, ticketMaster));
                ticketMasterList.add(ticketMaster);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return ticketMasterList;

    }

    public boolean updateEventMaster(EventMasterDTO eventMasterDTO) {
        boolean result = false;
        EventMaster eventMaster = null;
        try {
            beginTransaction();
            eventMaster = find(eventMasterDTO.getEventId());
            eventMaster.setBibNumbering(eventMasterDTO.isBibNumbering());
            eventMaster.setDisclaimer(eventMasterDTO.getDesclaimer());
            eventMaster.setEventAddress(eventMasterDTO.getEventAddress());
            eventMaster.setEventDescription(eventMasterDTO.getEventDescription());
            eventMaster.setEventEndDatetime(eventMasterDTO.getEventEndDatetime());
            eventMaster.setEventName(eventMasterDTO.getEventName());
            eventMaster.setEventStartDatetime(eventMasterDTO.getEventStartDatetime());
            eventMaster.setEventStatus(eventMasterDTO.getEventStatus());
            eventMaster.setEventTypeId(eventMasterDTO.getEventTypeId());
            eventMaster.setIsDiscounted(eventMasterDTO.getIsDiscounted());
            eventMaster.setIsFreeEvent(eventMasterDTO.isPaidEvent());
            eventMaster.setRequireDisclaimer(eventMasterDTO.getRequireDisclaimer());
            eventMaster.setRequiredSittingArrangement(eventMasterDTO.isIsSittingArrangmentRequired());
           	eventMaster.setLatitude(eventMasterDTO.getMapDetails().getLatitude());
            eventMaster.setLongitude(eventMasterDTO.getMapDetails().getLongitude());
             
            eventMaster.setEventUrl("dhd");
            
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return result;
    }

    public List<TicketDTO> getTicketList(List<TicketMaster> ticketMasterList) {

        List<TicketDTO> ticketMasterDTOList = new ArrayList<TicketDTO>();
        try {
            beginTransaction();
            for (TicketMaster ticketMaster : ticketMasterList) {
                TicketDTO ticketDTO = new TicketDTO();
                ticketDTO.setAgeFrom(ticketMaster.getAgeLimitFrom());
                ticketDTO.setAgeTo(ticketMaster.getAgeLimitTo());
                ticketDTO.setDiscount(ticketMaster.getIsDiscount());
                ticketDTO.setSalesEndDate(ticketMaster.getSalesEndDate());
                ticketDTO.setMaxTicketsPerTransaction(ticketMaster.getMaxTktTransactions());
                ticketDTO.setMinTicketsPerTransaction(ticketMaster.getMinTktTransactions());
                ticketDTO.setRefundable(ticketMaster.getIsRefundable());
                ticketDTO.setSalesStartDate(ticketMaster.getSalesStartDate());
                ticketDTO.setSuperCategory(ticketMaster.getSuperCategotyId().getSuperCategotyId());
                ticketDTO.setSuperCategory(ticketMaster.getTicketId());
                ticketDTO.setTicketPrice(ticketMaster.getTicketPrice());
                ticketDTO.setTotalTickets(ticketMaster.getTotalTickets());
                ticketDTO.setDiscountMaster(getDiscountMasterDTOList(ticketMaster));
                ticketMasterDTOList.add(ticketDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return ticketMasterDTOList;
    }

    private DiscountMasterDTO getDiscountMasterDTOList(TicketMaster ticketMaster) {
        DiscountMasterDTO discountMasterDTO = new DiscountMasterDTO();
        try {
            List<DiscountMaster> discountMasterList = (List<DiscountMaster>) ticketMaster.getDiscountMasterCollection();
            for (DiscountMaster discountMaster : discountMasterList) {
                discountMasterDTO.setCriteria(discountMaster.getCriteria());
                discountMasterDTO.setCriteriaValues(discountMaster.getCriteriaValues());
                discountMasterDTO.setDiscountEndDate(discountMaster.getDiscountEndDate());
                discountMasterDTO.setDiscountId(discountMaster.getDiscountId());
                discountMasterDTO.setEventId(discountMaster.getEventId().getEventId());
                discountMasterDTO.setMaxPeopeAvail(discountMaster.getMaxPeopeAvail());
                discountMasterDTO.setTicketId(ticketMaster.getTicketId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discountMasterDTO;
    }

    private List<DiscountMaster> getDiscountMasterList(TicketDTO ticketDTO, TicketMaster ticketMaster) {
        List<DiscountMaster> discountMasterList = new ArrayList<DiscountMaster>();
        try {
            DiscountMasterDTO discountMasterDTO = ticketDTO.getDiscountMaster();
            if (discountMasterDTO != null) {
                DiscountMaster discountMaster = new DiscountMaster();
                discountMaster.setCriteria(discountMasterDTO.getCriteria());
                discountMaster.setCriteriaValues(discountMasterDTO.getCriteriaValues());
                discountMaster.setDiscountEndDate(discountMasterDTO.getDiscountEndDate());
                discountMaster.setDiscountId(discountMasterDTO.getDiscountId());
                discountMaster.setEventId(ticketMaster.getEventId());
                discountMaster.setMaxPeopeAvail(discountMasterDTO.getMaxPeopeAvail());
                discountMaster.setTicketId(ticketMaster);
                discountMasterList.add(discountMaster);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discountMasterList;
    }
}
