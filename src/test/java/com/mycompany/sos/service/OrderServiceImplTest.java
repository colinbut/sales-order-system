/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mycompany.sos.model.Order;
import com.mycompany.sos.repository.OrderDao;
import com.mycompany.sos.repository.entities.OrderEntity;
import com.mycompany.sos.service.transformers.DomainEntityTransformer;

/**
 * {@link OrderServiceImplTest} test class
 * 
 * @author colin
 *
 */
public class OrderServiceImplTest {
	
	@Mock
	private OrderDao orderDao;
	
	@Mock
	private DomainEntityTransformer<Order, OrderEntity> orderTransformer;
	
	@InjectMocks
	private OrderService orderService = new OrderServiceImpl();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddOrder() {
		Order order = new Order();
		assertTrue(orderService.addOrder(order));
	}
	
	
}
