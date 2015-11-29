/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import com.mycompany.sos.model.Order;

import java.util.List;

/**
 * {@link OrderRepository} interface
 * 
 * @author colin
 */
public interface OrderRepository {

	/**
	 * Adds a new order 
	 * 
	 * @param order the new order to add
	 * @return true if successfully added false otherwise
	 */
	boolean addOrder(Order order);
	
	/**
	 * Gets a list of orders
	 * 
	 * @return list of orders
	 */
	List<Order> getOrders();
	
}
