/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import com.mycompany.sos.model.CustomerEntity;

import java.util.List;

/**
 * {@link CustomerRepository} interface
 * 
 * @author colin
 *
 */
public interface CustomerRepository {

	/**
	 * Gets a list of customers
	 * 
	 * @return list of customers
	 */
	List<CustomerEntity> getCustomers();
	
	/**
	 * Adds a new customer
	 * 
	 * @param customer the new customer to add
	 * @return true if successfully added false otherwise
	 */
	CustomerEntity addCustomer(CustomerEntity customer);
	
	/**
	 * Edits a customer data
	 * 
	 * @param customer the customer to edit
	 * @return true if successfully edited false otherwise
	 */
	boolean editCustomer(CustomerEntity customer);
	
	/**
	 * Deletes a customer
	 * 
	 * @param customer the customer to delete
	 * @return true if successfully delete false otherwise
	 */
	boolean deleteCustomer(CustomerEntity customer);
	
	/**
	 * Finds the customer with the given customer name
	 * 
	 * @param customerName the name of the customer
	 * @return the Customer Entity
	 */
	CustomerEntity findCustomerByCustomerName(String customerName);
	
	/**
	 * Finds the customer with the given customer id
	 * 
	 * @param customerId the id identifying the customer
	 * @return the Customer Entity
	 */
	CustomerEntity findCustomerByCustomerId(int customerId);
}
