/**
 * 
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.dao.entities.CustomerEntity;
import com.mycompany.sos.model.Customer;

/**
 * @author colin
 *
 */
public interface CustomerService {

	boolean addCustomer(CustomerEntity customer);
	
	List<Customer> getCustomers();
}
