/**
 * 
 */
package com.mycompany.sos.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.sos.dao.entities.CustomerEntity;

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
	public boolean addCustomer(CustomerEntity customer) {
		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.persist(customer);
			
			entityManager.getTransaction().commit();
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
		
		List<CustomerEntity> customers = entityManager.createQuery("from CustomerEntity", CustomerEntity.class).getResultList();
		
		return customers;
		
	}

}
