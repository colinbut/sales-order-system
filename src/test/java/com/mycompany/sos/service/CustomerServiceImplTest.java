/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

import static org.junit.Assert.*;

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
		Customer customer = new Customer();
		Mockito.when(customerRepository.save(Matchers.any(Customer.class))).thenReturn(new Customer());
		assertNotNull(customerService.addCustomer(customer));
	}
	
	@Test
	public void testGetCustomers() {
		List<Customer> customerList = Arrays.asList(new Customer());
		Mockito.when(customerRepository.findAll()).thenReturn(customerList);
		
		List<Customer> customers = customerService.getCustomers();
		
		assertFalse(customers.isEmpty());
		assertTrue(customers.size() > 0);
		customers.stream().forEach(customer -> {
			assertTrue(customer instanceof Customer);
		});
	}
	
	@Test
	public void testFindCustomerByCustomerName() {
		Customer expectedCustomer = new Customer();
		expectedCustomer.setFirstName("John");
		expectedCustomer.setLastName("Doe");
		String customerName = expectedCustomer.getFirstName() + " " + expectedCustomer.getLastName();
		Mockito.when(customerRepository.findByFirstNameAndLastName(Matchers.anyString(), Matchers.anyString()))
				.thenReturn(expectedCustomer);
		
		Customer customer = customerService.findCustomerByCustomerName(customerName);
		
		assertNotNull(customer);
		assertSame(expectedCustomer, customer);
		assertEquals(expectedCustomer.getFirstName(), customer.getFirstName());
		assertEquals(expectedCustomer.getLastName(), customer.getLastName());
	}
}
