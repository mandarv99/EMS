/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.primefaces.context.RequestContext;

import com.ems.datamodel.dao.UsersDAO;
import com.ems.datamodel.dto.LoginDTO;
import com.ems.datamodel.dto.SignUpDTO;
import com.ems.datamodel.entity.Users;
import com.ems.util.CommonUtil;
import com.ems.util.EmailUtility;

/**
 * @author snehalr
 *
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends AbstractMB {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5479420716043825631L;
    private LoginDTO loginDTO;
    private String recoverEmail;
    private SignUpDTO signUpDTO;
    private SignUpDTO loggedInUserDTO;

    private int loginUserId;
    
    private UsersDAO userDAOService = new UsersDAO();

	public LoginBean() {
    }

    @PostConstruct
    public void init()
    {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        loginDTO = new LoginDTO();
        signUpDTO = new SignUpDTO();
    }

    // verify login for user
    public String checkLoginStatus()
    {
        try {
            if (loginDTO != null)
            {
                loggedInUserDTO = null;

                loggedInUserDTO = userDAOService.findUserAllData(loginDTO.getEmailAddress(), loginDTO.getPassword());
                if (loggedInUserDTO != null)
                {
                    if (loggedInUserDTO.getStatusId() == 0)
                    {
                        displayErrorMessageToUser("Please confirm your Account");
                        return "login.xhtml";
                    }
                    else
                    {
                    	//displayInfoMessageToUser("Login successfully");
                    	setLoginUserId((int) loggedInUserDTO.getUserId());
                    	redirectToDashBoard();
                    }
                  } 
                else
                {
                	loggedInUserDTO= new SignUpDTO();
                    displayErrorMessageToUser("Invalid User Name or Password");
                    return "login.xhtml";
                }
            }
            else 
            {
                displayErrorMessageToUser("Invalid Login. The Username and password you entered is incorrect.");
                return "login.xhtml";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // to logout user
    public void logout() 
    {
        try
        {
      		FacesContext fc = FacesContext.getCurrentInstance();
       		fc.getExternalContext().getSessionMap().clear();
      		loggedInUserDTO = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

    		Flash flash = fc.getExternalContext().getFlash();
    		flash.setKeepMessages(true);
    		flash.setRedirect(true);
    		displayInfoMessageToUser("You have successfully logged out of your account.");
    		redirectToLogin();	 
    		
         } catch (Exception ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //to redirect page for authenticated User
  	public void redirectToLogin()
  	{
  		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
  		 loggedInUserDTO = new SignUpDTO();
  		 loginDTO = new LoginDTO();
  		 try {
  				String red= "login.xhtml";
   				ec.redirect(red);
  			  } catch (IOException e) { e.printStackTrace();}	  		
  	}

  	 //to redirect page to dashboard
  	public void redirectToDashBoard()
  	{
  		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
   		 try {
  				String red= "EventList.xhtml";
   				ec.redirect(red);
  			  } catch (IOException e) { e.printStackTrace();}	  		
  	}
  	
    public void saveOrganizer()
    {
        try {
             if (userDAOService.isEmailIdRegister(signUpDTO.getEmailAddress()) != null) {
                displayErrorMessageToUser("User already register");
                signUpDTO = new SignUpDTO();
                return;
            }
            signUpDTO.setUserType(1);
            int result = userDAOService.insertUser(signUpDTO);
            if (result > 0) {
                displayInfoMessageToUser("User added successfully please verify user using verify email");
                signUpDTO.setUserId(result);
                EmailUtility emailUtility = new EmailUtility();
                emailUtility.sendConfirmEmail(signUpDTO);
            }
            signUpDTO = new SignUpDTO();
            RequestContext.getCurrentInstance().update("loginForm");
            RequestContext.getCurrentInstance().reset("SignupForm");
        } catch (Exception e) {
            e.printStackTrace();
        }
  }

    public void sendForgotPassword()
    {
        try {
            Users users = userDAOService.isEmailIdRegister(recoverEmail);
            if (users != null) {                
                EmailUtility emailUtility = new EmailUtility();
                signUpDTO = new SignUpDTO();
                signUpDTO.setUserId(users.getUserId());
                signUpDTO.setEmailAddress(users.getEmail());
                signUpDTO.setFirstName(users.getFirstName());
                signUpDTO.setLastName(users.getLastName());
                signUpDTO.setLastName(users.getLastName());
                signUpDTO.setPassword(CommonUtil.generateRandomPassword());
                userDAOService.updateUserPassword(signUpDTO);
                emailUtility.sendUserPassword(signUpDTO);
                displayInfoMessageToUser("The password send on the register email");
                recoverEmail = null;
                return;
            } else {
                displayErrorMessageToUser("User not register with this email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
 

    /**
     * @return the serverDateTime
     */
    public String getServerDateTime() {
        return new SimpleDateFormat("MMM dd yyyy HH:mm:ss a").format(new Date());
    }

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public SignUpDTO getLoggedInUserDTO() {
		return loggedInUserDTO;
	}

	public void setLoggedInUserDTO(SignUpDTO loggedInUserDTO) {
		this.loggedInUserDTO = loggedInUserDTO;
	}

    public void openSignUpDialog() {
        RequestContext.getCurrentInstance().reset(":SignupForm");
    }

    /**
     * @return the recoverEmail
     */
    public String getRecoverEmail() {
        return recoverEmail;
    }

    /**
     * @param recoverEmail the recoverEmail to set
     */
    public void setRecoverEmail(String recoverEmail) {
        this.recoverEmail = recoverEmail;
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
 
    /**
     * @return the loginUserId
     */
    public int getLoginUserId() {
        return loginUserId;
    }

    /**
     * @param loginUserId the loginUserId to set
     */
    public void setLoginUserId(int loginUserId) {
        this.loginUserId = loginUserId;
    }
}