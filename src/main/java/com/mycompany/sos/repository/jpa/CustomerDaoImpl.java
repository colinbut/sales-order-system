/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository.jpa;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.sos.repository.CustomerDao;
import com.mycompany.sos.repository.entities.CustomerEntity;

/**
 * CustomerDaoImpl class
 * 
 * @author colin
 *
 */
@Repository("customerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {

	private EntityManager entityManager;
	
	Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);
	
	@PostConstruct
	public void init(){
		logger.info("Setting up EntityManager");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
				"com.mycompany.sos.entitymanager");
		
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@PreDestroy
	public void destroy() {
		logger.info("Cleaning up resources");
		if(entityManager.isOpen()) {
			if(logger.isDebugEnabled()) {
				logger.debug("EntityManager is open - closing it");
			}
			entityManager.close();
		}
	}
	
	@Override
	public boolean addCustomer(CustomerEntity customerEntity) {
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
		}
		catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean editCustomer(CustomerEntity customer) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

	@Override
	public boolean deleteCustomer(CustomerEntity customer) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

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

	@Override
	public CustomerEntity findCustomerByCustomerName(String customerName) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

}
