/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.model.CustomerPaymentDetail;
import com.mycompany.sos.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;

/**
 * {@link CustomerControllerTest} test class
 *
 * @author colin
 */
@Category(UnitTestCategory.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController = new CustomerController();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testListCustomers() {
        assertEquals("customers/customers", customerController.listCustomers(new ModelMap()));
    }

    @Test
    public void testShowCreateCustomerFormPage() {
        assertEquals("customers/customers-createCustomer", customerController.showCreateCustomerFormPage(new ModelMap()));
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerPaymentDetail(new CustomerPaymentDetail());

        Mockito.when(customerService.addCustomer(Matchers.any(Customer.class)))
            .thenReturn(customer);

        ModelAndView modelAndView = customerController.createCustomer(customer, new DirectFieldBindingResult(null, ""));
        assertEquals("redirect:/customers/1", modelAndView.getViewName());
    }


}
