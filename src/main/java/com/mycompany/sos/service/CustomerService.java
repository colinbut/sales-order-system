/**
 * 
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.model.Customer;

/**
 * @author colin
 *
 */
public interface CustomerService {

	boolean addCustomer(Customer customer);
	
	List<Customer> getCustomers();
}
