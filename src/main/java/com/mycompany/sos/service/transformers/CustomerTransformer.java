/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.transformers;

import java.util.Set;

import com.mycompany.sos.model.Customer;
import com.mycompany.sos.repository.entities.CustomerEntity;

/**
 * CustomerTransformer interface
 * 
 * @author colin
 *
 */
public interface CustomerTransformer {

	Customer getDtoFromEntity(CustomerEntity customerEntity);
	
	CustomerEntity getEntityFromDto(Customer customer);
	
	Set<Customer> getDtoListFromEntityList(Set<CustomerEntity> customerEntities);
	
	Set<CustomerEntity> getEntityListFromDtoList(Set<Customer> customers);
}
