/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.sos.model.Item;
import com.mycompany.sos.service.ItemService;
import com.mycompany.sos.service.converters.Converter;
import com.mycompany.sos.service.converters.ItemViewModelConverter;
import com.mycompany.sos.web.viewmodel.modeldata.ItemModel;

/**
 * {@link ItemController} class
 * 
 * @author colin
 *
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	private Converter<ItemModel, Item> itemModelItemConverter = ItemViewModelConverter::convertItemToItemModel;
	
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
}
