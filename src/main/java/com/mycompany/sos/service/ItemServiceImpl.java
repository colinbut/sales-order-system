/**
 * 
 */
package com.mycompany.sos.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.sos.model.Item;
import com.mycompany.sos.repository.ItemDao;
import com.mycompany.sos.repository.entities.ItemEntity;
import com.mycompany.sos.service.transformers.ItemTransformer;

/**
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
	private ItemTransformer itemTransformer;
	
	@Override
	public boolean addItem(ItemEntity item) {
		return itemDao.addItem(item);
	}

	@Override
	public List<Item> getItems() {
		
		logger.info("Retrieving items list from system");
		
		List<ItemEntity> itemEntityList = itemDao.getItems();
		
		logger.info("Obtained items list from system");
		
		List<Item> items = new ArrayList<>();
		
		for(ItemEntity itemEntity : itemEntityList) {
			items.add(itemTransformer.getDtoFromEntity(itemEntity));
		}
		
		return items;
	}

}
