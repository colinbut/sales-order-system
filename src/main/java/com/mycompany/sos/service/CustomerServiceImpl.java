/**
 * 
 */
package com.mycompany.sos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.sos.dao.CustomerDao;
import com.mycompany.sos.dao.entities.CustomerEntity;

/**
 * @author colin
 *
 */
@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public boolean addCustomer(CustomerEntity customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public List<CustomerEntity> getCustomers() {
		return customerDao.getCustomers();
	}

}
