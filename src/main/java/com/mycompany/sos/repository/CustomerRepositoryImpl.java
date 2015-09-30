/*
 * |-------------------------------------------------
] * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.sos.model.CustomerEntity;

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
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerEntity addCustomer(CustomerEntity customerEntity) {
		try {
			
			logger.info("Adding new customer to database");
			
			if(logger.isDebugEnabled()) {
				logger.debug(customerEntity.toString());
			}
						
			logger.info("Saving data to database");
			entityManager.persist(customerEntity);
			logger.info("Persisted data to database");
						
			if(logger.isDebugEnabled()) {
				logger.debug("Committed database transaction");
			}
			
			return customerEntity;
		}
		catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			//return false;
		}
		
		return null;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean editCustomer(CustomerEntity customer) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteCustomer(CustomerEntity customer) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CustomerEntity> getCustomers() {
		
		logger.info("Retrieving customer list from database");
		
		List<CustomerEntity> customerEntityList = entityManager.createQuery("from CustomerEntity", CustomerEntity.class).getResultList();
		
		if(!customerEntityList.isEmpty()) {
			logger.info("Obtained customers list from database");
		} else {
			logger.warn("Empty customers list obtained from database");
		}
				
		return customerEntityList;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerEntity findCustomerByCustomerName(String customerName) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerEntity findCustomerByCustomerId(int customerId) {
		CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, customerId);
		return customerEntity;
	}

}
