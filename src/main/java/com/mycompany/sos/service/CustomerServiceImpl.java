/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.sos.model.CustomerEntity;
import com.mycompany.sos.repository.CustomerRepository;


/**
 * {@link CustomerServiceImpl} class
 * 
 * implementation of the {@link CustomerService} interface
 * 
 * @author colin
 *
 */
@Service("customerServiceImpl")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepository customerRepository;
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerEntity addCustomer(CustomerEntity customerEntity) {		
		logger.info("Adding new customer to system: " + customerEntity);
		return customerRepository.addCustomer(customerEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CustomerEntity> getCustomers() {
		logger.info("Retrieving customers list");
		return customerRepository.getCustomers();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerEntity findCustomerByCustomerName(String customerName) {
		CustomerEntity customerEntity = customerRepository.findCustomerByCustomerName(customerName);
		if(customerEntity != null) {
			return customerEntity;
		}
		throw new RuntimeException("Unknown Customer with name: " + customerName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerEntity findCustomerByCustomerId(int customerId) {
		CustomerEntity customerEntity = customerRepository.findCustomerByCustomerId(customerId);
		
		if(customerEntity != null) {
			return customerEntity;
		}
		throw new RuntimeException("Unknown Customer with id: " + customerId);
		
	}

}
