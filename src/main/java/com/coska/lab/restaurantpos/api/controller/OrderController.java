package com.coska.lab.restaurantpos.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coska.lab.core.notification.NotificationService;
import com.coska.lab.expo.domain.MessageType;
import com.coska.lab.expo.domain.PushMessage;
import com.coska.lab.restaurantpos.api.domain.ApiResponse;
import com.coska.lab.restaurantpos.api.domain.Order;
import com.coska.lab.restaurantpos.api.domain.OrderItem;
import com.coska.lab.restaurantpos.api.domain.OrderItemId;
import com.coska.lab.restaurantpos.api.domain.ServTables;
import com.coska.lab.restaurantpos.api.domain.UserToken;
import com.coska.lab.restaurantpos.api.model.OrderStatus;
import com.coska.lab.restaurantpos.api.repositories.OrderItemRepository;
import com.coska.lab.restaurantpos.api.repositories.OrderRepository;
import com.coska.lab.restaurantpos.api.repositories.TableRepository;
import com.coska.lab.restaurantpos.api.repositories.TokenRepository;

@RestController
public class OrderController {

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private TableRepository tableRepository;

	@Autowired
	NotificationService expo;

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		// need to confirm - "paid" status
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

	@PutMapping(value = "/orders/{orderId}")
	public ApiResponse updateOrder(
			@PathVariable String orderId, 
			@RequestParam("action") OrderStatus orderStatus) {
		ApiResponse resp = new ApiResponse();
		
		Order order = null;
		order = orderRepository.findByOrderId(orderId);
		if (order != null) {
			switch  (orderStatus) {
			 case READY :  
				UserToken token = tokenRepository.getOne(order.getOrderedBy().getUserId());
				
				if (token == null)
					resp.addError("TokenNotFound", "TokenNotFound");

				if (resp.hasError())
					return resp;
				
				PushMessage pm = new PushMessage(MessageType.READY_ORDER);
				pm.setTo(token.getToken());
				pm.setTitle("Your Order for table " + order.getTable().getName() + " is ready.");
				pm.setBody("Good");

				resp = expo.sendNotice(pm);
				 break;
			
			 default:
					 break;
			}
		} else {
			resp.addError("Error", "Invalid Order Id");
		}

		return resp;
	}

	@PostMapping(value = "/orders")
	public ApiResponse createOrder(@Valid @RequestBody Order order) {

		ApiResponse resp = new ApiResponse();

		List<OrderItem> orderItems = order.getOrderItems();
		StringBuilder warning = new StringBuilder();

		if (orderItems == null || orderItems.size() == 0) {
			resp.addError("OrderError", "Order Item is Empty");
		}
		// throw new RuntimeException("No Order items");

		ServTables tmpTable = order.getTable();
		if (tmpTable == null || tmpTable.getTableId() == null) {
			resp.addError("TableError", "Table not exist");
		}

		ServTables table = tableRepository.findByTableId(tmpTable.getTableId());

		// check take out table
		if (table.getIsTakeOut().equals(Boolean.FALSE)) {

//			if(table.getOccupied().equals(Boolean.TRUE))
//				return order.getTable().getName() + " table already ocuupied";

			// not sure how to handle when bad data is coming
			if (order.getTable().getOccupied().equals(Boolean.FALSE))
				resp.addError("TableError", "Table is occupied already.");

			table.setOccupied(order.getTable().getOccupied());
			tableRepository.save(table);
		}

		if (resp.hasError())
			return resp;

		orderRepository.save(order);
		
			for (int i = 0; i < orderItems.size(); i++) {
				OrderItem orderItem = orderItems.get(i);
				// if(orderItem.getProduct() == null)
	
				if (orderItem.getQuantity() == null || orderItem.getQuantity() <= Integer.valueOf(0)) {
					resp.addError("Item:" + i, "order item quantity error ");
				} else {
					try {
//						orderItem.setOrder(order);
						orderItem.setOrderItemId(new OrderItemId(order.getOrderId(), i));
						
						orderItemRepository.save(orderItem);
					} catch (Exception e) {
						resp.addError("Item:" + i, e.getMessage());
					}
				
				}
			}
		

		resp.setData("{orderId:\"" + order.getOrderId() + "\"}");
		return resp;
	}

}
