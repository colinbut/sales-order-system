/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import java.util.List;

import com.mycompany.sos.repository.entities.ItemEntity;

/**
 * ItemDao interface
 * 
 * @author colin
 *
 */
public interface ItemDao {

	boolean addItem(ItemEntity item);
	
	List<ItemEntity> getItems();
}
