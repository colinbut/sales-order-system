/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.transformers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.mycompany.sos.model.Item;
import com.mycompany.sos.repository.entities.ItemEntity;

/**
 * {@link ItemTransformerImpl} class
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
	public List<Item> getDtoListFromEntityList(Set<ItemEntity> itemEntityList) {
		List<Item> items = new ArrayList<>();
		itemEntityList.stream().forEach(itemEntity -> items.add(getDtoFromEntity(itemEntity)));
		return items;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<ItemEntity> getEntityListFromDtoList(List<Item> items) {
		Set<ItemEntity> itemEntities = new HashSet<>();
		items.stream().forEach(item -> itemEntities.add(getEntityFromDto(item)) );
		return itemEntities;
	}

}
