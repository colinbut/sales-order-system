/**
 * 
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.model.Item;
import com.mycompany.sos.repository.entities.ItemEntity;

/**
 * ItemService interface
 * 
 * @author colin
 *
 */
public interface ItemService {

	boolean addItem(ItemEntity item);
	
	List<Item> getItems();
}
