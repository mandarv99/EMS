/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import com.ems.datamodel.dao.CompanyDetailsDAO;
import com.ems.datamodel.dto.CompanyDetailsDTO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "companyDetailsBean")
@ViewScoped
public class CompanyDetailsBean extends AbstractMB {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6366475952326500974L;
	private CompanyDetailsDTO companyDetails;
    private List<CompanyDetailsDTO> companyDetailsList;
    CompanyDetailsDAO companyDetailsDAO = null;
    
    @ManagedProperty(value="#{pageNavBean}")
  	private PageNavigationBean pageNavBean ;


    public CompanyDetailsBean() {
    }

    @PostConstruct
    public void init()
    {
        companyDetails = new CompanyDetailsDTO();
        companyDetailsDAO = new CompanyDetailsDAO();
        companyDetailsList = companyDetailsDAO.getCompanyDetailsList(pageNavBean.getLoggedInUserDTO().getUserId());
        
       getDataFromRequestMap();
    }
    
    private void getDataFromRequestMap()
    {
    	Object obj= getObjectFromFlash("companyDetails");
    	if(obj!=null)
    		this.companyDetails = (CompanyDetailsDTO) obj;
    }

    /**
     * @return the companyDetails
     */
    public CompanyDetailsDTO getCompanyDetails() {
        return companyDetails;
    }

    /**
     * @param companyDetails the companyDetails to set
     */
    public void setCompanyDetails(CompanyDetailsDTO companyDetails) {
        this.companyDetails = companyDetails;
    }

    /**
     * @return the companyDetailsList
     */
    public List<CompanyDetailsDTO> getCompanyDetailsList() {
        return companyDetailsList;
    }

    /**
     * @param companyDetailsList the companyDetailsList to set
     */
    public void setCompanyDetailsList(List<CompanyDetailsDTO> companyDetailsList) {
        this.companyDetailsList = companyDetailsList;
    }

    public void saveCompanyDetails() {
        try {
            companyDetailsDAO.insertCompanyDetails(companyDetails, pageNavBean.getLoggedInUserDTO().getUserId());
            displayInfoMessageToUser("Company details added successfully");
            companyDetailsList = companyDetailsDAO.getCompanyDetailsList(pageNavBean.getLoggedInUserDTO().getUserId());
            resetCompanyDetails();
            pageNavBean.redirectPageToSearchCompany();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCompanyDetails() {
        try {
            companyDetailsDAO.updateCompanyDetails(companyDetails, pageNavBean.getLoggedInUserDTO().getUserId());
            displayInfoMessageToUser("Company details updated successfully");
            companyDetailsList = companyDetailsDAO.getCompanyDetailsList(pageNavBean.getLoggedInUserDTO().getUserId());
            resetCompanyDetails();
            pageNavBean.redirectPageToSearchCompany();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCompanyDetails(CompanyDetailsDTO companyDetails) {
        try {
            this.companyDetails = companyDetails;
            companyDetailsDAO.deleteCompanyDetails(companyDetails);
            displayInfoMessageToUser("Company details deleted successfully");
            companyDetailsList = companyDetailsDAO.getCompanyDetailsList(pageNavBean.getLoggedInUserDTO().getUserId());
            resetCompanyDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetCompanyDetails() {
        companyDetails = new CompanyDetailsDTO();
    }

    public PageNavigationBean getPageNavBean() {
		return pageNavBean;
	}

	public void setPageNavBean(PageNavigationBean pageNavBean) {
		this.pageNavBean = pageNavBean;
	}

	public void accountNoValidator(FacesContext context, UIComponent component, Object value) {
        UIInput accountNoComponent = (UIInput) component.getAttributes().get("bankAcctNO");

        //Retrieve the String value from the component
        String accountNo = (String) accountNoComponent.getValue();

        //Convert the value parameter to a String.
        String confirmAccountNo = (String) value;
        if (!accountNo.toLowerCase().equals(confirmAccountNo.toLowerCase())) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Account No does not match", null));
        }

    }
}
