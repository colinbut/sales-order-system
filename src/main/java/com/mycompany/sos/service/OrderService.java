/**
 * 
 */
package com.mycompany.sos.service;

import com.mycompany.sos.dao.entities.OrderEntity;

/**
 * OrderService interface
 * 
 * @author colin
 *
 */
public interface OrderService {

	boolean addOrder(OrderEntity order);
}
