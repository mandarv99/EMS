/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import com.ems.datamodel.dao.CompanyDetailsDAO;
import com.ems.datamodel.dao.TicketDAO;
import com.ems.datamodel.dao.UsersDAO;
import com.ems.datamodel.dto.CompanyDetailsDTO;
import com.ems.datamodel.dto.SignUpDTO;
import com.ems.datamodel.dto.TicketDTO;
import java.io.IOException;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "emailConfirmationBean")
@ViewScoped
public class EmailConfirmationBean extends AbstractMB {
    
    private String emailId;
    private String password;
    private int userId;
    private SignUpDTO signUpDTO;
    
    @PostConstruct
    public void init() throws Exception {
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        emailId = params.get("emailId");
        password = params.get("rnd");
        userId = Integer.parseInt(params.get("ekd").toString());
        UsersDAO usersDAO = new UsersDAO();
        signUpDTO = usersDAO.findUser(emailId, password, userId);
        if (signUpDTO != null) {
            displayInfoMessageToUser("User " + emailId + " confirm successfully ");
        } else {
            displayErrorMessageToUser("Invalid User");
        }
        CompanyDetailsDAO companyDetailsdao = new CompanyDetailsDAO();
        CompanyDetailsDTO companyDetails = new CompanyDetailsDTO();
        companyDetails.setCompanyName("Default");
        companyDetailsdao.insertCompanyDetails(companyDetails, signUpDTO.getUserId());
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);        
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");        
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the signUpDTO
     */
    public SignUpDTO getSignUpDTO() {
        return signUpDTO;
    }

    /**
     * @param signUpDTO the signUpDTO to set
     */
    public void setSignUpDTO(SignUpDTO signUpDTO) {
        this.signUpDTO = signUpDTO;
    }
}
