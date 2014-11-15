/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import com.ems.datamodel.dao.UserTypeDAO;
import com.ems.datamodel.dao.UsersDAO;
import com.ems.datamodel.dto.OrganizerUserDTO;
import com.ems.datamodel.dto.UserTypeDTO;
import com.ems.util.CommonUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "organizerUserBean")
@ViewScoped
public class OrganizerUserBean extends AbstractMB {

    private OrganizerUserDTO organizerUserDTO;
    private List<UserTypeDTO> userTypeDTOList;
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    private UsersDAO userDAO = null;

    public OrganizerUserBean() {
        organizerUserDTO = new OrganizerUserDTO();
    }

    @PostConstruct
    public void init() {
        UserTypeDAO userType = new UserTypeDAO();
        userDAO = new UsersDAO();
        userTypeDTOList = userType.getUserTypeList();
        Integer userId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("userId");
        if (userId != null && userId != 0) {
            organizerUserDTO = userDAO.findUser(userId);           
            System.out.println("User type idd"+organizerUserDTO.getUserTypeId());
        }
    }

    /**
     * @return the organizerUserDTO
     */
    public OrganizerUserDTO getOrganizerUserDTO() {
        return organizerUserDTO;
    }

    /**
     * @param organizerUserDTO the organizerUserDTO to set
     */
    public void setOrganizerUserDTO(OrganizerUserDTO organizerUserDTO) {
        this.organizerUserDTO = organizerUserDTO;
    }

    /**
     * @return the userTypeDTOList
     */
    public List<UserTypeDTO> getUserTypeDTOList() {
        return userTypeDTOList;
    }

    /**
     * @param userTypeDTOList the userTypeDTOList to set
     */
    public void setUserTypeDTOList(List<UserTypeDTO> userTypeDTOList) {
        this.userTypeDTOList = userTypeDTOList;
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

    public void saveOrganizerUser() {
        try {
            if (userDAO.isEmailIdRegister(organizerUserDTO.getEmailAddress())!=null) {
                displayErrorMessageToUser("User already register");
                organizerUserDTO = new OrganizerUserDTO();
                return;
            }
            organizerUserDTO.setSuperUserId(loginBean.getLoginUserId());
            organizerUserDTO.setPassword(CommonUtil.generateRandomPassword());
            int result = userDAO.insertUser(organizerUserDTO);
            if (result > 0) {
                displayInfoMessageToUser("User added successfully");
            }
            organizerUserDTO = new OrganizerUserDTO();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void resetOrganizerUser() {
        organizerUserDTO = new OrganizerUserDTO();
    }

    public String updateOrganizerUser() {
        try {
            int result = userDAO.updateOrganizerUser(organizerUserDTO);
            if (result > 0) {
                displayInfoMessageToUser("User update successfully");
            }
            organizerUserDTO = new OrganizerUserDTO();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OrganizerUserList.xhtml";

    }

}
