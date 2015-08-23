/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.sos.model.Item;
import com.mycompany.sos.repository.ItemDao;
import com.mycompany.sos.repository.entities.ItemEntity;
import com.mycompany.sos.service.transformers.DomainEntityTransformer;

/**
 * {@link ItemServiceImpl} class 
 * 
 * implementation of the {@link ItemService} interface
 * 
 * @author colin
 *
 */
@Service("itemServiceImpl")
@Transactional
public class ItemServiceImpl implements ItemService {

	Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	@Qualifier("itemTransformer")
	private DomainEntityTransformer<Item, ItemEntity> itemTransformer;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addItem(Item item) {
		ItemEntity itemEntity = itemTransformer.getEntityFromDto(item);
		return itemDao.addItem(itemEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Item> getItems() {
		
		logger.info("Retrieving items list from system");
		
		List<ItemEntity> itemEntityList = itemDao.getItems();
		
		logger.info("Obtained items list from system");
		
		List<Item> items = new ArrayList<>();
		itemEntityList.stream().forEach(itemEntity -> items.add(itemTransformer.getDtoFromEntity(itemEntity)));
		
		return items;
	}

}
