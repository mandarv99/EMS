/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dto;

import java.util.List;

public class OrganizerUserDTO extends AbstractDTO {

    private String emailAddress;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private boolean changeInNextLogin;
    private int userTypeId;
    private int superUserId;
    private int userId;
    private String userTypeName;
    private List<UserTypeDTO> userTypeList;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the changeInNextLogin
     */
    public boolean isChangeInNextLogin() {
        return changeInNextLogin;
    }

    /**
     * @param changeInNextLogin the changeInNextLogin to set
     */
    public void setChangeInNextLogin(boolean changeInNextLogin) {
        this.changeInNextLogin = changeInNextLogin;
    }


    /**
     * @return the userTypeList
     */
    public List<UserTypeDTO> getUserTypeList() {
        return userTypeList;
    }

    /**
     * @param userTypeList the userTypeList to set
     */
    public void setUserTypeList(List<UserTypeDTO> userTypeList) {
        this.userTypeList = userTypeList;
    }

    /**
     * @return the userTypeId
     */
    public int getUserTypeId() {
        return userTypeId;
    }

    /**
     * @param userTypeId the userTypeId to set
     */
    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    /**
     * @return the superUserId
     */
    public int getSuperUserId() {
        return superUserId;
    }

    /**
     * @param superUserId the superUserId to set
     */
    public void setSuperUserId(int superUserId) {
        this.superUserId = superUserId;
    }

    /**
     * @return the userTypeName
     */
    public String getUserTypeName() {
        return userTypeName;
    }

    /**
     * @param userTypeName the userTypeName to set
     */
    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
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

}
