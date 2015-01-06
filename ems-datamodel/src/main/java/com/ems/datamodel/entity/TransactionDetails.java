/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "transaction_details")
@NamedQueries({
    @NamedQuery(name = "TransactionDetails.findAll", query = "SELECT t FROM TransactionDetails t"),
    @NamedQuery(name = "TransactionDetails.findByTransactionId", query = "SELECT t FROM TransactionDetails t WHERE t.transactionId = :transactionId"),
    @NamedQuery(name = "TransactionDetails.findByOrderId", query = "SELECT t FROM TransactionDetails t WHERE t.orderId = :orderId"),
    @NamedQuery(name = "TransactionDetails.findByTransactionType", query = "SELECT t FROM TransactionDetails t WHERE t.transactionType = :transactionType"),
    @NamedQuery(name = "TransactionDetails.findByTransactionAmount", query = "SELECT t FROM TransactionDetails t WHERE t.transactionAmount = :transactionAmount"),
    @NamedQuery(name = "TransactionDetails.findByTransactionStatus", query = "SELECT t FROM TransactionDetails t WHERE t.transactionStatus = :transactionStatus"),
    @NamedQuery(name = "TransactionDetails.findByCreatedOn", query = "SELECT t FROM TransactionDetails t WHERE t.createdOn = :createdOn"),
    @NamedQuery(name = "TransactionDetails.findByCreatedBy", query = "SELECT t FROM TransactionDetails t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TransactionDetails.findByModifiedOn", query = "SELECT t FROM TransactionDetails t WHERE t.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "TransactionDetails.findByModifiedBy", query = "SELECT t FROM TransactionDetails t WHERE t.modifiedBy = :modifiedBy")})
public class TransactionDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "transaction_id")
    private Integer transactionId;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "transaction_type")
    private Integer transactionType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;
    @Column(name = "transaction_status")
    private Integer transactionStatus;
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

    public TransactionDetails() {
    }

    public TransactionDetails(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Integer transactionStatus) {
        this.transactionStatus = transactionStatus;
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
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionDetails)) {
            return false;
        }
        TransactionDetails other = (TransactionDetails) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.TransactionDetails[ transactionId=" + transactionId + " ]";
    }
    
}
