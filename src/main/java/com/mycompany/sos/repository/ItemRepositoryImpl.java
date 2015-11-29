/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import com.mycompany.sos.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * {@link ItemRepositoryImpl} class
 * 
 * implementation of {@link ItemRepository} interface
 * 
 * @author colin
 *
 */
@Repository("itemRepositoryImpl")
public class ItemRepositoryImpl implements ItemRepository {

	@PersistenceContext(unitName = "com.mycompany.sos.entitymanager")
	private EntityManager entityManager;
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addItem(Item item) {
		entityManager.persist(item);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Item> getItems() {
	
		List<Item> itemList = entityManager.createQuery("from Item", Item.class)
														.getResultList();
		
		return itemList;
	}

}
