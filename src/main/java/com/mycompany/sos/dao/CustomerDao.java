/**
 * 
 */
package com.mycompany.sos.dao;

import com.mycompany.sos.model.entities.Customer;

/**
 * CustomerDao interface
 * 
 * @author colin
 *
 */
public interface CustomerDao {

	boolean addCustomer(Customer customer);
	
	boolean editCustomer(Customer customer);
	
	boolean deleteCustomer(Customer customer);
}
