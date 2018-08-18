package com.coska.lab.restaurantpos.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coska.lab.restaurantpos.api.domain.Order;
import com.coska.lab.restaurantpos.api.model.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, String>{
	Order findByOrderId(String OrderId);
	List<Order> findByOrderStatus(OrderStatus status);
}
