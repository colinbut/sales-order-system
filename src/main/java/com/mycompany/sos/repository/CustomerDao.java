/**
 * 
 */
package com.mycompany.sos.repository;

import java.util.List;

import com.mycompany.sos.repository.entities.CustomerEntity;

/**
 * CustomerDao interface
 * 
 * @author colin
 *
 */
public interface CustomerDao {

	List<CustomerEntity> getCustomers();
	
	boolean addCustomer(CustomerEntity customer);
	
	boolean editCustomer(CustomerEntity customer);
	
	boolean deleteCustomer(CustomerEntity customer);
}
