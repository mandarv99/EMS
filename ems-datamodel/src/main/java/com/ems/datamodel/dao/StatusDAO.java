/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ems.datamodel.dto.StatusDTO;
import com.ems.datamodel.entity.Status;

/**
 * @author snehalr
 *
 */
public class StatusDAO extends GenericDAO<Status> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3324954089359607105L;

	public StatusDAO() {
        super(Status.class);
    }

    public List<StatusDTO> getStatusListFor(String statusFor) {
        List<StatusDTO> statusDTOList = new ArrayList<StatusDTO>();
        try {
            beginTransaction();
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("statusFor", statusFor);
            List<Status> statusList = findResults("Status.findByStatusFor", parameters);
            for (Status userType : statusList) {
                StatusDTO statusDto = new StatusDTO();
                statusDto.setStatusId(userType.getStatusId());
                statusDto.setStatusName(userType.getStatusName());
                statusDto.setStatusFor(userType.getStatusFor());
               statusDTOList.add(statusDto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return statusDTOList;
    }

    public Status getStatus(int statusId) {
        Status statusType = new Status();
        try {
            beginTransaction();
            statusType = find(statusId);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return statusType;
    }
}
