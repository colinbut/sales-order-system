/**
 * 
 */
package com.mycompany.sos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

	@Override
	public List<Customer> getCustomers() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
				"com.mycompany.sos.entitymanager");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Customer> customers = entityManager.createQuery("from customers", Customer.class).getResultList();
		
		entityManager.close();
		
		return customers;
		
	}

}
