/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import com.ems.datamodel.dto.EventMasterDTO;
import com.ems.datamodel.entity.EventMaster;
import com.ems.datamodel.entity.ParticipantMaster;
import com.ems.datamodel.entity.ParticipantSpecimenMaster;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.Query;

/**
 *
 * @author rupesht
 */
public class ParticipantMasterDAO extends GenericDAO<ParticipantMaster> {

    public ParticipantMasterDAO() {
        super(ParticipantMaster.class);
    }

    public void saveParticipantMaster(Map<Integer, Map<Integer, Boolean>> parentMap, List<ParticipantSpecimenMaster> participantSpecimenMasterList, EventMasterDTO eventMasterDTO, int userId) {
        try {
            beginTransaction();
            EventMasterDAO eventMasterDAO = new EventMasterDAO();
            EventMaster eventMaster = eventMasterDAO.getEventMaster(eventMasterDTO.getEventId());
            for (Map.Entry<Integer, Map<Integer, Boolean>> entry1 : parentMap.entrySet()) {
                Query query = getEntityManager().createNamedQuery("ParticipantMaster.findByTicketId");
                query.setParameter("ticketId", entry1.getKey());
                List<ParticipantMaster> resultList = query.getResultList();
                if (resultList != null && resultList.size() > 0) {
                    for (Map.Entry<Integer, Boolean> entry : entry1.getValue().entrySet()) {
                        ParticipantMaster participantMaster = find(entry.getKey());
                        if (participantMaster != null) {
                            participantMaster.setFieldRequired(entry.getValue());
                        }
                        update(participantMaster);
                    }
                } else {
                    for (Map.Entry<Integer, Boolean> entry : entry1.getValue().entrySet()) {
                        ParticipantMaster participantMaster = new ParticipantMaster();
                        participantMaster.setTicketId(entry1.getKey());
                        participantMaster.setEventId(eventMaster);
                        ParticipantSpecimenMaster participantSpecimenMaster = new ParticipantSpecimenMaster(entry.getKey());
                        if (participantSpecimenMasterList.contains(participantSpecimenMaster)) {
                            participantSpecimenMaster = participantSpecimenMasterList.get(participantSpecimenMasterList.indexOf(participantSpecimenMaster));
                            participantMaster.setFieldName(participantSpecimenMaster.getFieldName());
                            participantMaster.setFieldType(participantSpecimenMaster.getFieldType());
                            participantMaster.setFieldRequired(entry.getValue());
                            participantMaster.setParticipantSpecimenId(participantSpecimenMaster.getParticipantSpecimenId());
                            participantMaster.setModifiedOn(new Date());
                            participantMaster.setModifiedBy(userId);
                            save(participantMaster);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
    }

    public void saveParticipantMaster(Integer ticketId, List<ParticipantSpecimenMaster> participantSpecimenMasterList, EventMasterDTO eventMasterDTO, int userId) {
        try {
            beginTransaction();
            EventMasterDAO eventMasterDAO = new EventMasterDAO();
            EventMaster eventMaster = eventMasterDAO.getEventMaster(eventMasterDTO.getEventId());
            for (ParticipantSpecimenMaster participantSpecimenMaster : participantSpecimenMasterList) {
                ParticipantMaster participantMaster = new ParticipantMaster();
                participantMaster.setTicketId(ticketId);
                participantMaster.setEventId(eventMaster);
                participantMaster.setFieldName(participantSpecimenMaster.getFieldName());
                participantMaster.setFieldType(participantSpecimenMaster.getFieldType());
                participantMaster.setFieldRequired(false);
                participantMaster.setParticipantSpecimenId(participantSpecimenMaster.getParticipantSpecimenId());
                participantMaster.setModifiedOn(new Date());
                participantMaster.setModifiedBy(userId);
                save(participantMaster);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
    }

    public Map<Integer, Boolean> getParticipantMapByTicketId(int ticketId) {
        Map<Integer, Boolean> participantMasterMap = null;
        try {
            beginTransaction();
            Query query = getEntityManager().createNamedQuery("ParticipantMaster.findByTicketId");
            query.setParameter("ticketId", ticketId);
            List<ParticipantMaster> resultList = query.getResultList();
            if (resultList != null && resultList.size() > 0) {
                participantMasterMap = new TreeMap<Integer, Boolean>();
                for (ParticipantMaster participantMaster : resultList) {
                    participantMasterMap.put(participantMaster.getParticipantId(), participantMaster.getFieldRequired());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return participantMasterMap;
    }
}
