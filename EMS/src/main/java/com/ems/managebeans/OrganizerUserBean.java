/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ems.datamodel.dao.UserTypeDAO;
import com.ems.datamodel.dao.UsersDAO;
import com.ems.datamodel.dto.OrganizerUserDTO;
import com.ems.datamodel.dto.ResetPasswordDTO;
import com.ems.datamodel.dto.SignUpDTO;
import com.ems.datamodel.dto.UserTypeDTO;
import com.ems.util.CommonUtil;

@ManagedBean(name = "organizerUserBean")
@ViewScoped
public class OrganizerUserBean extends AbstractMB {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3839715729656889361L;
	private OrganizerUserDTO organizerUserDTO;
    private List<UserTypeDTO> userTypeDTOList;
    private SignUpDTO resetPasswordDTO;
    private OrganizerUserDTO selectedOrganizerUserDTO;
    private List<OrganizerUserDTO> userList ;
     
    @ManagedProperty(value="#{pageNavBean}")
  	private PageNavigationBean pageNavBean ;

	private UsersDAO userDAO = null;

    public OrganizerUserBean() {
        organizerUserDTO = new OrganizerUserDTO();
    }

    @PostConstruct
    public void init() 
    {
        UserTypeDAO userType = new UserTypeDAO();
        userDAO = new UsersDAO();
        userTypeDTOList = userType.getUserTypeList();
        userList = new ArrayList<>();
        selectedOrganizerUserDTO = new OrganizerUserDTO();
        resetPasswordDTO  = new SignUpDTO();
        getDataFromRequestMap();
        searchOrganizerUser();
    }

    private void getDataFromRequestMap()
    {
    	String pageName=FacesContext.getCurrentInstance().getViewRoot().getViewId();  
		if(pageName!=null)
		{
			if(pageName.equalsIgnoreCase("/AddOrganizerUser.xhtml"))
			{
		    	Object obj= getObjectFromFlash("organizerUserDTO");
		    	if(obj!=null)
		    		this.organizerUserDTO = (OrganizerUserDTO) obj;
			}
			else if(pageName.equalsIgnoreCase("/ResetPassword.xhtml"))
			{
				Object obj= getObjectFromFlash("resetPasswordUserDto");
		    	if(obj!=null)
		    		this.resetPasswordDTO = (SignUpDTO) obj;
		    	else
		    		resetPasswordDTO.setEmailAddress(pageNavBean.getLoggedInUserDTO().getEmailAddress());
			}
		}
    }

 
    public OrganizerUserDTO getOrganizerUserDTO() {
        return organizerUserDTO;
    }

 
    public void setOrganizerUserDTO(OrganizerUserDTO organizerUserDTO) {
        this.organizerUserDTO = organizerUserDTO;
    }
 
    public List<UserTypeDTO> getUserTypeDTOList() {
        return userTypeDTOList;
    }
 
    public void setUserTypeDTOList(List<UserTypeDTO> userTypeDTOList) {
        this.userTypeDTOList = userTypeDTOList;
    }

    
	public OrganizerUserDTO getSelectedOrganizerUserDTO() {
		return selectedOrganizerUserDTO;
	}

	public void setSelectedOrganizerUserDTO(OrganizerUserDTO selectedOrganizerUserDTO) {
		this.selectedOrganizerUserDTO = selectedOrganizerUserDTO;
	}

	public List<OrganizerUserDTO> getUserList() {
		return userList;
	}

	public void setUserList(List<OrganizerUserDTO> userList) {
		this.userList = userList;
	}
	
	public SignUpDTO getResetPasswordDTO() {
		return resetPasswordDTO;
	}

	public void setResetPasswordDTO(SignUpDTO resetPasswordDTO) {
		this.resetPasswordDTO = resetPasswordDTO;
	}

	public PageNavigationBean getPageNavBean() {
		return pageNavBean;
	}

	public void setPageNavBean(PageNavigationBean pageNavBean) {
		this.pageNavBean = pageNavBean;
	}


	/***************** SEARCH PAGE *******************/
    
    public void searchOrganizerUser() {
        try {
            userList = userDAO.searchOrganizerUser(selectedOrganizerUserDTO.getFirstName(), selectedOrganizerUserDTO.getLastName(), 
            		selectedOrganizerUserDTO.getUserTypeId(), pageNavBean.getLoggedInUserDTO().getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetOrganizerUser() {
        organizerUserDTO = new OrganizerUserDTO();     
        setUserList(null);
        selectedOrganizerUserDTO = new OrganizerUserDTO();     
    }
    
    public void deleteOrganizerUser(OrganizerUserDTO organizerUserDTO) {
        try {
            this.organizerUserDTO = organizerUserDTO;
            userDAO.deleteOrganizerUser(organizerUserDTO);
            displayInfoMessageToUser("User deleted successfully");
            organizerUserDTO = new OrganizerUserDTO();
            userList = userDAO.searchOrganizerUser(selectedOrganizerUserDTO.getFirstName(), selectedOrganizerUserDTO.getLastName(), 
            		selectedOrganizerUserDTO.getUserTypeId(), pageNavBean.getLoggedInUserDTO().getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    /***************** ADD PAGE *************************/
    
    public void saveOrganizerUser() {
        try {
            if (userDAO.isEmailIdRegister(organizerUserDTO.getEmailAddress())!=null) {
                displayErrorMessageToUser("User already registered");
                organizerUserDTO = new OrganizerUserDTO();
                return;
            }
            organizerUserDTO.setSuperUserId(pageNavBean.getLoggedInUserDTO().getUserId());
            organizerUserDTO.setPassword(CommonUtil.generateRandomPassword());
            int result = userDAO.insertUser(organizerUserDTO);
            if (result > 0) {
                displayInfoMessageToUser("User added successfully");
            }
            organizerUserDTO = new OrganizerUserDTO();
            pageNavBean.redirectPageToSearchUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String updateOrganizerUser()
    {
        try {
            int result = userDAO.updateOrganizerUser(organizerUserDTO);
            if (result > 0) {
                displayInfoMessageToUser("User Details updated successfully");
            }
            organizerUserDTO = new OrganizerUserDTO();
            pageNavBean.redirectPageToSearchUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OrganizerUserList.xhtml";
    }
    
    /********************* RESET PASSWORD************************/
    
   /* public void resetPassword()
    {
        try {
             if (pageNavBean.getLoggedInUserDTO() != null)
             {                
                SignUpDTO signUpDTO = new SignUpDTO();
                signUpDTO = pageNavBean.getLoggedInUserDTO() ;
                signUpDTO.setPassword(getResetPasswordDTO().getPassword());
                new UsersDAO().updateUserPassword(signUpDTO);
                displayInfoMessageToUser("Password Reset Successfully");
                resetPasswordDTO = new SignUpDTO();
             }  
        } catch (Exception e) {
            e.printStackTrace();
        }
     }*/
    
    public void resetPassword()
    {
        try {
             if (resetPasswordDTO != null)
             {                
                new UsersDAO().updateUserPassword(resetPasswordDTO);
                displayInfoMessageToUser("Password Reset Successfully");
                resetPasswordDTO = new SignUpDTO();
             }  
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
}