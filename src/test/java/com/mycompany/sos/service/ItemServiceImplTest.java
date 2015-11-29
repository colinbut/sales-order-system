/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.model.Item;
import com.mycompany.sos.repository.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * {@link ItemServiceImplTest} test class
 * 
 * @author colin
 *
 */
@Category(UnitTestCategory.class)
public class ItemServiceImplTest {

	@Mock
	private ItemRepository itemRepository;
	
	@InjectMocks
	private ItemService itemService = new ItemServiceImpl();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddItem() {
		Mockito.when(itemRepository.save(Matchers.any(Item.class))).thenReturn(new Item());
		boolean result = itemService.addItem(new Item());
		assertTrue(result);
	}
	
	@Test
	public void testGetItems() {
		List<Item> itemEntities = new ArrayList<>();
		itemEntities.add(new Item());
		Mockito.when(itemRepository.findAll()).thenReturn(itemEntities);
		List<Item> items = itemService.getItems();
		assertFalse(items.isEmpty());
	}
}
