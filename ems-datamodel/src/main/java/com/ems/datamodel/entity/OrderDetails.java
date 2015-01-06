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
@Table(name = "order_details")
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o"),
    @NamedQuery(name = "OrderDetails.findByOrderId", query = "SELECT o FROM OrderDetails o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "OrderDetails.findByBuyerId", query = "SELECT o FROM OrderDetails o WHERE o.buyerId = :buyerId"),
    @NamedQuery(name = "OrderDetails.findByOrderAmount", query = "SELECT o FROM OrderDetails o WHERE o.orderAmount = :orderAmount"),
    @NamedQuery(name = "OrderDetails.findByDiscountAmount", query = "SELECT o FROM OrderDetails o WHERE o.discountAmount = :discountAmount"),
    @NamedQuery(name = "OrderDetails.findByCreatedOn", query = "SELECT o FROM OrderDetails o WHERE o.createdOn = :createdOn"),
    @NamedQuery(name = "OrderDetails.findByCreatedBy", query = "SELECT o FROM OrderDetails o WHERE o.createdBy = :createdBy"),
    @NamedQuery(name = "OrderDetails.findByModifiedOn", query = "SELECT o FROM OrderDetails o WHERE o.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "OrderDetails.findByModifiedBy", query = "SELECT o FROM OrderDetails o WHERE o.modifiedBy = :modifiedBy")})
public class OrderDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "buyer_id")
    private Integer buyerId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "order_amount")
    private BigDecimal orderAmount;
    @Column(name = "discount_amount")
    private BigDecimal discountAmount;
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

    public OrderDetails() {
    }

    public OrderDetails(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
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
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ems.datamodel.entity.OrderDetails[ orderId=" + orderId + " ]";
    }
    
}
