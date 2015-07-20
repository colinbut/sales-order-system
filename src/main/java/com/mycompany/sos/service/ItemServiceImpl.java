/**
 * 
 */
package com.mycompany.sos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.sos.dao.ItemDao;
import com.mycompany.sos.dao.entities.Item;

/**
 * @author colin
 *
 */
@Service("itemServiceImpl")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public boolean addItem(Item item) {
		return itemDao.addItem(item);
	}

}
