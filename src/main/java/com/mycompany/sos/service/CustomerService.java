/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import com.mycompany.sos.model.CustomerEntity;

import java.util.List;

/**
 * {@link CustomerService} interface
 * 
 * @author colin
 */
public interface CustomerService {

	/**
	 * Adds a customer to the system
	 * <p> 
	 * This makes an underlying call to insert into the database
	 * 
	 * @param customer the customer to add
	 * @return true if successful false otherwise
	 */
	CustomerEntity addCustomer(CustomerEntity customer);
	
	/**
	 * Gets a list of customers
	 * 
	 * @return a list of customers
	 */
	List<CustomerEntity> getCustomers();
	
	/**
	 * Finds the Customer by the given customer name
	 * 
	 * @param customerName the name of the customer
	 * @return the customer
	 */
	CustomerEntity findCustomerByCustomerName(String customerName);
	
	/**
	 * Finds the Customer by the given customer id
	 * 
	 * @param customerId id identifying the customer
	 * @return the customer
	 */
	CustomerEntity findCustomerByCustomerId(int customerId);
}
