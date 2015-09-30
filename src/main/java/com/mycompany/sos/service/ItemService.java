/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.repository.entities.ItemEntity;

/**
 * {@link ItemService} interface
 * 
 * @author colin
 *
 */
public interface ItemService {

	/**
	 * Adds a new item 
	 * 
	 * @param item the new item to add
	 * @return true if successfully added false otherwise
	 */
	boolean addItem(ItemEntity item);
	
	/**
	 * Retrieves a list of items
	 * 
	 * @return list of items
	 */
	List<ItemEntity> getItems();
}
