/**
 * 
 */
package com.mycompany.sos.dao;

import org.springframework.stereotype.Repository;

import com.mycompany.sos.dao.entities.OrderEntity;

/**
 * @author colin
 *
 */
@Repository("orderDaoImpl")
public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean addOrder(OrderEntity order) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

}
