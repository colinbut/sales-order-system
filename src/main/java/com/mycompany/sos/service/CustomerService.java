/**
 * 
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.model.entities.Customer;

/**
 * @author colin
 *
 */
public interface CustomerService {

	boolean addCustomer(Customer customer);
	
	List<Customer> getCustomers();
}
