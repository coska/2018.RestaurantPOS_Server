package com.coska.lab.restaurantpos.api.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coska.lab.restaurantpos.api.domain.Order;
import com.coska.lab.restaurantpos.api.domain.OrderItem;
import com.coska.lab.restaurantpos.api.repositories.OrderItemRepository;
import com.coska.lab.restaurantpos.api.repositories.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		//need to confirm - "paid" status
		return orderRepository.findAll();
		//return orderRepository.findByStatus(OrderTypes.SERVED);
	}
	
	@GetMapping("/orders/{orderId}")
	public Order getOrderById(@PathVariable String orderId) {
		Order order = null;
		order = orderRepository.findByOrderId(orderId);
		return order;
	}
	
	@PostMapping(value="/orders")
	public Order createOrder(@Valid @RequestBody Order order) {
		List<OrderItem> orderItems = order.getOrderItems();
		orderRepository.save(order);
		if(orderItems == null || orderItems.size()==0)
			throw new RuntimeException("No Order items");
		/*
		 * require more validation check
		 * ex) is product exist?
		 */
		for(int i= 0; i < orderItems.size(); i++) {
			OrderItem orderItem =orderItems.get(i);
			orderItem.setOrder(order);
			orderItemRepository.save(orderItem);
		}
		
		return order;
	}
}
