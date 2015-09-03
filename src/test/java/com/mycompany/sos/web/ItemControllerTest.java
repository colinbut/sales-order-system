/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.model.Item;
import com.mycompany.sos.service.ItemService;
import com.mycompany.sos.web.viewmodel.forms.CreateItemForm;

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
		Mockito.when(itemService.addItem(Matchers.any(Item.class))).thenReturn(true);
		ModelAndView modelAndView = itemController.createItem(new CreateItemForm(), 
				new DirectFieldBindingResult(null, null));
		
		assertNotNull(modelAndView);
		assertEquals("items", modelAndView.getViewName());
	}
}
