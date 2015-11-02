/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import com.mycompany.sos.model.OrderEntity;
import com.mycompany.sos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * {@link OrderServiceImpl} class
 * 
 * implementation of the {@link OrderService} interface 
 * 
 * @author colin
 *
 */
@Service("orderServiceImpl")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addOrder(OrderEntity orderEntity) {
		return orderRepository.addOrder(orderEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OrderEntity> getOrders() {
		return orderRepository.getOrders();
	}

}
