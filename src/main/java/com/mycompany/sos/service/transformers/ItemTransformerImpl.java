/**
 * 
 */
package com.mycompany.sos.service.transformers;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.mycompany.sos.model.Item;
import com.mycompany.sos.repository.entities.ItemEntity;

/**
 * ItemTransformerImpl class
 * 
 * @author colin
 *
 */
@Component
public class ItemTransformerImpl implements ItemTransformer {
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Item getDtoFromEntity(ItemEntity itemEntity) {
		Item item = new Item();
		item.setItemName(itemEntity.getItemName());
		item.setItemPrice(itemEntity.getItemPrice());
		return item;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemEntity getEntityFromDto(Item item) {
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setItemName(item.getItemName());
		itemEntity.setItemPrice(item.getItemPrice());
		return itemEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Item> getDtoListFromEntityList(Set<ItemEntity> itemEntityList) {
		
		Set<Item> items = new HashSet<>();
		
		for(ItemEntity itemEntity : itemEntityList) {
			items.add(getDtoFromEntity(itemEntity));
		}
		
		return items;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<ItemEntity> getEntityListFromDtoList(Set<Item> items) {
		Set<ItemEntity> itemEntities = new HashSet<>();
		items.stream().forEach(item -> itemEntities.add(getEntityFromDto(item)) );
		return itemEntities;
	}

}
