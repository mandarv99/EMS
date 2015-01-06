/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import com.ems.datamodel.entity.ParticipantSpecimenMaster;
import java.util.List;

/**
 *
 * @author Rupesh
 */
public class ParticipantSpecimenMasterDAO extends GenericDAO<ParticipantSpecimenMaster> {

    public ParticipantSpecimenMasterDAO() {
        super(ParticipantSpecimenMaster.class);
    }

    public List<ParticipantSpecimenMaster> getParticipantSpecimenMasterList() {
        List<ParticipantSpecimenMaster> participantSpecimenMasterList = null;
        try {
            beginTransaction();
            participantSpecimenMasterList = findAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return participantSpecimenMasterList;
    }

}
