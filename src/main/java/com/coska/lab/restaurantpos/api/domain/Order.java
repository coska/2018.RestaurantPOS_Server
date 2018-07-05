package com.coska.lab.restaurantpos.api.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue//(generator = "uuid")
	private String orderId;	
	
	// @NotBlank  => NotBlank annotation is for string attribute and not for int/bool. 
	private Boolean status;
	
	//userId column will be created 
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "userId")
	@JsonManagedReference
	private Employee orderBy;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "tableId")
	@JsonManagedReference
	private ServTables table;
	
	//@OneToMany(fetch=FetchType.EAGER)
	//@JoinColumn(name = "orderId")
	@OneToMany(mappedBy="order")
	private List<OrderItem> orderItem;

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Employee getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Employee orderBy) {
		this.orderBy = orderBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public ServTables getTable() {
		return table;
	}

	public void setTable(ServTables table) {
		this.table = table;
	}
	
	
}
