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
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.repository.CustomerRepository;
import com.mycompany.sos.repository.entities.CustomerEntity;
import com.mycompany.sos.service.transformers.DomainEntityTransformer;

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
	private DomainEntityTransformer<Customer, CustomerEntity> customerTransformer;
	
	@Mock
	private CustomerRepository customerDao;
	
	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		Mockito.when(customerTransformer.getEntityFromDto(Matchers.any(Customer.class))).thenReturn(new CustomerEntity());
		Mockito.when(customerDao.addCustomer(Matchers.any(CustomerEntity.class))).thenReturn(new CustomerEntity());
		assertNotNull(customerService.addCustomer(customer));
	}
	
	@Test
	public void testGetCustomers() {
		List<CustomerEntity> customerEntityList = Arrays.asList(new CustomerEntity());
		Mockito.when(customerDao.getCustomers()).thenReturn(customerEntityList);
		Mockito.when(customerTransformer.getDtoFromEntity(Matchers.any(CustomerEntity.class))).thenReturn(new Customer());
		
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
		Mockito.when(customerDao.findCustomerByCustomerName(customerName)).thenReturn(new CustomerEntity());
		Mockito.when(customerTransformer.getDtoFromEntity(Matchers.any(CustomerEntity.class))).thenReturn(expectedCustomer);
		
		Customer customer = customerService.findCustomerByCustomerName(customerName);
		
		assertNotNull(customer);
		assertSame(expectedCustomer, customer);
		assertEquals(expectedCustomer.getFirstName(), customer.getFirstName());
		assertEquals(expectedCustomer.getLastName(), customer.getLastName());
	}
}
