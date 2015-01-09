/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import com.ems.datamodel.dto.UserTypeDTO;
import com.ems.datamodel.entity.DTOEntityMapper;
import com.ems.datamodel.entity.UserType;

import java.util.ArrayList;
import java.util.List;

public class UserTypeDAO extends GenericDAO<UserType> {

    public UserTypeDAO() {
        super(UserType.class);
    }

    public List<UserTypeDTO> getUserTypeList() {
        List<UserTypeDTO> userTypeDTOList = new ArrayList<UserTypeDTO>();
        try {
            beginTransaction();
            List<UserType> userTypeList = findResults("UserType.findByUserTypeExSuperUser", null);
            for (UserType userType : userTypeList) {
                UserTypeDTO userTypeDTO = new UserTypeDTO();
                
                DTOEntityMapper.getMapper().map(userType, userTypeDTO);
                userTypeDTOList.add(userTypeDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return userTypeDTOList;
    }

    public UserType getUserType(int userTypeId) {
        UserType userType = new UserType();
        try {
            beginTransaction();
            userType = find(userTypeId);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return userType;
    }
}
