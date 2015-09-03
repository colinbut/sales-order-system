/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.converters;

import org.springframework.stereotype.Component;

import com.mycompany.sos.model.Item;
import com.mycompany.sos.web.viewmodel.forms.CreateItemForm;
import com.mycompany.sos.web.viewmodel.modeldata.ItemModel;

/**
 * {@link ItemViewModelConverter} class
 * 
 * Converts between View (ViewModel) and Model objects 
 * 
 * @author colin
 *
 */
@Component
public class ItemViewModelConverter {

	public static ItemModel convertItemToItemModel(Item item) {
		ItemModel itemModel = new ItemModel();
		itemModel.setItemId(item.getItemId());
		itemModel.setItemName(item.getItemName());
		itemModel.setItemPrice(item.getItemPrice());
		return itemModel;
	}
	
	public static Item convertItemFormToItem(CreateItemForm createItemForm) {
		Item item = new Item();
		item.setItemName(createItemForm.getItemName());
		item.setItemPrice(createItemForm.getItemPrice());
		return item;
	}
}
