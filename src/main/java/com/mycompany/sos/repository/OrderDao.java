/**
 * 
 */
package com.mycompany.sos.repository;

import com.mycompany.sos.repository.entities.OrderEntity;

/**
 * OrderDao interface
 * 
 * @author colin
 *
 */
public interface OrderDao {

	boolean addOrder(OrderEntity order);
	
}
