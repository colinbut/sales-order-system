/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.sos.model.Item;
import com.mycompany.sos.service.ItemService;
import com.mycompany.sos.service.converters.Converter;
import com.mycompany.sos.service.converters.ItemViewModelConverter;
import com.mycompany.sos.web.viewmodel.forms.CreateItemForm;
import com.mycompany.sos.web.viewmodel.modeldata.ItemModel;

/**
 * {@link ItemController} class
 * 
 * @author colin
 *
 */
@Controller
public class ItemController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ItemService itemService;
	
	private Converter<ItemModel, Item> itemModelItemConverter = ItemViewModelConverter::convertItemToItemModel;
	private Converter<Item, CreateItemForm> itemItemFormConverter = ItemViewModelConverter::convertItemFormToItem;
	
	/**
	 * Shows the items list page
	 * 
	 * @param model the model
	 * @return view name
	 */
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String showItemsList(ModelMap model) {
		
		List<Item> items = itemService.getItems();
		List<ItemModel> itemList = new ArrayList<>();
		
		items.stream().forEach(item -> {
			ItemModel itemModel = itemModelItemConverter.convert(item);
			itemList.add(itemModel);
		});
		
		model.addAttribute("items", itemList);
		
		return "items";
	}
	
	/**
	 * Shows the create item form page
	 * 
	 * @param modelMap
	 * @return view name
	 */
	@RequestMapping(value = "/items/create", method = RequestMethod.GET)
	public String showCreateItemPage(ModelMap modelMap) {
		modelMap.addAttribute("createItemForm", new CreateItemForm());
		logger.info("Accessed Create Item page");
		if(logger.isDebugEnabled()) {
			logger.debug("Retrieved createItemForm");
		}
		return "items-create";
	}
	
	/**
	 * Handles the create item form submit
	 * 
	 * @param createItemForm the form backing object
	 * @param result Spring's framework binding result object
	 * @return model and view object
	 */
	@RequestMapping(value = "/items/createItem", method = RequestMethod.POST)
	public ModelAndView createItem(
			@Valid @ModelAttribute("createItemForm") CreateItemForm createItemForm,
			BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result.hasErrors()) {
			modelAndView.setViewName("items-create");
			return modelAndView;
		}
		
		if(logger.isDebugEnabled()) {
			logger.debug(createItemForm.toString());
		}
		
		if(logger.isTraceEnabled()) {
			logger.trace("Converting form backing object to domain object (DTO)");
		}
		
		Item item = itemItemFormConverter.convert(createItemForm);
		
		if(itemService.addItem(item)) {
			logger.info("Successfully added item");
			// should redirect back to items list page
			modelAndView.setViewName("items");
		} else {
			logger.warn("Unable to add item");
		}
		
		return modelAndView;
	}
}
