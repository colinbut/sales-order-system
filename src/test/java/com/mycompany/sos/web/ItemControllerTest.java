/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.model.ItemEntity;
import com.mycompany.sos.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;

/**
 * {@link ItemControllerTest} test class
 * 
 * @author colin
 *
 */
@Category(UnitTestCategory.class)
public class ItemControllerTest {

	@Mock
	private ItemService itemService;
	
	@InjectMocks
	private ItemController itemController = new ItemController();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShowItemsList() {
		assertEquals("items", itemController.showItemsList(new ModelMap()));
	}
	
	@Test
	public void testShowCreateItemPage() {
		assertEquals("items-create", itemController.showCreateItemPage(new ModelMap()));
	}
	
	@Test
	public void testCreateItem() {
		Mockito.when(itemService.addItem(Matchers.any(ItemEntity.class))).thenReturn(true);
		ModelAndView modelAndView = itemController.createItem(new ItemEntity(), 
				new DirectFieldBindingResult(null, null));
		
		assertNotNull(modelAndView);
		assertEquals("items", modelAndView.getViewName());
	}
}
