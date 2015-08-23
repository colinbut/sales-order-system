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

import com.mycompany.sos.model.Address;
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.model.CustomerPaymentDetails;
import com.mycompany.sos.model.Order;
import com.mycompany.sos.repository.entities.AddressEntity;
import com.mycompany.sos.repository.entities.CustomerEntity;
import com.mycompany.sos.repository.entities.CustomerPaymentDetailEntity;
import com.mycompany.sos.repository.entities.OrderEntity;

/**
 * {@link CustomerTransformerImpl} class
 * 
 * @author colin
 *
 */
@Component
public class CustomerTransformerImpl implements DomainEntityTransformer<Customer, CustomerEntity> {

	@Autowired
	private DomainEntityTransformer<Address, AddressEntity> addressTransformer;
	
	@Autowired
	private DomainEntityTransformer<CustomerPaymentDetails, CustomerPaymentDetailEntity> customerPaymentDetailTransformer;
	
	@Autowired
	private DomainEntityTransformer<Order, OrderEntity> orderTransformer;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer getDtoFromEntity(CustomerEntity customerEntity) {
		Customer customer = new Customer();
		customer.setFirstName(customerEntity.getFirstName());
		customer.setLastName(customerEntity.getLastName());
		customer.setDateOfBirth(customerEntity.getDateOfBirth());
		customer.setEmail(customerEntity.getEmail());
		customer.setAddress(addressTransformer.getDtoFromEntity(customerEntity.getAddress()));
		return customer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerEntity getEntityFromDto(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setFirstName(customer.getFirstName());
		customerEntity.setLastName(customer.getLastName());
		customerEntity.setDateOfBirth(customer.getDateOfBirth());
		customerEntity.setEmail(customer.getEmail());
		
		CustomerPaymentDetailEntity customerPaymentDetailEntity = customerPaymentDetailTransformer.getEntityFromDto(customer.getCustomerPaymentDetails()); 
		customerPaymentDetailEntity.setCustomer(customerEntity);
		customerEntity.setCustomerPaymentDetail(customerPaymentDetailEntity);		
		
		AddressEntity addressEntity = addressTransformer.getEntityFromDto(customer.getAddress());
		addressEntity.getCustomers().add(customerEntity);
		customerEntity.setAddress(addressEntity);
		
		customerEntity.setOrders(orderTransformer.getEntityListFromDtoList(customer.getOrders()));
		
		return customerEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Customer> getDtoListFromEntityList(Set<CustomerEntity> customerEntityList) {
		List<Customer> customers = new ArrayList<>();
		customerEntityList.stream().forEach(customerEntity -> customers.add(getDtoFromEntity(customerEntity)));
		return customers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CustomerEntity> getEntityListFromDtoList(List<Customer> customers) {
		Set<CustomerEntity> customerEntities = new HashSet<>();
		customers.stream().forEach(customer -> customerEntities.add(getEntityFromDto(customer)));
		return customerEntities;
	}

}
