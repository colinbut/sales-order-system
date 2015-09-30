/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.model.ItemEntity;
import com.mycompany.sos.repository.ItemRepository;

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
		Mockito.when(itemRepository.addItem(Matchers.any(ItemEntity.class))).thenReturn(true);
		boolean result = itemService.addItem(new ItemEntity());
		assertTrue(result);
	}
	
	@Test
	public void testGetItems() {
		List<ItemEntity> itemEntities = new ArrayList<>();
		itemEntities.add(new ItemEntity());
		Mockito.when(itemRepository.getItems()).thenReturn(itemEntities);
		List<ItemEntity> items = itemService.getItems();
		assertFalse(items.isEmpty());
	}
}
