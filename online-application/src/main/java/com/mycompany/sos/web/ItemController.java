/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import com.mycompany.sos.model.Item;
import com.mycompany.sos.service.ItemService;
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

import javax.validation.Valid;
import java.util.List;

/**
 * {@link ItemController} class
 *
 * @author colin
 */
@Controller
public class ItemController {

	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;


	/**
	 * Shows the items list page
	 *
	 * @param model the model
	 * @return view name
	 */
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String showItemsList(ModelMap model) {
		List<Item> items = itemService.getItems();
		model.addAttribute("items", items);
		return "items/items";
	}

	/**
	 * Shows the create item form page
	 *
	 * @param modelMap Spring's framework model map object containing the model data
	 * @return view name
	 */
	@RequestMapping(value = "/items/create", method = RequestMethod.GET)
	public String showCreateItemPage(ModelMap modelMap) {
		modelMap.addAttribute("createItemForm", new Item());
		logger.info("Accessed Create Item page");
		logger.debug("Retrieved createItemForm");
		return "items/items-create";
	}

	/**
	 * Handles the create item form submit
	 *
	 * @param item the item entity (used as the form backing object also)
	 * @param result Spring's framework binding result object
	 * @return model and view object
	 */
	@RequestMapping(value = "/items/createItem", method = RequestMethod.POST)
	public ModelAndView createItem(
			@Valid @ModelAttribute("createItemForm") Item item,
			BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();

		if(result.hasErrors()) {
			modelAndView.setViewName("items-create");
			return modelAndView;
		}

		if(itemService.addItem(item)) {
			logger.info("Successfully added item");
			// should redirect back to items list page
			modelAndView.setViewName("redirect:/items");
		} else {
			logger.warn("Unable to add item");
		}

		return modelAndView;
	}
}
