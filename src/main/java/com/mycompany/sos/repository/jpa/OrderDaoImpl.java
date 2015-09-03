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

import com.mycompany.sos.repository.OrderDao;
import com.mycompany.sos.repository.entities.OrderEntity;

/**
 * {@link OrderDaoImpl} class
 * 
 * implementation of {@link OrderDao} interface
 * 
 * @author colin
 *
 */
@Repository("orderDaoImpl")
public class OrderDaoImpl implements OrderDao {

	private EntityManager entityManager;
	
	Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);
	
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addOrder(OrderEntity orderEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(orderEntity);
		entityManager.getTransaction().commit();
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OrderEntity> getOrders() {
		List<OrderEntity> orderEntities = entityManager.createQuery("from OrderEntity", OrderEntity.class).getResultList();
		return orderEntities;
	}

}
