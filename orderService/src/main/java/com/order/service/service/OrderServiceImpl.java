package com.order.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.exception.NoDataFoundException;
import com.order.service.exception.OrderNotFoundException;
import com.order.service.model.Order;
import com.order.service.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> getOrderById(String orderId) {
		
		List<Order> orders = orderRepository.findById(orderId);	
		if(!orders.isEmpty()) {
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
		}else {
			throw new OrderNotFoundException(Long.valueOf(orderId));
		}
		
	}

	public List<Order> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
		
		if(orders.isEmpty()) {
			throw new NoDataFoundException();
		}
		return orders;
	}

}
