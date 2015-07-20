/**
 * 
 */
package com.mycompany.sos.dao;

import org.springframework.stereotype.Repository;

import com.mycompany.sos.dao.entities.Item;

/**
 * @author colin
 *
 */
@Repository("itemDaoImpl")
public class ItemDaoImpl implements ItemDao {

	@Override
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

}
