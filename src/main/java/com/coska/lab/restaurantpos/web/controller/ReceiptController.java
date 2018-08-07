package com.coska.lab.restaurantpos.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.coska.lab.restaurantpos.api.domain.Order;
import com.coska.lab.restaurantpos.api.domain.OrderItem;
import com.coska.lab.restaurantpos.api.repositories.OrderRepository;
import com.coska.lab.restaurantpos.web.view.JasperReportsPdfView;

@Controller
public class ReceiptController {
    @Autowired
    private ApplicationContext appContext;
    
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/receipts/{orderId}")
	public ModelAndView  getOrderById(@PathVariable String orderId) {
		Order order = null;
		order = orderRepository.findByOrderId(orderId);
		
		JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:/reports/receipt.jrxml");
	    view.setApplicationContext(appContext);

	    Map<String, Object> params = new HashMap<>();
	    List<Map<String, Object>> orderItems = new ArrayList<>();
	    for(OrderItem item : order.getOrderItems()) {
	    	Map<String, Object> rec = new HashMap<>();
	    	rec.put("orderid", order.getOrderId());
	    	rec.put("createdat", order.getCreatedDateTime());
	    	rec.put("tableid", order.getTable().getName());
	    	
	    	rec.put("userid", order.getOrderedBy().getUserName());
	    	
	    	rec.put("quantity", item.getQuantity());
	    	rec.put("productname", item.getProduct().getName());
	    	rec.put("price", item.getProduct().getPrice());
	    	
	    	
	    	
	    	orderItems.add(rec);
	    }
	    params.put("datasource", orderItems);

	    return new ModelAndView(view, params);
	}
}
