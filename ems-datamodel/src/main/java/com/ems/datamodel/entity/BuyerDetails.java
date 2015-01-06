/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rupesht
 */
@Entity
@Table(name = "buyer_details")
@NamedQueries({
    @NamedQuery(name = "BuyerDetails.findAll", query = "SELECT b FROM BuyerDetails b"),
    @NamedQuery(name = "BuyerDetails.findByBuyerId", query = "SELECT b FROM BuyerDetails b WHERE b.buyerId = :buyerId"),
    @NamedQuery(name = "BuyerDetails.findByFirstName", query = "SELECT b FROM BuyerDetails b WHERE b.firstName = :firstName"),
    @NamedQuery(name = "BuyerDetails.findByLastName", query = "SELECT b FROM BuyerDetails b WHERE b.lastName = :lastName"),
    @NamedQuery(name = "BuyerDetails.findByAddress1", query = "SELECT b FROM BuyerDetails b WHERE b.address1 = :address1"),
    @NamedQuery(name = "BuyerDetails.findByAddress2", query = "SELECT b FROM BuyerDetails b WHERE b.address2 = :address2"),
    @NamedQuery(name = "BuyerDetails.findByAddress3", query = "SELECT b FROM BuyerDetails b WHERE b.address3 = :address3"),
    @NamedQuery(name = "BuyerDetails.findByCity", query = "SELECT b FROM BuyerDetails b WHERE b.city = :city"),
    @NamedQuery(name = "BuyerDetails.findByState", query = "SELECT b FROM BuyerDetails b WHERE b.state = :state"),
    @NamedQuery(name = "BuyerDetails.findByZip", query = "SELECT b FROM BuyerDetails b WHERE b.zip = :zip"),
    @NamedQuery(name = "BuyerDetails.findByCountry", query = "SELECT b FROM BuyerDetails b WHERE b.country = :country"),
    @NamedQuery(name = "BuyerDetails.findByEmail", query = "SELECT b FROM BuyerDetails b WHERE b.email = :email"),
    @NamedQuery(name = "BuyerDetails.findByPhoneNo", query = "SELECT b FROM BuyerDetails b WHERE b.phoneNo = :phoneNo"),
    @NamedQuery(name = "BuyerDetails.findByCreatedOn", query = "SELECT b FROM BuyerDetails b WHERE b.createdOn = :createdOn"),
    @NamedQuery(name = "BuyerDetails.findByCreatedBy", query = "SELECT b FROM BuyerDetails b WHERE b.createdBy = :createdBy"),
    @NamedQuery(name = "BuyerDetails.findByModifiedOn", query = "SELECT b FROM BuyerDetails b WHERE b.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "BuyerDetails.findByModifiedBy", query = "SELECT b FROM BuyerDetails b WHERE b.modifiedBy = :modifiedBy")})
public class BuyerDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "buyer_id")
    private Integer buyerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "address3")
    private String address3;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip")
    private String zip;
    @Column(name = "country")
    private String country;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name = "created_on")
    private String createdOn;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "modified_on")
    private String modifiedOn;
    @Column(name = "modified_by")
    private Integer modifiedBy;

    public BuyerDetails() {
    }

    public BuyerDetails(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buyerId != null ? buyerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuyerDetails)) {
            return false;
        }
        BuyerDetails other = (BuyerDetails) object;
        if ((this.buyerId == null && other.buyerId != null) || (this.buyerId != null && !this.buyerId.equals(other.buyerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.BuyerDetails[ buyerId=" + buyerId + " ]";
    }
    
}
