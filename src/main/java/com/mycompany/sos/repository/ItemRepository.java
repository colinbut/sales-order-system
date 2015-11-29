/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import com.mycompany.sos.model.Item;

import java.util.List;

/**
 * {@link ItemRepository} interface
 * 
 * @author colin
 *
 */
public interface ItemRepository {

	/**
	 * Adds a new item 
	 * 
	 * @param item the new item to add
	 * @return true if successfully added false otherwise
	 */
	boolean addItem(Item item);
	
	/**
	 * Retrieves a list of items
	 * 
	 * @return list of items
	 */
	List<Item> getItems();
}
