/**
 * 
 */
package com.mycompany.sos.dao;

import java.util.List;

import com.mycompany.sos.dao.entities.ItemEntity;

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
