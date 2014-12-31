/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import com.ems.datamodel.dto.DiscountMasterDTO;
import com.ems.datamodel.dto.TicketDTO;
import com.ems.datamodel.entity.DiscountMaster;
import com.ems.datamodel.entity.EventMaster;
import com.ems.datamodel.entity.SuperCategoryTkt;
import com.ems.datamodel.entity.TicketMaster;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rupesht
 */
public class TicketDAO extends GenericDAO<TicketMaster> {

    public TicketDAO() {
        super(TicketMaster.class);
    }

    public List<TicketDTO> getTicketList(int eventId) {

        List<TicketDTO> ticketMasterDTOList = new ArrayList<TicketDTO>();
        try {
            beginTransaction();
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("eventId", eventId);
            List<TicketMaster> ticketMasterList = findResults("TicketMaster.findByEventId", parameters);
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
                ticketDTO.setSuperCategory(ticketMaster.getSuperCategotyId() != null ? ticketMaster.getSuperCategotyId().getSuperCategotyId() : 0);
                ticketDTO.setTicketPrice(ticketMaster.getTicketPrice());
                ticketDTO.setTotalTickets(ticketMaster.getTotalTickets());
                ticketDTO.setTicketCategoryId(ticketMaster.getTicketId());
                ticketDTO.setTicketCategoryName(ticketMaster.getTicketName());
                ticketDTO.setDisclaimer(ticketMaster.getDisclaimer());
                ticketDTO.setEventId(ticketMaster.getEventId().getEventId());
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

    public boolean insertTicketMaster(TicketDTO ticketDTO) {
        boolean result = false;
        try {
            beginTransaction();
            TicketMaster ticketMaster = new TicketMaster();
            ticketMaster.setAgeLimitFrom(ticketDTO.getAgeFrom());
            ticketMaster.setAgeLimitTo(ticketDTO.getAgeTo());
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
            ticketMaster.setDisclaimer(ticketDTO.getDisclaimer());
            EventMasterDAO eventMasterDAO = new EventMasterDAO();
            EventMaster eventMaster = eventMasterDAO.getEventMaster(ticketDTO.getEventId());
            ticketMaster.setEventId(eventMaster);
            ticketMaster.setDiscountMasterCollection(getDiscountMasterList(ticketDTO, ticketMaster));
            super.save(ticketMaster);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return result;

    }

    public boolean updateTicketMaster(TicketDTO ticketDTO) {
        boolean result = false;
        try {
            beginTransaction();
            TicketMaster ticketMaster = new TicketMaster();
            ticketMaster.setAgeLimitFrom(ticketDTO.getAgeFrom());
            ticketMaster.setAgeLimitTo(ticketDTO.getAgeTo());
            ticketMaster.setIsDiscount(ticketDTO.isDiscount());
            ticketMaster.setSalesEndDate(ticketDTO.getSalesEndDate());
            ticketMaster.setMaxTktTransactions(ticketDTO.getMaxTicketsPerTransaction());
            ticketMaster.setMinTktTransactions(ticketDTO.getMinTicketsPerTransaction());
            ticketMaster.setIsRefundable(ticketDTO.isRefundable());
            ticketMaster.setSalesStartDate(ticketDTO.getSalesStartDate());
            SuperCategoryDAO superCategoryDAO = new SuperCategoryDAO();
            SuperCategoryTkt superCategoryTkt = superCategoryDAO.getSuperCategory(ticketDTO.getSuperCategory());
            ticketMaster.setSuperCategotyId(superCategoryTkt);
            EventMasterDAO eventMasterDAO = new EventMasterDAO();
            EventMaster eventMaster = eventMasterDAO.getEventMaster(ticketDTO.getEventId());
            ticketMaster.setEventId(eventMaster);
            ticketMaster.setTicketPrice(ticketDTO.getTicketPrice());
            ticketMaster.setTotalTickets(ticketDTO.getTotalTickets());
            ticketMaster.setTicketName(ticketDTO.getTicketCategoryName());
            ticketMaster.setDiscountMasterCollection(getDiscountMasterList(ticketDTO, ticketMaster));
            super.update(ticketMaster);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return result;

    }

    public boolean deleteTicketMaster(int ticketCategoryId) {
        TicketMaster ticketMaster = null;
        boolean result = false;
        try {
            beginTransaction();
            ticketMaster = find(ticketCategoryId);
            delete(ticketMaster);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return result;
    }

    private DiscountMasterDTO getDiscountMasterDTOList(TicketMaster ticketMaster) {
        DiscountMasterDTO discountMasterDTO = new DiscountMasterDTO();
        try {
            List<DiscountMaster> discountMasterList = (List<DiscountMaster>) ticketMaster.getDiscountMasterCollection();
            for (DiscountMaster discountMaster : discountMasterList) {
                discountMasterDTO.setDiscountStartDate(discountMaster.getDiscountStartDate());
                discountMasterDTO.setDiscountName(discountMaster.getDiscountName());
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
                discountMaster.setDiscountId(discountMasterDTO.getDiscountId());
                discountMaster.setCriteria(discountMasterDTO.getCriteria());
                discountMaster.setDiscountName(discountMasterDTO.getDiscountName());
                discountMaster.setCriteriaValues(discountMasterDTO.getCriteriaValues());
                discountMaster.setDiscountEndDate(discountMasterDTO.getDiscountEndDate());
                discountMaster.setDiscountStartDate(discountMasterDTO.getDiscountStartDate());
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
