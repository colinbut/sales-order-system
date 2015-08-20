/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository.jpa;

import java.util.List;

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addOrder(OrderEntity order) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OrderEntity> getOrders() {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

}
