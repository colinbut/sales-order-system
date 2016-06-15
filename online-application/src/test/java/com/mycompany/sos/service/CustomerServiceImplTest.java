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
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * {@link CustomerServiceImplTest} test class
 *
 * @author colin
 */
@RunWith(MockitoJUnitRunner.class)
@Category(UnitTestCategory.class)
public class CustomerServiceImplTest {

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		Mockito.when(customerRepository.save(Matchers.any(Customer.class))).thenReturn(new Customer());
		assertThat(customerService.addCustomer(customer)).isNotNull();
	}

	@Test
	public void testGetCustomers() {
        Customer testCustomer = new Customer();
        testCustomer.setFirstName("Johny");
        testCustomer.setLastName("Rainbow");

		List<Customer> customerList = Arrays.asList(testCustomer);
		Mockito.when(customerRepository.findAll()).thenReturn(customerList);

		List<Customer> customers = customerService.getCustomers();

		assertThat(customers).isNotEmpty();
		assertThat(customers).extracting(Customer::getFirstName).contains("Johny");
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

        assertThat(customer.getFirstName()).isEqualTo("John");
        assertThat(customer.getLastName()).isEqualTo("Doe");
	}
}
