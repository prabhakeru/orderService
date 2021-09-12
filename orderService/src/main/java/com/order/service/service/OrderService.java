package com.order.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.model.Order;
import com.order.service.repository.OrderRepository;

@Service
public class OrderService implements OrderServiceImpl{
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> getOrderById(String orderId) {
		List<Order> orders = orderRepository.findById(orderId);
		orders.stream().forEach(o->{		
			switch(o.getOffer().getOfferType().name()) {
			case "BUYONE_GETONE":{
				Double d = o.getPrice()/2;
				o.setPrice(d);
			}
			case "BUYTWO_GETONE":{
				Double d = o.getPrice()*2;
				o.setPrice(d);							
					}			
			}
		});
		return orders;
	}

	public List<Order> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
		return orders;
	}

}
