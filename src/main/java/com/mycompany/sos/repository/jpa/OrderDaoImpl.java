/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	@PersistenceContext
	private EntityManager entityManager;
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
		
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
