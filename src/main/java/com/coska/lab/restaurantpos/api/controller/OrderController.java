package com.coska.lab.restaurantpos.api.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coska.lab.restaurantpos.api.domain.ApiResponse;
import com.coska.lab.restaurantpos.api.domain.Order;
import com.coska.lab.restaurantpos.api.domain.OrderItem;
import com.coska.lab.restaurantpos.api.domain.ServTables;
import com.coska.lab.restaurantpos.api.model.OrderStatus;
import com.coska.lab.restaurantpos.api.repositories.OrderItemRepository;
import com.coska.lab.restaurantpos.api.repositories.OrderRepository;
import com.coska.lab.restaurantpos.api.repositories.TableRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private TableRepository tableRepository;
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		//need to confirm - "paid" status
//		return orderRepository.findAll();
//		return orderRepository.findByStatus(OrderStatus.NEW.getName());
		return orderRepository.findByOrderStatus(OrderStatus.NEW);
//		return orderRepository.findAll(OrderSpecification.statusNotServed());
	}
	
	@GetMapping("/orders/{orderId}")
	public Order getOrderById(@PathVariable String orderId) {
		Order order = null;
		order = orderRepository.findByOrderId(orderId);
		return order;
	}
	
	@PostMapping(value="/orders")
	public ApiResponse createOrder(@Valid @RequestBody Order order) {

		ApiResponse resp = new ApiResponse();
		
		List<OrderItem> orderItems = order.getOrderItems();
		StringBuilder warning = new StringBuilder();
		
		if(orderItems == null || orderItems.size()==0)
		{
			resp.addError("OrderError",  "Order Item is Empty");
		}
			//throw new RuntimeException("No Order items");
		
		ServTables tmpTable = order.getTable();
		if(tmpTable == null || tmpTable.getTableId() == null)
		{
			resp.addError("TableError",  "Table not exist");
		}
		
		ServTables table = tableRepository.findByTableId(tmpTable.getTableId());
		
		// check take out table
		if(table.getIsTakeOut().equals(Boolean.FALSE)) {
			
//			if(table.getOccupied().equals(Boolean.TRUE))
//				return order.getTable().getName() + " table already ocuupied";
			
			//not sure how to handle when bad data is coming
			if(order.getTable().getOccupied().equals(Boolean.FALSE))
				resp.addError("TableError",  "Table is occupied already.");
			
			table.setOccupied(order.getTable().getOccupied());
			tableRepository.save(table);
		}
		

		if (resp.hasError() )
			return resp;
		
		orderRepository.save(order);
		for(int i= 0; i < orderItems.size(); i++) {
			OrderItem orderItem =orderItems.get(i);
			//if(orderItem.getProduct() == null)
				
			if(orderItem.getQuantity() == null || orderItem.getQuantity() <= Integer.valueOf(0)) {
				warning.append("order item quantity error ");
				warning.append(orderItem.getProduct().getName() + " product fail to add");
			}else {
				orderItem.setOrder(order);
				orderItemRepository.save(orderItem);
			}
		}
		
		resp.setData("{orderId:\"" + order.getOrderId() + "\"}");
		return resp;
	}
	
}
