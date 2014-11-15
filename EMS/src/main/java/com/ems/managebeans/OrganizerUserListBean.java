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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "organizerUserListBean")
@ViewScoped
public class OrganizerUserListBean extends AbstractMB {

    private OrganizerUserDTO organizerUserDTO;
    private OrganizerUserDTO selectedOrganizerUserDTO;
    private List<OrganizerUserDTO> userList = null;
    private List<UserTypeDTO> userTypeDTOList;
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    private UsersDAO userDAO = null;

    public OrganizerUserListBean() {
        organizerUserDTO = new OrganizerUserDTO();
    }

    @PostConstruct
    public void init() {
        UserTypeDAO userType = new UserTypeDAO();
        userDAO = new UsersDAO();
        userTypeDTOList = userType.getUserTypeList();
        userList = new ArrayList<>();
        selectedOrganizerUserDTO = new OrganizerUserDTO();
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
     * @return the userList
     */
    public List<OrganizerUserDTO> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<OrganizerUserDTO> userList) {
        this.userList = userList;
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

    
    public void searchOrganizerUser() {
        try {
            userList = userDAO.searchOrganizerUser(selectedOrganizerUserDTO.getFirstName(), selectedOrganizerUserDTO.getLastName(), selectedOrganizerUserDTO.getUserTypeId(), loginBean.getLoginUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetOrganizerUser() {
        organizerUserDTO = new OrganizerUserDTO();     
    }
    public void deleteOrganizerUser(OrganizerUserDTO organizerUserDTO) {
        try {
            this.organizerUserDTO = organizerUserDTO;
            UsersDAO user = new UsersDAO();
            user.deleteOrganizerUser(organizerUserDTO);
            displayInfoMessageToUser("User deleted successfully");
            organizerUserDTO = new OrganizerUserDTO();
            userList = userDAO.searchOrganizerUser(selectedOrganizerUserDTO.getFirstName(), selectedOrganizerUserDTO.getLastName(), selectedOrganizerUserDTO.getUserTypeId(), loginBean.getLoginUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return the selectedOrganizerUserDTO
     */
    public OrganizerUserDTO getSelectedOrganizerUserDTO() {
        return selectedOrganizerUserDTO;
    }

    /**
     * @param selectedOrganizerUserDTO the selectedOrganizerUserDTO to set
     */
    public void setSelectedOrganizerUserDTO(OrganizerUserDTO selectedOrganizerUserDTO) {
        this.selectedOrganizerUserDTO = selectedOrganizerUserDTO;
    }

    public String addOrganizerUser() {
        organizerUserDTO = new OrganizerUserDTO();
        return "AddOrganizerUser.xhtml";
    }

    public String editOrganizerUser(OrganizerUserDTO organizerUserDTO) {                
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("userId", organizerUserDTO.getUserId());
        return "AddOrganizerUser.xhtml";
    }
}
