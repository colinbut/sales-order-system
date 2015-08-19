/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository.jpa;

import org.springframework.stereotype.Repository;

import com.mycompany.sos.repository.OrderDao;
import com.mycompany.sos.repository.entities.OrderEntity;

/**
 * @author colin
 *
 */
@Repository("orderDaoImpl")
public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean addOrder(OrderEntity order) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

}
