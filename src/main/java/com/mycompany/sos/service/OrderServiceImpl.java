/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.sos.model.Order;
import com.mycompany.sos.repository.OrderRepository;
import com.mycompany.sos.repository.entities.OrderEntity;
import com.mycompany.sos.service.transformers.DomainEntityTransformer;

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
	private OrderRepository orderDao;
	
	@Autowired
	@Qualifier("orderTransformer")
	private DomainEntityTransformer<Order, OrderEntity> orderTransformer;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addOrder(Order order) {
		OrderEntity orderEntity = orderTransformer.getEntityFromDto(order);
		return orderDao.addOrder(orderEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<Order>();
		orderDao.getOrders()
				.stream()
				.forEach(orderEntity -> orders.add(orderTransformer.getDtoFromEntity(orderEntity)));
		return orders;
	}

}
