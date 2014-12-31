/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ems.datamodel.dto;

/**
 *
 * @author Rupesh
 */
public class CompanyDetailsDTO  extends AbstractDTO {
    
    private boolean paidEvent;
    private String companyName;
    private int typeOfAccount;
    private String address1;
    private String address2;
    private String address3;
    private int country;
    private int city;
    private String pinCode;
    private String phoneNo;
    private String bankAccountNo;
    private String confirmBankAccountNo;
    private String ifscCode;
    private String bankName;
    private String branchName;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the paidEvent
     */
    public boolean isPaidEvent() {
        return paidEvent;
    }

    /**
     * @param paidEvent the paidEvent to set
     */
    public void setPaidEvent(boolean paidEvent) {
        this.paidEvent = paidEvent;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the typeOfAccount
     */
    public int getTypeOfAccount() {
        return typeOfAccount;
    }

    /**
     * @param typeOfAccount the typeOfAccount to set
     */
    public void setTypeOfAccount(int typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    /**
     * @return the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return the address3
     */
    public String getAddress3() {
        return address3;
    }

    /**
     * @param address3 the address3 to set
     */
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    /**
     * @return the country
     */
    public int getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(int country) {
        this.country = country;
    }

    /**
     * @return the city
     */
    public int getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(int city) {
        this.city = city;
    }

    /**
     * @return the pinCode
     */
    public String getPinCode() {
        return pinCode;
    }

    /**
     * @param pinCode the pinCode to set
     */
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return the bankAccountNo
     */
    public String getBankAccountNo() {
        return bankAccountNo;
    }

    /**
     * @param bankAccountNo the bankAccountNo to set
     */
    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    /**
     * @return the confirmBankAccountNo
     */
    public String getConfirmBankAccountNo() {
        return confirmBankAccountNo;
    }

    /**
     * @param confirmBankAccountNo the confirmBankAccountNo to set
     */
    public void setConfirmBankAccountNo(String confirmBankAccountNo) {
        this.confirmBankAccountNo = confirmBankAccountNo;
    }

    /**
     * @return the ifscCode
     */
    public String getIfscCode() {
        return ifscCode;
    }

    /**
     * @param ifscCode the ifscCode to set
     */
    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return the branchName
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * @param branchName the branchName to set
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    
}
