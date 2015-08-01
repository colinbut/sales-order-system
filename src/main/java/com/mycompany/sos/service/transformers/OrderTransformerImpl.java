/**
 * 
 */
package com.mycompany.sos.service.transformers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.sos.model.Order;
import com.mycompany.sos.repository.entities.OrderEntity;

/**
 * @author colin
 *
 */
@Component
public class OrderTransformerImpl implements OrderTransformer {

	@Autowired
	private CustomerTransformer customerTransformer;
	
	@Autowired
	private ItemTransformer itemTransformer;
	
	
	
	@Override
	public Order getDtoFromEntity(OrderEntity orderEntity) {
		
		Order order = new Order();
		order.setCustomer(customerTransformer.getDtoFromEntity(orderEntity.getCustomer()));
		order.setItems(itemTransformer.getDtoListFromEntityList(orderEntity.getItems()));
		
		return order;
	}

	@Override
	public OrderEntity getEntityFromDto(Order order) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomer(customerTransformer.getEntityFromDto(order.getCustomer()));
		orderEntity.setItems(itemTransformer.getEntityListFromDtoList(order.getItems()));
		return orderEntity;
	}

	@Override
	public Set<Order> getDtoListFromEntityList(Set<OrderEntity> orderEntityList) {
		
		Set<Order> orders = new HashSet<Order>();
		for(OrderEntity orderEntity : orderEntityList){
			orders.add(getDtoFromEntity(orderEntity));
		}
		
		return orders;
	}

	@Override
	public Set<OrderEntity> getEntityListFromDto(Set<Order> orders) {
		Set<OrderEntity> orderEntities = new HashSet<>();
		for(Order order : orders){
			orderEntities.add(getEntityFromDto(order));
		}
		return orderEntities;
	}

}
