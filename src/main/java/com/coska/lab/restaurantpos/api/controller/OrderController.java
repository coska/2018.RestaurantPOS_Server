package com.coska.lab.restaurantpos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
