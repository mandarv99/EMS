/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import com.ems.datamodel.dto.CompanyDetailsDTO;
import com.ems.datamodel.entity.CompanyDetails;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyDetailsDAO extends GenericDAO<CompanyDetails> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1870110896165331081L;

	public CompanyDetailsDAO() {
        super(CompanyDetails.class);
    }

    public List<CompanyDetailsDTO> getCompanyDetailsList(int superUserId) {
        List<CompanyDetailsDTO> companyDetailsDTOList = new ArrayList<CompanyDetailsDTO>();
        try {
            beginTransaction();
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("superUserId", superUserId);
            List<CompanyDetails> companyDetailsList = super.findResults("CompanyDetails.findBySuperUserId", parameters);
            for (CompanyDetails companyDetails : companyDetailsList) {
                CompanyDetailsDTO companyDetailsDTO = new CompanyDetailsDTO();
                companyDetailsDTO.setAddress1(companyDetails.getAddress1());
                companyDetailsDTO.setAddress2(companyDetails.getAddress2());
                companyDetailsDTO.setBankAccountNo(companyDetails.getBankAcctNo());
                companyDetailsDTO.setConfirmBankAccountNo(companyDetails.getBankAcctNo());
                companyDetailsDTO.setBankName(companyDetails.getBankName());
                companyDetailsDTO.setBranchName(companyDetails.getBranchName());
                companyDetailsDTO.setId(companyDetails.getCompanyId());
                companyDetailsDTO.setCompanyName(companyDetails.getCompanyName());
                companyDetailsDTO.setIfscCode(companyDetails.getIFSCcode());
                companyDetailsDTO.setPhoneNo(companyDetails.getPhone1());
                companyDetailsDTOList.add(companyDetailsDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return companyDetailsDTOList;
    }

    public void insertCompanyDetails(CompanyDetailsDTO companyDetailsDTO, int userId , int superUserId) {
        try {
            beginTransaction();
            CompanyDetails companyDetails = new CompanyDetails();
            companyDetails.setAddress1(companyDetailsDTO.getAddress1());
            companyDetails.setAddress2(companyDetailsDTO.getAddress2());
            companyDetails.setBankAcctNo(companyDetailsDTO.getBankAccountNo());
            companyDetails.setBankName(companyDetailsDTO.getBankName());
            companyDetails.setBranchName(companyDetailsDTO.getBranchName());
//            companyDetails.setCompanyId(companyDetailsDTO.getId());
            companyDetails.setCompanyName(companyDetailsDTO.getCompanyName());
            companyDetails.setIFSCcode(companyDetailsDTO.getIfscCode());
            companyDetails.setPhone1(companyDetailsDTO.getPhoneNo());
            companyDetails.setAddedBy(userId);
            companyDetails.setAddedOn(new Date());
            companyDetails.setSuperUserId(superUserId);
            super.save(companyDetails);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
    }

    public void updateCompanyDetails(CompanyDetailsDTO companyDetailsDTO, int userId) {
        try {
            beginTransaction();
            CompanyDetails companyDetails = super.find(companyDetailsDTO.getId());
            companyDetails.setAddress1(companyDetailsDTO.getAddress1());
            companyDetails.setAddress2(companyDetailsDTO.getAddress2());
            companyDetails.setBankAcctNo(companyDetailsDTO.getBankAccountNo());
            companyDetails.setBankName(companyDetailsDTO.getBankName());
            companyDetails.setBranchName(companyDetailsDTO.getBranchName());
            companyDetails.setCompanyId(companyDetailsDTO.getId());
            companyDetails.setCompanyName(companyDetailsDTO.getCompanyName());
            companyDetails.setIFSCcode(companyDetailsDTO.getIfscCode());
            companyDetails.setPhone1(companyDetailsDTO.getPhoneNo());
           // companyDetails.setAddedBy(userId);
           // companyDetails.setAddedOn(new Date());
            super.save(companyDetails);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
    }

    public void deleteCompanyDetails(CompanyDetailsDTO companyDetailsDTO) {
        try {
            beginTransaction();
            CompanyDetails companyDetails = super.find(companyDetailsDTO.getId());
            if (companyDetails != null) {
                super.delete(companyDetails);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
    }

    public CompanyDetails getCompanyDetails(int companyId) {
        CompanyDetails companyDetails = null;
        try {
            beginTransaction();
            companyDetails = super.find(companyId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return companyDetails;
    }
}
