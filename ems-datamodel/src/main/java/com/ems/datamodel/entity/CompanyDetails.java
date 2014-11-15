/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ems.datamodel.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rupesh
 */
@Entity
@Table(name = "company_details")
@NamedQueries({
    @NamedQuery(name = "CompanyDetails.findAll", query = "SELECT c FROM CompanyDetails c"),
    @NamedQuery(name = "CompanyDetails.findByCompanyId", query = "SELECT c FROM CompanyDetails c WHERE c.companyId = :companyId"),
    @NamedQuery(name = "CompanyDetails.findByCompanyName", query = "SELECT c FROM CompanyDetails c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "CompanyDetails.findByAddress1", query = "SELECT c FROM CompanyDetails c WHERE c.address1 = :address1"),
    @NamedQuery(name = "CompanyDetails.findByAddress2", query = "SELECT c FROM CompanyDetails c WHERE c.address2 = :address2"),
    @NamedQuery(name = "CompanyDetails.findByPhone1", query = "SELECT c FROM CompanyDetails c WHERE c.phone1 = :phone1"),
    @NamedQuery(name = "CompanyDetails.findByPhone2", query = "SELECT c FROM CompanyDetails c WHERE c.phone2 = :phone2"),
    @NamedQuery(name = "CompanyDetails.findByBankAcctNo", query = "SELECT c FROM CompanyDetails c WHERE c.bankAcctNo = :bankAcctNo"),
    @NamedQuery(name = "CompanyDetails.findByIFSCcode", query = "SELECT c FROM CompanyDetails c WHERE c.iFSCcode = :iFSCcode"),
    @NamedQuery(name = "CompanyDetails.findByBankName", query = "SELECT c FROM CompanyDetails c WHERE c.bankName = :bankName"),
    @NamedQuery(name = "CompanyDetails.findByBranchName", query = "SELECT c FROM CompanyDetails c WHERE c.branchName = :branchName"),
    @NamedQuery(name = "CompanyDetails.findByAddedOn", query = "SELECT c FROM CompanyDetails c WHERE c.addedOn = :addedOn"),
    @NamedQuery(name = "CompanyDetails.findByAddedBy", query = "SELECT c FROM CompanyDetails c WHERE c.addedBy = :addedBy")})
public class CompanyDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "company_id")
    private Integer companyId;    
    @Column(name = "company_name")
    private String companyName;    
    @Column(name = "address_1")
    private String address1;
    @Column(name = "address_2")
    private String address2;
    @Column(name = "phone1")
    private String phone1;
    @Column(name = "phone2")
    private String phone2;
    @Column(name = "bank_acct_no")
    private String bankAcctNo;
    @Column(name = "IFSC_code")
    private String iFSCcode;    
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "added_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedOn;
    @Column(name = "added_by")
    private Integer addedBy;

    public CompanyDetails() {
    }

    public CompanyDetails(Integer companyId) {
        this.companyId = companyId;
    }

    public CompanyDetails(Integer companyId, String companyName, String address1, String bankName) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.address1 = address1;
        this.bankName = bankName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getBankAcctNo() {
        return bankAcctNo;
    }

    public void setBankAcctNo(String bankAcctNo) {
        this.bankAcctNo = bankAcctNo;
    }

    public String getIFSCcode() {
        return iFSCcode;
    }

    public void setIFSCcode(String iFSCcode) {
        this.iFSCcode = iFSCcode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public Integer getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Integer addedBy) {
        this.addedBy = addedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyDetails)) {
            return false;
        }
        CompanyDetails other = (CompanyDetails) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.CompanyDetails[ companyId=" + companyId + " ]";
    }
    
}
