/**
 * 
 */
package com.mycompany.sos.dao;

import com.mycompany.sos.dao.entities.Order;

/**
 * OrderDao interface
 * 
 * @author colin
 *
 */
public interface OrderDao {

	boolean addOrder(Order order);
	
}
