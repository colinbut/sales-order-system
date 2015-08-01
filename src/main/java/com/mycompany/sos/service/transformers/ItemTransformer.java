/**
 * 
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

	Item getDtoFromEntity(ItemEntity itemEntity);
	
	ItemEntity getEntityFromDto(Item item);
	
	Set<Item> getDtoListFromEntityList(Set<ItemEntity> itemEntityList);
	
	Set<ItemEntity> getEntityListFromDtoList(Set<Item> items);
}
