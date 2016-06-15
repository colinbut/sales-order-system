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
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * {@link ItemServiceImplTest} test class
 *
 * @author colin
 */
@Category(UnitTestCategory.class)
public class ItemServiceImplTest {

	@Mock
	private ItemRepository itemRepository;

	@InjectMocks
	private ItemService itemService = new ItemServiceImpl();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddItem() {
		Mockito.when(itemRepository.save(Matchers.any(Item.class))).thenReturn(new Item());
		assertThat(itemService.addItem(new Item())).isTrue();
	}

	@Test
	public void testGetItems() {
		List<Item> itemEntities = new ArrayList<>();
		itemEntities.add(new Item());

		Mockito.when(itemRepository.findAll()).thenReturn(itemEntities);

        List<Item> items = itemService.getItems();
		assertThat(items).isNotEmpty();
	}
}
