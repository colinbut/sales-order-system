/**
 * 
 */
package com.mycompany.sos.dao;

import org.springframework.stereotype.Repository;

import com.mycompany.sos.model.entities.Customer;

/**
 * CustomerDaoImpl class
 * 
 * @author colin
 *
 */
@Repository("customerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public boolean addCustomer(Customer customer) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

	@Override
	public boolean editCustomer(Customer customer) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

}
