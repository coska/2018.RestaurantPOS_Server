package com.coska.lab.restaurantpos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coska.lab.restaurantpos.api.domain.Order;
import com.coska.lab.restaurantpos.api.repositories.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		//return orderRepository.findAll();
		return orderRepository.findByStatus(true);
	}
	
	/**
	 * Description : Change the status of order.
	 * @param id : Order ID
	 * @param status
	 * 			true : Finished.
	 * 			false : Cooking.
	 * @return Changed order
	 */
	@PutMapping("/order/{id}/{status}")
	public Order updateOrderStatus(@PathVariable String id, @PathVariable boolean status){
		Order order = orderRepository.findByOrderId(id);
		order.setStatus(status);
		orderRepository.save(order);
		return order;
	}

	/**
	 * Description : Update information of Order
	 * @param order
	 */
	@PutMapping("/order/update/")
	public void updateOrder(Order order){
		orderRepository.save(order);
	}
}
