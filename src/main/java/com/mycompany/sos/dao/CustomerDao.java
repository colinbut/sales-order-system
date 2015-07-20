/**
 * 
 */
package com.mycompany.sos.dao;

import java.util.List;

import com.mycompany.sos.dao.entities.Customer;

/**
 * CustomerDao interface
 * 
 * @author colin
 *
 */
public interface CustomerDao {

	List<Customer> getCustomers();
	
	boolean addCustomer(Customer customer);
	
	boolean editCustomer(Customer customer);
	
	boolean deleteCustomer(Customer customer);
}
