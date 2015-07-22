/**
 * 
 */
package com.mycompany.sos.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.sos.dao.ItemDao;
import com.mycompany.sos.dao.entities.ItemEntity;
import com.mycompany.sos.model.Item;

/**
 * @author colin
 *
 */
@Service("itemServiceImpl")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public boolean addItem(ItemEntity item) {
		return itemDao.addItem(item);
	}

	@Override
	public List<Item> getItems() {
		
		List<Item> items = new ArrayList<Item>();
		
		return items;
	}

}
