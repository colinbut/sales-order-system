/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import com.mycompany.sos.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * {@link OrderRepositoryImpl} class
 * 
 * implementation of {@link OrderRepository} interface
 * 
 * @author colin
 *
 */
@Repository("orderRepositoryImpl")
public class OrderRepositoryImpl implements OrderRepository {

	private static final Logger logger = LoggerFactory.getLogger(OrderRepositoryImpl.class);
	
	@PersistenceContext(unitName = "com.mycompany.sos.entitymanager")
	private EntityManager entityManager;
	
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addOrder(Order order) {
		entityManager.persist(order);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getOrders() {
		List<Order> orderEntities = entityManager.createQuery("from Order", Order.class).getResultList();
		return orderEntities;
	}

}
