/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import com.ems.datamodel.dto.SuperCategoryTktDTO;
import com.ems.datamodel.entity.EventMaster;
import com.ems.datamodel.entity.SuperCategoryTkt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperCategoryDAO extends GenericDAO<SuperCategoryTkt> {

    public SuperCategoryDAO() {
        super(SuperCategoryTkt.class);
    }

    public List<SuperCategoryTktDTO> getSuperCategoryList(int eventId) {
        List<SuperCategoryTktDTO> superCategoryTktDTOList = new ArrayList<SuperCategoryTktDTO>();
        try {
            beginTransaction();
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("eventId", eventId);
            List<SuperCategoryTkt> superCategoryList = findResults("SuperCategoryTkt.findByEventId", parameters);
            for (SuperCategoryTkt superCategoryTkt : superCategoryList) {
                SuperCategoryTktDTO superCategoryTktDTO = new SuperCategoryTktDTO();
                superCategoryTktDTO.setSuperCategotyId(superCategoryTkt.getSuperCategotyId());
                superCategoryTktDTO.setSuperCategoryName(superCategoryTkt.getSuperCategoryName());
                superCategoryTktDTO.setEventId(superCategoryTkt.getEventId().getEventId());
                superCategoryTktDTOList.add(superCategoryTktDTO);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return superCategoryTktDTOList;
    }

    public SuperCategoryTkt getSuperCategory(int superCategoryId) {
        SuperCategoryTkt superCategoryTkt = null;
        try {
            beginTransaction();
            superCategoryTkt = find(superCategoryId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return superCategoryTkt;
    }

    public boolean deleteSuperCategory(int superCategoryId) {
        SuperCategoryTkt superCategoryTkt = null;
        boolean result = false;
        try {
            beginTransaction();
            superCategoryTkt = find(superCategoryId);
            delete(superCategoryTkt);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return result;
    }

    public boolean insertSuperCategory(SuperCategoryTktDTO superCategoryTktDTO) {
        boolean result = false;
        EventMasterDAO eventMasterDAO = new EventMasterDAO();
        try {
            beginTransaction();
            SuperCategoryTkt superCategoryTkt = new SuperCategoryTkt();
            EventMaster eventMaster = eventMasterDAO.getEventMaster(superCategoryTktDTO.getEventId());
            superCategoryTkt.setEventId(eventMaster);
            superCategoryTkt.setSuperCategoryName(superCategoryTktDTO.getSuperCategoryName());
            superCategoryTkt.setUpdatedBy(superCategoryTktDTO.getSuperCategotyId());
            superCategoryTkt.setUpdatedOn(superCategoryTktDTO.getUpdatedOn());
            save(superCategoryTkt);
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return result;
    }
}
