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

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Integration test class for {@link ItemRepository}
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


    @Test
    public void testAddItem() {
        Item item = new Item();
        item.setItemName("New Item");
        item.setItemPrice(BigDecimal.valueOf(12.00));
        item.setOrders(Collections.emptySet());

        itemRepository.save(item);

        List<Item> items = itemRepository.findAll();

        assertTrue(items.size() == 2);

    }

    /**
     * Test the getting of items
     * //TODO fix this test (too many asserts)
     */
    @Test
    public void testGetItems() {
        List<Item> items = itemRepository.findAll();
        assertTrue(!items.isEmpty());
        assertTrue(items.size() == 1);
        assertEquals("test-item1", items.get(0).getItemName());
        assertEquals(23.20, items.get(0).getItemPrice().doubleValue(), 1);
        assertEquals(1, items.get(0).getItemId());
        assertFalse(items.get(0).getOrders().isEmpty());
    }
}
