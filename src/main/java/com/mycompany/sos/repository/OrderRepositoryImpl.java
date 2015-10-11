/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.sos.model.OrderEntity;

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
	public boolean addOrder(OrderEntity orderEntity) {
		entityManager.persist(orderEntity);
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
