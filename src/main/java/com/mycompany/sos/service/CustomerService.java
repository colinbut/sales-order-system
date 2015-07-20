/**
 * 
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.dao.entities.CustomerEntity;

/**
 * @author colin
 *
 */
public interface CustomerService {

	boolean addCustomer(CustomerEntity customer);
	
	List<CustomerEntity> getCustomers();
}
