/**
 * 
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.dao.entities.OrderEntity;
import com.mycompany.sos.model.Order;

/**
 * OrderService interface
 * 
 * @author colin
 *
 */
public interface OrderService {

	boolean addOrder(OrderEntity order);
	
	List<Order> getOrders();
}
