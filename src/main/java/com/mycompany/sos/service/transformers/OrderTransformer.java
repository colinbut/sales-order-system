/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.transformers;

import java.util.List;
import java.util.Set;

import com.mycompany.sos.model.Order;
import com.mycompany.sos.repository.entities.OrderEntity;

/**
 * {@link OrderTransformer} interface
 * 
 * @author colin
 *
 */
public interface OrderTransformer {

	
	Order getDtoFromEntity(OrderEntity orderEntity);
	
	
	OrderEntity getEntityFromDto(Order order);
	
	
	List<Order> getDtoListFromEntityList(Set<OrderEntity> orderEntityList);
	
	
	Set<OrderEntity> getEntityListFromDto(List<Order> orders);
}
