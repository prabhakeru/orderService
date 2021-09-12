package com.order.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.order.service.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

	public List<Order> findById(String orderId);
	public List<Order> findAll();
}
