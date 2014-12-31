/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import com.ems.datamodel.dto.DiscountMasterDTO;
import com.ems.datamodel.entity.DiscountMaster;

public class DiscountMasterDAO extends GenericDAO<DiscountMaster> {

    public DiscountMasterDAO() {
        super(DiscountMaster.class);
    }

    public DiscountMasterDTO getDiscountMaster(int ticketId) {
        DiscountMasterDTO discountMasterDTO = new DiscountMasterDTO();
        DiscountMaster discountMaster = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return discountMasterDTO;
    }
}
