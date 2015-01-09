/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import com.ems.datamodel.dto.EventTypesDTO;
import com.ems.datamodel.entity.DTOEntityMapper;
import com.ems.datamodel.entity.EventTypes;

import java.util.ArrayList;
import java.util.List;

public class EventTypeDAO extends GenericDAO<EventTypes> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6149250605018274899L;

	public EventTypeDAO() {
        super(EventTypes.class);
    }

    public List<EventTypesDTO> getEventTypesList() {
        List<EventTypesDTO> eventTypesDTOList = new ArrayList<EventTypesDTO>();
        try {
            beginTransaction();
            List<EventTypes> eventTypesList = findAll();
            for (EventTypes eventTypes : eventTypesList) {
                EventTypesDTO eventTypesDTO = new EventTypesDTO();
                DTOEntityMapper.getMapper().map(eventTypes, eventTypesDTO);
                eventTypesDTOList.add(eventTypesDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return eventTypesDTOList;
    }
}
