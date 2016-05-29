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

    @Test
    public void testGetOrders() {
        orderRepository.save(buildTestOrder());
        List<Order> orders = orderRepository.findAll();
        assertTrue(orders.size() == 1);
    }

    @Test
    public void testAddOrders() {
        orderRepository.save(buildTestOrder());
        List<Order> orders = orderRepository.findAll();
        assertTrue(orders.size() == 1);
    }

    private Order buildTestOrder() {
        Order order = new Order();
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Rainbow");
        customer.setDateOfBirth(new Date());
        customer.setEmail("johnny.rainbow@hotmail.co.uk");

        order.setCustomer(customer);

        Item item = new Item();
        item.setItemName("Item1");
        item.setItemPrice(BigDecimal.valueOf(2.3));

        Set<Item> items = new HashSet<>();
        items.add(item);

        order.setItems(items);
        return order;
    }
}
