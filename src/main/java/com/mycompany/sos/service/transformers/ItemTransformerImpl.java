/**
 * 
 */
package com.mycompany.sos.service.transformers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.sos.dao.entities.ItemEntity;
import com.mycompany.sos.model.Item;

/**
 * @author colin
 *
 */
@Component
public class ItemTransformerImpl implements ItemTransformer {

	@Autowired
	private OrderTransformer orderTransformer;
	
	
	@Override
	public Item getDtoFromEntity(ItemEntity itemEntity) {
		
		Item item = new Item();
		item.setItemName(itemEntity.getItemName());
		item.setItemPrice(itemEntity.getItemPrice());
		item.setOrders(orderTransformer.getDtoListFromEntityList(itemEntity.getOrders()));
		
		return item;
	}

	@Override
	public ItemEntity getEntityFromDto(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Item> getDtoListFromEntityList(Set<ItemEntity> itemEntityList) {
		
		Set<Item> items = new HashSet<>();
		
		for(ItemEntity itemEntity : itemEntityList) {
			items.add(getDtoFromEntity(itemEntity));
		}
		
		return items;
	}

}
