/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rupesht
 */
@Entity
@Table(name = "participant_details")
@NamedQueries({
    @NamedQuery(name = "ParticipantDetails.findAll", query = "SELECT p FROM ParticipantDetails p"),
    @NamedQuery(name = "ParticipantDetails.findByParticipantDetailsId", query = "SELECT p FROM ParticipantDetails p WHERE p.participantDetailsId = :participantDetailsId"),
    @NamedQuery(name = "ParticipantDetails.findByOrderId", query = "SELECT p FROM ParticipantDetails p WHERE p.orderId = :orderId"),
    @NamedQuery(name = "ParticipantDetails.findByFirstName", query = "SELECT p FROM ParticipantDetails p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "ParticipantDetails.findByLastName", query = "SELECT p FROM ParticipantDetails p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "ParticipantDetails.findByGender", query = "SELECT p FROM ParticipantDetails p WHERE p.gender = :gender"),
    @NamedQuery(name = "ParticipantDetails.findByDob", query = "SELECT p FROM ParticipantDetails p WHERE p.dob = :dob"),
    @NamedQuery(name = "ParticipantDetails.findByAddr1", query = "SELECT p FROM ParticipantDetails p WHERE p.addr1 = :addr1"),
    @NamedQuery(name = "ParticipantDetails.findByAddr2", query = "SELECT p FROM ParticipantDetails p WHERE p.addr2 = :addr2"),
    @NamedQuery(name = "ParticipantDetails.findByAddr3", query = "SELECT p FROM ParticipantDetails p WHERE p.addr3 = :addr3"),
    @NamedQuery(name = "ParticipantDetails.findByCity", query = "SELECT p FROM ParticipantDetails p WHERE p.city = :city"),
    @NamedQuery(name = "ParticipantDetails.findByState", query = "SELECT p FROM ParticipantDetails p WHERE p.state = :state"),
    @NamedQuery(name = "ParticipantDetails.findByCountry", query = "SELECT p FROM ParticipantDetails p WHERE p.country = :country"),
    @NamedQuery(name = "ParticipantDetails.findByMobileNo", query = "SELECT p FROM ParticipantDetails p WHERE p.mobileNo = :mobileNo"),
    @NamedQuery(name = "ParticipantDetails.findByEmail", query = "SELECT p FROM ParticipantDetails p WHERE p.email = :email"),
    @NamedQuery(name = "ParticipantDetails.findByParticipantStatus", query = "SELECT p FROM ParticipantDetails p WHERE p.participantStatus = :participantStatus"),
    @NamedQuery(name = "ParticipantDetails.findByCreatedOn", query = "SELECT p FROM ParticipantDetails p WHERE p.createdOn = :createdOn"),
    @NamedQuery(name = "ParticipantDetails.findByCreatedBy", query = "SELECT p FROM ParticipantDetails p WHERE p.createdBy = :createdBy"),
    @NamedQuery(name = "ParticipantDetails.findByModifiedOn", query = "SELECT p FROM ParticipantDetails p WHERE p.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "ParticipantDetails.findByModifiedBy", query = "SELECT p FROM ParticipantDetails p WHERE p.modifiedBy = :modifiedBy")})
public class ParticipantDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "participant_details_id")
    private Integer participantDetailsId;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    private String dob;
    @Column(name = "addr_1")
    private String addr1;
    @Column(name = "addr_2")
    private String addr2;
    @Column(name = "addr_3")
    private String addr3;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "email")
    private String email;
    @Column(name = "participant_status")
    private Integer participantStatus;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @Column(name = "modified_by")
    private Integer modifiedBy;

    public ParticipantDetails() {
    }

    public ParticipantDetails(Integer participantDetailsId) {
        this.participantDetailsId = participantDetailsId;
    }

    public Integer getParticipantDetailsId() {
        return participantDetailsId;
    }

    public void setParticipantDetailsId(Integer participantDetailsId) {
        this.participantDetailsId = participantDetailsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getParticipantStatus() {
        return participantStatus;
    }

    public void setParticipantStatus(Integer participantStatus) {
        this.participantStatus = participantStatus;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
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
        hash += (participantDetailsId != null ? participantDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipantDetails)) {
            return false;
        }
        ParticipantDetails other = (ParticipantDetails) object;
        if ((this.participantDetailsId == null && other.participantDetailsId != null) || (this.participantDetailsId != null && !this.participantDetailsId.equals(other.participantDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.ParticipantDetails[ participantDetailsId=" + participantDetailsId + " ]";
    }
    
}
