/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import com.ems.datamodel.dto.DiscountMasterDTO;
import com.ems.datamodel.dto.EventMasterDTO;
import com.ems.datamodel.dto.TicketDTO;
import com.ems.datamodel.entity.CompanyDetails;
import com.ems.datamodel.entity.DiscountMaster;
import com.ems.datamodel.entity.EventMaster;
import com.ems.datamodel.entity.SuperCategoryTkt;
import com.ems.datamodel.entity.TicketMaster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventMasterDAO extends GenericDAO<EventMaster> {

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
                eventMasterList.add(eventMasterDTO);
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
            CompanyDetailsDAO companyDetailsDAO = new CompanyDetailsDAO();
            CompanyDetails companyDetails = companyDetailsDAO.getCompanyDetails(eventMasterDTO.getCompanyId());
            eventMaster.setCompanyId(companyDetails);
//            eventMaster.setTicketMasterCollection(getTicketMaster(eventMasterDTO.getTicketMasterDTOList(), eventMaster));
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
