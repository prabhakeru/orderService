package com.order.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.model.Order;
import com.order.service.service.OrderService;

@RestController
public class ProductController {

	@Autowired
	OrderService service;
	
	@GetMapping("/order/getByOrderId/{orderId}")
	public List<Order> getOrderById(@RequestBody String orderId) {
			List<Order> result = service.getOrderById(orderId);
			return result;
	}
	
	@GetMapping("/order/getAllOrders")
	public List<Order> getAllOrders() {
			List<Order> result = service.getAllOrders();
			return result;
	}
}
