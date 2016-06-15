/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import com.mycompany.sos.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link CustomerRepository} interface
 *
 * @author colin
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * Finds the {@link Customer} by the customer name (i.e firstname + lastname)
     *
     * @return {@link Customer}
     */
    Customer findByFirstNameAndLastName(String firstName, String lastName);
}
