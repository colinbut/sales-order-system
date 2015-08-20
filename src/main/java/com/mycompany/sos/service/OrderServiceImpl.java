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
import org.springframework.stereotype.Service;

import com.mycompany.sos.model.Order;
import com.mycompany.sos.repository.OrderDao;
import com.mycompany.sos.repository.entities.OrderEntity;
import com.mycompany.sos.service.transformers.OrderTransformer;

/**
 * @author colin
 *
 */
@Service("orderServiceImpl")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderTransformer orderTransformer;
	
	@Override
	public boolean addOrder(Order order) {
		OrderEntity orderEntity = orderTransformer.getEntityFromDto(order);
		return orderDao.addOrder(orderEntity);
	}

	@Override
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<Order>();
		orderDao.getOrders()
				.stream()
				.forEach(orderEntity -> orders.add(orderTransformer.getDtoFromEntity(orderEntity)));
		return orders;
	}

}
