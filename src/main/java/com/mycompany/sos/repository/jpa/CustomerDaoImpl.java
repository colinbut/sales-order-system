/*
 * |-------------------------------------------------
] * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.sos.repository.CustomerDao;
import com.mycompany.sos.repository.entities.CustomerEntity;

/**
 * {@link CustomerDaoImpl} class
 * 
 * implementation of {@link CustomerDao} interface
 * 
 * @author colin
 *
 */
@Repository("customerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
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
			
			entityManager.getTransaction().begin();
			
			logger.info("Saving data to database");
			entityManager.persist(customerEntity);
			logger.info("Persisted data to database");
			
			entityManager.getTransaction().commit();
			
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
