/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import java.util.List;

import com.mycompany.sos.repository.entities.OrderEntity;

/**
 * OrderDao interface
 * 
 * @author colin
 *
 */
public interface OrderDao {

	boolean addOrder(OrderEntity order);
	
	List<OrderEntity> getOrders();
	
}
