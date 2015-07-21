/**
 * 
 */
package com.mycompany.sos.service.transformers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.sos.dao.entities.CustomerEntity;
import com.mycompany.sos.model.Customer;

/**
 * @author colin
 *
 */
@Component
public class CustomerTransformerImpl implements CustomerTransformer {

	@Autowired
	private AddressTransformer addressTransformer;
	
	@Override
	public Customer getDtoFromEntity(CustomerEntity customerEntity) {
		
		Customer customer = new Customer();
		customer.setFirstName(customerEntity.getFirstName());
		customer.setLastName(customerEntity.getLastName());
		customer.setDateOfBirth(customerEntity.getDateOfBirth());
		customer.setEmail(customerEntity.getEmail());
		customer.setAddress(addressTransformer.getDtoFromEntity(customerEntity.getAddress()));
		
		return customer;
	}

	@Override
	public CustomerEntity getEntityFromDto(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Customer> getDtoListFromEntityList(Set<CustomerEntity> customerEntityList) {
		Set<Customer> customers = new HashSet<Customer>();
		
		for(CustomerEntity customerEntity : customerEntityList) {
			customers.add(getDtoFromEntity(customerEntity));
		}
		
		return customers;
	}

	
}
