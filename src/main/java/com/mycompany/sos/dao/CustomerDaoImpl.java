/**
 * 
 */
package com.mycompany.sos.dao;

import java.util.List;

import javax.annotation.PostConstruct;
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

	private EntityManager entityManager;
	
	@PostConstruct
	public void init(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
				"com.mycompany.sos.entitymanager");
		
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@Override
	public boolean addCustomer(Customer customer) {
		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.persist(customer);
			
			entityManager.getTransaction().commit();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
		
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
		
		List<Customer> customers = entityManager.createQuery("from Customer", Customer.class).getResultList();
		
		entityManager.close();
		
		return customers;
		
	}

}
