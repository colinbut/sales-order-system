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
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.*;

/**
 * {@link OrderServiceImplTest} test class
 *
 * @author colin
 */
@Category(UnitTestCategory.class)
public class OrderServiceImplTest {

	@Mock
	private OrderRepository orderRepository;

	@InjectMocks
	private OrderService orderService = new OrderServiceImpl();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddOrder() {
		Order order = new Order();
		Mockito.when(orderRepository.save(Matchers.any(Order.class))).thenReturn(order);
		assertThat(orderService.addOrder(order)).isTrue();
	}


}
