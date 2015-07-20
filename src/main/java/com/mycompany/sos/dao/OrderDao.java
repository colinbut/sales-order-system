/**
 * 
 */
package com.mycompany.sos.dao;

import com.mycompany.sos.dao.entities.OrderEntity;

/**
 * OrderDao interface
 * 
 * @author colin
 *
 */
public interface OrderDao {

	boolean addOrder(OrderEntity order);
	
}
