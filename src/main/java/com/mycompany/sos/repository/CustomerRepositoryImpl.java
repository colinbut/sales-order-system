/*
 * |-------------------------------------------------
] * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import com.mycompany.sos.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * {@link CustomerRepositoryImpl} class
 * 
 * implementation of {@link CustomerRepository} interface
 * 
 * @author colin
 *
 */
@Repository("customerRepositoryImpl")
public class CustomerRepositoryImpl implements CustomerRepository {

	@PersistenceContext(unitName = "com.mycompany.sos.entitymanager")
	private EntityManager entityManager;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRepositoryImpl.class);
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		try {
			
			LOGGER.info("Adding new customer to database");
			
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug(customer.toString());
			}
						
			LOGGER.info("Saving data to database");
			entityManager.persist(customer);
			LOGGER.info("Persisted data to database");
						
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Committed database transaction");
			}
			
			return customer;
		}
		catch(Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			//return false;
		}
		
		return null;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean editCustomer(Customer customer) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteCustomer(Customer customer) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Customer> getCustomers() {
		
		LOGGER.info("Retrieving customer list from database");
		
		List<Customer> customerList = entityManager.createQuery("from Customer", Customer.class).getResultList();
		
		if(!customerList.isEmpty()) {
			LOGGER.info("Obtained customers list from database");
		} else {
			LOGGER.warn("Empty customers list obtained from database");
		}
				
		return customerList;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomerByCustomerName(String customerName) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomerByCustomerId(int customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		return customer;
	}

}
