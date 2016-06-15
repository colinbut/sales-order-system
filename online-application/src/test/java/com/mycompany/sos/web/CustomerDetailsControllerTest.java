/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.Assert.assertEquals;

/**
 * {@link CustomerDetailsControllerTest} test class
 *
 * @author colin
 */
@Category(UnitTestCategory.class)
public class CustomerDetailsControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerDetailsController customerDetailsController = new CustomerDetailsController();


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCustomerDetailsPage() {
        Mockito.when(customerService.findCustomerByCustomerId(Matchers.anyInt()))
            .thenReturn(new Customer());
        assertEquals("customers/customerDetails", customerDetailsController.getCustomerDetailsPage("1", new BindingAwareModelMap()));
    }

}
