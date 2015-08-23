/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.transformers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.sos.model.Customer;
import com.mycompany.sos.model.Item;
import com.mycompany.sos.model.Order;
import com.mycompany.sos.repository.entities.CustomerEntity;
import com.mycompany.sos.repository.entities.ItemEntity;
import com.mycompany.sos.repository.entities.OrderEntity;

/**
 * {@link OrderTransformer} class
 * 
 * implementation of {@link OrderTransformer} interface
 * 
 * @author colin
 *
 */
@Component("orderTransformer")
public class OrderTransformer implements DomainEntityTransformer<Order, OrderEntity> {

	@Autowired
	private DomainEntityTransformer<Customer, CustomerEntity> customerTransformer;
	
	@Autowired
	private DomainEntityTransformer<Item, ItemEntity> itemTransformer;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order getDtoFromEntity(OrderEntity orderEntity) {
		Order order = new Order();
		order.setCustomer(customerTransformer.getDtoFromEntity(orderEntity.getCustomer()));
		order.setItems(itemTransformer.getDtoListFromEntityList(orderEntity.getItems()));
		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrderEntity getEntityFromDto(Order order) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomer(customerTransformer.getEntityFromDto(order.getCustomer()));
		orderEntity.setItems(itemTransformer.getEntityListFromDtoList(order.getItems()));
		return orderEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getDtoListFromEntityList(Set<OrderEntity> orderEntityList) {
		List<Order> orders = new ArrayList<>();
		orderEntityList.stream().forEach(orderEntity -> orders.add(getDtoFromEntity(orderEntity)));
		return orders;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<OrderEntity> getEntityListFromDtoList(List<Order> orders) {
		Set<OrderEntity> orderEntities = new HashSet<>();
		orders.stream().forEach(order -> orderEntities.add(getEntityFromDto(order)));
		return orderEntities;
	}

}
