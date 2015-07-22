/**
 * 
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.dao.entities.ItemEntity;
import com.mycompany.sos.model.Item;

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
