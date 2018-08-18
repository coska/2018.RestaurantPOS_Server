package com.coska.lab.restaurantpos.api.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coska.lab.restaurantpos.api.model.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "orderid", unique = true)
	private String orderId;

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus=OrderStatus.NEW;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private Employee orderedBy;

	@Basic(optional = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	@ManyToOne(fetch = FetchType.EAGER/* ,cascade={CascadeType.ALL} */)
	@JoinColumn(name = "tableId")
	private ServTables table;

	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER/* ,cascade={CascadeType.ALL} */)
	private List<OrderItem> orderItems;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItem(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus.name().toLowerCase();
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Employee getOrderedBy() {
		return orderedBy;
	}

	public void setOrderedBy(Employee orderBy) {
		this.orderedBy = orderBy;
	}

	public Date getCreatedDateTime() {
		return createdAt;
	}

	public void setCreatedDateTime(Date createdAt) {
		this.createdAt = createdAt;
	}

	public ServTables getTable() {
		return table;
	}

	public void setTable(ServTables table) {
		this.table = table;
	}
}
