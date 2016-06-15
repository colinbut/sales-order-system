/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.model.Order;
import com.mycompany.sos.service.CustomerService;
import com.mycompany.sos.service.ItemService;
import com.mycompany.sos.service.OrderService;
import com.mycompany.sos.web.validator.OrderFormValidator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * {@link OrderControllerTest} test class
 *
 * @author colin
 */
@Category(UnitTestCategory.class)
public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @Mock
    private CustomerService customerService;

    @Mock
    private ItemService itemService;

    @Mock
    private OrderFormValidator orderFormValidator;

    @InjectMocks
    private OrderController orderController = new OrderController();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowCreateOrdersForm() {
        Customer customer = new Customer();

        Mockito.when(customerService.findCustomerByCustomerId(Matchers.anyInt()))
            .thenReturn(customer);
        Mockito.when(itemService.getItems()).thenReturn(Collections.emptyList());

        assertEquals("orders/orders-createOrder", orderController.showCreateOrdersForm(new ModelMap(), 1));

    }

    @Test
    public void testCreateOrder_Succss() {
        Order order = new Order();

        Mockito.doNothing().when(orderFormValidator)
            .validate(Matchers.anyObject(), Matchers.any(Errors.class));
        Mockito.when(orderService.addOrder(order)).thenReturn(true);

        ModelAndView modelAndView = orderController.createOrder(order, new DirectFieldBindingResult(null, ""));
        assertNotNull(modelAndView);
        assertEquals("orders-createOrderSuccess", modelAndView.getViewName());
    }

    @Test
    @Ignore
    public void testCreateOrder_Failure() {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }


    @Test
    public void testListOrders() {
        Mockito.when(orderService.getOrders()).thenReturn(Collections.emptyList());
        assertEquals("orders/orders", orderController.listOrders(new ModelMap()));
    }


}
