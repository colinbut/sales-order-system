/**
 * 
 */
package com.mycompany.sos.dao;

import java.util.List;

import com.mycompany.sos.dao.entities.CustomerEntity;

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
