/**
 * 
 */
package com.mycompany.sos.dao;

import org.springframework.stereotype.Repository;

import com.mycompany.sos.dao.entities.ItemEntity;

/**
 * @author colin
 *
 */
@Repository("itemDaoImpl")
public class ItemDaoImpl implements ItemDao {

	@Override
	public boolean addItem(ItemEntity item) {
		// TODO Auto-generated method stub
		return false;
	}

}
