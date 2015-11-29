/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import com.mycompany.sos.IntegrationTestCategory;
import com.mycompany.sos.model.Item;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration test class for {@link ItemRepositoryImpl}
 *
 * @author colin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/integration-test/resources/META-INF/test-context.xml"
        //"classpath:META-INF/test-context.xml"
    }
)
@Category(IntegrationTestCategory.class)
public class ItemRepositoryIT {

    @Autowired
    private ItemRepository itemRepository;

    public void testAddItem() {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    /**
     * Test the getting of items
     */
    @Test
    public void testGetItems() {
        List<Item> items = itemRepository.getItems();
        assertTrue(!items.isEmpty());
        assertTrue(items.size() == 1);
        assertEquals("test-item", items.get(0).getItemName());
        assertEquals(23.20, items.get(0).getItemPrice().doubleValue(), 1);
        assertEquals(1, items.get(0).getItemId());
        assertTrue(items.get(0).getOrders().isEmpty());
    }
}
