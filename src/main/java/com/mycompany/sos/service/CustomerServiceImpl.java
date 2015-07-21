/**
 * 
 */
package com.mycompany.sos.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.sos.dao.CustomerDao;
import com.mycompany.sos.dao.entities.CustomerEntity;
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.service.transformers.CustomerTransformer;


/**
 * @author colin
 *
 */
@Service("customerServiceImpl")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerTransformer customerTransformer;
	
	@Override
	public boolean addCustomer(CustomerEntity customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		
		List<CustomerEntity> customerEntityList = customerDao.getCustomers();
		
		List<Customer> customers = new ArrayList<Customer>();
		
		for(CustomerEntity entity :customerEntityList) {
			customers.add(customerTransformer.getDtoFromEntity(entity));
		}
				
		return customers;
	}

}
