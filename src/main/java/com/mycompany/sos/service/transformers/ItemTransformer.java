/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.transformers;

import java.util.Set;

import com.mycompany.sos.model.Item;
import com.mycompany.sos.repository.entities.ItemEntity;

/**
 * @author colin
 *
 */
public interface ItemTransformer {

	/**
	 * 
	 * @param itemEntity
	 * @return
	 */
	Item getDtoFromEntity(ItemEntity itemEntity);
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	ItemEntity getEntityFromDto(Item item);
	
	/**
	 * 
	 * @param itemEntityList
	 * @return
	 */
	Set<Item> getDtoListFromEntityList(Set<ItemEntity> itemEntityList);
	
	/**
	 * 
	 * @param items
	 * @return
	 */
	Set<ItemEntity> getEntityListFromDtoList(Set<Item> items);
}
