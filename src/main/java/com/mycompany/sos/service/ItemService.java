/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.model.Item;

/**
 * ItemService interface
 * 
 * @author colin
 *
 */
public interface ItemService {

	/**
	 * 
	 * @param item
	 * @return
	 */
	boolean addItem(Item item);
	
	/**
	 * 
	 * @return
	 */
	List<Item> getItems();
}
