/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import com.ems.datamodel.dao.UserTypeDAO;
import com.ems.datamodel.dao.UsersDAO;
import com.ems.datamodel.dto.LoginDTO;
import com.ems.datamodel.dto.OrganizerUserDTO;
import com.ems.datamodel.dto.ResetPasswordDTO;
import com.ems.datamodel.dto.SignUpDTO;
import com.ems.datamodel.dto.UserTypeDTO;
import com.ems.datamodel.entity.Users;
import com.ems.util.CommonUtil;
import com.ems.util.EmailUtility;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends AbstractMB {

    private static final String STAY_IN_THE_SAME_PAGE = null;
    private static final String EVENT_LIST_PAGE = "EventList.xhtml?faces-redirect=true";
    private LoginDTO loginDTO;
    private String recoverEmail;
    private SignUpDTO signUpDTO;
    private ResetPasswordDTO resetPasswordDTO;
    private int loginUserId;

    public LoginBean() {
    }

    @PostConstruct
    public void init() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        loginDTO = new LoginDTO();
        signUpDTO = new SignUpDTO();
    }

    public String checkLoginStatus() {
        try {
            boolean status = false;
            if (loginDTO != null) {
                UsersDAO user = new UsersDAO();
                Users users = null;
                users = user.findUser(loginDTO.getEmailAddress(), loginDTO.getPassword());
                if (users != null) {
                    if (users.getStatusId() == 0) {
                        displayErrorMessageToUser("Please do the confirmation");
                        return "login.xhtml";
                    }
                    displayInfoMessageToUser("Login successfully");
                    setLoginUserId((int) users.getUserId());
                } else {
                    displayErrorMessageToUser("Invalid user name password");
                    return "login.xhtml";
                }

                //return "Dashboard.xhtml?faces-redirect=true";
            } else {
                displayErrorMessageToUser("Invalid Login. The Username and password you entered is incorrect.");
                return "login.xhtml";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return EVENT_LIST_PAGE;
    }

    public void saveOrganizer() {
        try {
            UsersDAO user = new UsersDAO();
            if (user.isEmailIdRegister(signUpDTO.getEmailAddress()) != null) {
                displayErrorMessageToUser("User already register");
                signUpDTO = new SignUpDTO();
                return;
            }
            signUpDTO.setUserType(1);
            int result = user.insertUser(signUpDTO);
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

    public void sendForgotPassword() {
        try {
            UsersDAO user = new UsersDAO();
            Users users = user.isEmailIdRegister(recoverEmail);
            if (users != null) {                
                EmailUtility emailUtility = new EmailUtility();
                signUpDTO = new SignUpDTO();
                signUpDTO.setUserId(users.getUserId());
                signUpDTO.setEmailAddress(users.getEmail());
                signUpDTO.setFirstName(users.getFirstName());
                signUpDTO.setLastName(users.getLastName());
                signUpDTO.setLastName(users.getLastName());
                signUpDTO.setPassword(CommonUtil.generateRandomPassword());
                user.updateUserPassword(signUpDTO);
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

    public void resetPassword() {
        resetPasswordDTO = new ResetPasswordDTO();
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

    public String logout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");            
        } catch (Exception ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/login.xhtml?faces-redirect=true";
    }

    public void getOrganiserUserList() {
        try {
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
     * @return the resetPasswordDTO
     */
    public ResetPasswordDTO getResetPasswordDTO() {
        return resetPasswordDTO;
    }

    /**
     * @param resetPasswordDTO the resetPasswordDTO to set
     */
    public void setResetPasswordDTO(ResetPasswordDTO resetPasswordDTO) {
        this.resetPasswordDTO = resetPasswordDTO;
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

    public void openSignUpDialog() {
        RequestContext.getCurrentInstance().reset(":SignupForm");
    }
}
