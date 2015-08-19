/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.model.Order;

/**
 * OrderService interface
 * 
 * @author colin
 *
 */
public interface OrderService {

	boolean addOrder(Order order);
	
	List<Order> getOrders();
}
