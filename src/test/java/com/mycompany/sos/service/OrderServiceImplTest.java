/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mycompany.sos.UnitTestCategory;
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
@Category(UnitTestCategory.class)
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
		Mockito.when(orderDao.addOrder(Matchers.any(OrderEntity.class))).thenReturn(true);
		Order order = new Order();
		assertTrue(orderService.addOrder(order));
	}
	
	
}
