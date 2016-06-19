/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.controller;

import com.mycompany.sos.IntegrationTestCategory;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * {@link OrderControllerIntegrationTest} test class
 *
 * @author colin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/integration-test/resources/META-INF/test-context.xml"
})
@WebAppConfiguration
@Category(IntegrationTestCategory.class)
public class OrderControllerIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testShowCreateOrdersForm() throws Exception {
        mockMvc.perform(get("/orders/create").param("customerId", "1"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("createOrderForm", "itemsList"))
            .andExpect(view().name("orders/orders-createOrder"));
    }

    @Test
    public void testListOrders() throws Exception {
        mockMvc.perform(get("/orders"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("orders"))
            .andExpect(view().name("orders/orders"));
    }

}
