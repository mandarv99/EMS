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

    private CompanyDetailsDTO companyDetails;
    private List<CompanyDetailsDTO> companyDetailsList;
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    CompanyDetailsDAO companyDetailsDAO = null;

    public CompanyDetailsBean() {
    }

    @PostConstruct
    public void init() {
        companyDetails = new CompanyDetailsDTO();
        companyDetailsDAO = new CompanyDetailsDAO();
        companyDetailsList = companyDetailsDAO.getCompanyDetailsList(loginBean.getLoginUserId());
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
            companyDetailsDAO.insertCompanyDetails(companyDetails, getLoginBean().getLoginUserId());
            displayInfoMessageToUser("Company details added successfully");
            companyDetailsList = companyDetailsDAO.getCompanyDetailsList(loginBean.getLoginUserId());
            resetCompanyDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCompanyDetails() {
        try {
            companyDetailsDAO.updateCompanyDetails(companyDetails, getLoginBean().getLoginUserId());
            displayInfoMessageToUser("Company details updated successfully");
            companyDetailsList = companyDetailsDAO.getCompanyDetailsList(loginBean.getLoginUserId());
            resetCompanyDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCompanyDetails(CompanyDetailsDTO companyDetails) {
        try {
            this.companyDetails = companyDetails;
            companyDetailsDAO.deleteCompanyDetails(companyDetails);
            displayInfoMessageToUser("Company details deleted successfully");
            companyDetailsList = companyDetailsDAO.getCompanyDetailsList(loginBean.getLoginUserId());
            resetCompanyDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetCompanyDetails() {
        companyDetails = new CompanyDetailsDTO();
    }

    /**
     * @return the loginBean
     */
    public LoginBean getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean the loginBean to set
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public void accountNoValidator(FacesContext context, UIComponent component, Object value) {
        UIInput accountNoComponent = (UIInput) component.getAttributes().get("bankAcctNO");

        //Retrieve the String value from the component
        String accountNo = (String) accountNoComponent.getValue();

        //Convert the value parameter to a String.
        String confirmAccountNo = (String) value;
        if (!accountNo.equals(confirmAccountNo)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Account no does not match", null));
        }

    }
}
