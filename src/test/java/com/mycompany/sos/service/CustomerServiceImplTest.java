/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.repository.CustomerRepository;
import com.mycompany.sos.repository.entities.CustomerEntity;

/**
 * {@link CustomerServiceImplTest} test class
 * 
 * @author colin
 *
 */
@RunWith(MockitoJUnitRunner.class)
@Category(UnitTestCategory.class)
public class CustomerServiceImplTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddCustomer() {
		CustomerEntity customer = new CustomerEntity();
		Mockito.when(customerRepository.addCustomer(Matchers.any(CustomerEntity.class))).thenReturn(new CustomerEntity());
		assertNotNull(customerService.addCustomer(customer));
	}
	
	@Test
	public void testGetCustomers() {
		List<CustomerEntity> customerEntityList = Arrays.asList(new CustomerEntity());
		Mockito.when(customerRepository.getCustomers()).thenReturn(customerEntityList);
		
		List<CustomerEntity> customers = customerService.getCustomers();
		
		assertFalse(customers.isEmpty());
		assertTrue(customers.size() > 0);
		customers.stream().forEach(customer -> {
			assertTrue(customer instanceof CustomerEntity);
		});
	}
	
	@Test
	public void testFindCustomerByCustomerName() {
		CustomerEntity expectedCustomer = new CustomerEntity();
		expectedCustomer.setFirstName("John");
		expectedCustomer.setLastName("Doe");
		String customerName = expectedCustomer.getFirstName() + " " + expectedCustomer.getLastName();
		Mockito.when(customerRepository.findCustomerByCustomerName(customerName)).thenReturn(new CustomerEntity());
		
		CustomerEntity customer = customerService.findCustomerByCustomerName(customerName);
		
		assertNotNull(customer);
		assertSame(expectedCustomer, customer);
		assertEquals(expectedCustomer.getFirstName(), customer.getFirstName());
		assertEquals(expectedCustomer.getLastName(), customer.getLastName());
	}
}
