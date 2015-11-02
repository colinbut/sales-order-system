/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.model.OrderEntity;
import com.mycompany.sos.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.*;

import static org.junit.Assert.*;

/**
 * {@link OrderServiceImplTest} test class
 * 
 * @author colin
 *
 */
@Category(UnitTestCategory.class)
public class OrderServiceImplTest {
	
	@Mock
	private OrderRepository orderRepository;
	
	@InjectMocks
	private OrderService orderService = new OrderServiceImpl();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddOrder() {
		Mockito.when(orderRepository.addOrder(Matchers.any(OrderEntity.class))).thenReturn(true);
		OrderEntity order = new OrderEntity();
		assertTrue(orderService.addOrder(order));
	}
	
	
}
