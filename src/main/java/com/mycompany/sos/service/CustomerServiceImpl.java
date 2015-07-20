/**
 * 
 */
package com.mycompany.sos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.sos.dao.CustomerDao;
import com.mycompany.sos.dao.entities.Customer;

/**
 * @author colin
 *
 */
@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public boolean addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

}
