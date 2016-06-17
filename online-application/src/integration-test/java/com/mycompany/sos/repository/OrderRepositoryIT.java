/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import com.mycompany.sos.IntegrationTestCategory;
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.model.Item;
import com.mycompany.sos.model.Order;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Integration test class for {@link OrderRepository}
 *
 * @author colin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/integration-test/resources/META-INF/test-context.xml"
})
@Category(IntegrationTestCategory.class)
public class OrderRepositoryIT {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testGetOrders() {
        List<Order> orders = orderRepository.findAll();
        assertTrue(orders.size() == 1);
    }

    @Test
    public void testAddOrders() {
        orderRepository.saveAndFlush(buildTestOrder());
        List<Order> orders = orderRepository.findAll();
        assertTrue(orders.size() == 2); // because there's already 1 order setup by the sql script...
    }

    private Order buildTestOrder() {
        Order order = new Order();

        Customer customer = customerRepository.findOne(1);
        order.setCustomer(customer);

        Set<Item> items = new HashSet<>(itemRepository.findAll()); // should be one
        order.setItems(items);

        Set<Order> orders = new HashSet<>();
        orders.add(order);
        customer.setOrders(orders);

        return order;
    }
}
