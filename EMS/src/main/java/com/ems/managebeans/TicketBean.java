/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import com.ems.datamodel.dao.DiscountMasterDAO;
import com.ems.datamodel.dao.SuperCategoryDAO;
import com.ems.datamodel.dao.TicketDAO;
import com.ems.datamodel.dto.DiscountMasterDTO;
import com.ems.datamodel.dto.SuperCategoryTktDTO;
import com.ems.datamodel.dto.TicketDTO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rupesh
 */
@ManagedBean(name = "ticketBean")
@ViewScoped
public class TicketBean extends AbstractMB {

    private TicketDTO ticket;
    private List<TicketDTO> ticketDTOList;
    private SuperCategoryTktDTO superCategoryTktDTO;
    private List<SuperCategoryTktDTO> superTicketCategoryDTOList;
    private DiscountMasterDTO discountMasterDTO;
    private SuperCategoryDAO superCategoryDAO;
    @ManagedProperty(value = "#{eventBean}")
    private EventBean eventBean;
    private TicketDAO ticketDAO;
    private DiscountMasterDAO discountMasterDAO;

    public TicketBean() {
    }

    @PostConstruct
    public void init() {
        ticket = new TicketDTO();
        ticketDAO = new TicketDAO();
        superCategoryTktDTO = new SuperCategoryTktDTO();
        int eventId = getEventBean().getEventMasterDTO().getEventId();
        setTicketDTOList(ticketDAO.getTicketList(eventId));
        superCategoryDAO = new SuperCategoryDAO();
        setSuperTicketCategoryDTOList(superCategoryDAO.getSuperCategoryList(eventId));
        discountMasterDAO = new DiscountMasterDAO();
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

    public void saveTicketDetails() {
        try {
            if (getDiscountMasterDTO().getName() != null) {
                ticket.setDiscountMaster(discountMasterDTO);
            }
            if (ticketDAO.insertTicketMaster(ticket)) {
                showMessageInDialog("Ticket added successfully");
                ticket = new TicketDTO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveSuperTicketCategory() {
        try {
            if (superCategoryDAO.insertSuperCategory(superCategoryTktDTO)) {
                showMessageInDialog("Super Ticket category added successfully");
                superCategoryTktDTO = new SuperCategoryTktDTO();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
     * @return the eventBean
     */
    public EventBean getEventBean() {
        return eventBean;
    }

    /**
     * @param eventBean the eventBean to set
     */
    public void setEventBean(EventBean eventBean) {
        this.eventBean = eventBean;
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
}
