/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import com.mycompany.sos.model.Customer;
import com.mycompany.sos.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * {@link CustomerServiceImpl} class
 *
 * implementation of the {@link CustomerService} interface
 *
 * @author colin
 */
@Service("customerServiceImpl")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		LOGGER.info("Adding new customer to system: " + customer);
		return customerRepository.save(customer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Customer> getCustomers() {
		LOGGER.info("Retrieving customers list");
		return customerRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomerByCustomerName(String customerName) {
		String[] firstNameAndLastName = customerName.split(" ");
		Customer customer = customerRepository.findByFirstNameAndLastName(firstNameAndLastName[0], firstNameAndLastName[1]);
		if(customer != null) {
			return customer;
		}
		throw new RuntimeException("Unknown Customer with name: " + customerName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public Customer findCustomerByCustomerId(int customerId) {
		Customer customer = customerRepository.findOne(customerId);

		if(customer != null) {
			return customer;
		}
		throw new RuntimeException("Unknown Customer with id: " + customerId);

	}

}
