/**
 * 
 */
package com.mycompany.sos.dao;

import org.springframework.stereotype.Repository;

import com.mycompany.sos.model.entities.Order;

/**
 * @author colin
 *
 */
@Repository("orderDaoImpl")
public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean addOrder(Order order) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

}
