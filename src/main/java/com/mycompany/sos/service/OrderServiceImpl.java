/**
 * 
 */
package com.mycompany.sos.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.sos.dao.OrderDao;
import com.mycompany.sos.dao.entities.OrderEntity;

/**
 * @author colin
 *
 */
@Service("orderServiceImpl")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public boolean addOrder(OrderEntity order) {
		return orderDao.addOrder(order);
	}

}
