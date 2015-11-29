/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.model.Order;
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
		Mockito.when(orderRepository.addOrder(Matchers.any(Order.class))).thenReturn(true);
		Order order = new Order();
		assertTrue(orderService.addOrder(order));
	}
	
	
}
