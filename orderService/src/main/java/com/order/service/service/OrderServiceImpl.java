package com.order.service.service;

import java.util.List;

import com.order.service.model.Order;

public interface OrderServiceImpl {
	
	List<Order> getOrderById(String orderId);
	List<Order> getAllOrders();
}
