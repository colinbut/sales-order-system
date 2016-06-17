/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import com.mycompany.sos.IntegrationTestCategory;
import com.mycompany.sos.model.Address;
import com.mycompany.sos.model.Customer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * {@link CustomerRepositoryIT} test class
 *
 * An integration test class for {@link CustomerRepository}
 *
 * @author colin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/integration-test/resources/META-INF/test-context.xml"
})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Category(IntegrationTestCategory.class)
public class CustomerRepositoryIT {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testAddCustomer() {
        customerRepository.saveAndFlush(getTestCustomer());
        List<Customer> customers = customerRepository.findAll();
        assertTrue(customers.size() == 2);
    }

    @Test
    public void testFindByFirstNameAndLastName() {
        Customer customer = customerRepository.findByFirstNameAndLastName("firstname1", "lastname1");
        assertNotNull(customer);
        assertEquals("firstname1.lastname1@email.com", customer.getEmail());
    }


    @Test
    public void testGetCustomers() {
        List<Customer> customers = customerRepository.findAll();
        assertTrue(customers.size() == 1);
    }

    @Test
    public void testFindCustomerById() {
        Customer customer = customerRepository.findOne(1);
        assertNotNull(customer);
        assertEquals("firstname1", customer.getFirstName());
    }

    private Customer getTestCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Bloggs");
        customer.setEmail("joe.bloggs@hotmail.co.uk");
        customer.setDateOfBirth(new Date());

        Address address = new Address();
        address.setStreet("Street Name");
        address.setCity("City");
        address.setCountry("Country");
        address.setHouseFlatNo(12);
        address.setPostCode("HG34HY");

        customer.setAddress(address);

        return customer;
    }

}
