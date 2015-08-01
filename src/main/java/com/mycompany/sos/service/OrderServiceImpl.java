/**
 * 
 */
package com.mycompany.sos.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.sos.model.Order;
import com.mycompany.sos.repository.OrderDao;
import com.mycompany.sos.repository.entities.OrderEntity;

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

	@Override
	public List<Order> getOrders() {
		
		List<Order> orders = new ArrayList<Order>();
		
		return orders;
	}

}
