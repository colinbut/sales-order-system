/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import com.mycompany.sos.model.OrderEntity;

import java.util.List;

/**
 * {@link OrderService} interface
 * 
 * @author colin
 *
 */
public interface OrderService {

	/**
	 * Adds a new order
	 * 
	 * @param order the new order to add
	 * @return true if successfully added false otherwise
	 */
	boolean addOrder(OrderEntity order);
	
	/**
	 * Gets a list of orders
	 * 
	 * @return list of orders
	 */
	List<OrderEntity> getOrders();
}
