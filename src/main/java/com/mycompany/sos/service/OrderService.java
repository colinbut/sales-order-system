/**
 * 
 */
package com.mycompany.sos.service;

import com.mycompany.sos.dao.entities.Order;

/**
 * OrderService interface
 * 
 * @author colin
 *
 */
public interface OrderService {

	boolean addOrder(Order order);
}
