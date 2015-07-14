/**
 * 
 */
package com.mycompany.sos.dao;

import com.mycompany.sos.model.entities.Order;

/**
 * OrderDao interface
 * 
 * @author colin
 *
 */
public interface OrderDao {

	boolean addOrder(Order order);
	
}
