/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.sos.model.Customer;
import com.mycompany.sos.repository.CustomerDao;
import com.mycompany.sos.repository.entities.CustomerEntity;
import com.mycompany.sos.service.transformers.DomainEntityTransformer;


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
	private CustomerDao customerDao;
	
	@Autowired
	@Qualifier("customerTransformer")
	private DomainEntityTransformer<Customer, CustomerEntity> customerTransformer;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addCustomer(Customer customer) {		
		logger.info("Adding new customer to system: " + customer);
		
		CustomerEntity customerEntity = customerTransformer.getEntityFromDto(customer);
		if(logger.isDebugEnabled()) {
			logger.debug("Got " + customerEntity.toString());
		}
		
		return customerDao.addCustomer(customerEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Customer> getCustomers() {
		
		logger.info("Retrieving customers list");
		
		List<CustomerEntity> customerEntityList = customerDao.getCustomers();
		
		logger.info("Obtained customer list from system");
		
		List<Customer> customers = new ArrayList<Customer>();
		
		customerEntityList.stream().forEach(entity -> {
			customers.add(customerTransformer.getDtoFromEntity(entity));
			
			if(logger.isTraceEnabled()) {
				logger.trace("Transforming entity object: " + entity + " to DTO");
			}
		});
				
		return customers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomerByCustomerName(String customerName) {
		CustomerEntity customerEntity = customerDao.findCustomerByCustomerName(customerName);
		return customerTransformer.getDtoFromEntity(customerEntity);
	}

}
