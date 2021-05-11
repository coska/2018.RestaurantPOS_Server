package com.coska.lab.restaurantpos.api.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orderitem")
public class OrderItem {

	@EmbeddedId
	private OrderItemId orderItemId;
	
	
	@JoinColumns({
		@JoinColumn(name="orderId", insertable=false, updatable=false)
	})
	 @ManyToOne(fetch = FetchType.EAGER/* ,cascade={CascadeType.ALL} */)
	private Order order;

	
	public void setOrderItemId(OrderItemId orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	private Integer quantity;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "productId")
	private Product product;

}
