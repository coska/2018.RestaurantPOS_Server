package com.coska.lab.restaurantpos.api.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderItemId implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7359098467399629665L;

	@Column(name = "orderId")
	private String orderId;

	@Column(name = "orderItemId")
	private int orderItemId;

	public OrderItemId() {
    }

	public OrderItemId(String orderId, int orderItemId) {
        this.orderId = orderId;
        this.orderItemId = orderItemId;
    }


	public String getOrderId() {
		return orderId;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof OrderItemId))
			return false;
		OrderItemId that = (OrderItemId) o;
		return Objects.equals(getOrderId(), that.getOrderId())
				&& Objects.equals(getOrderItemId(), that.getOrderItemId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getOrderId(), getOrderItemId());
	}
}
