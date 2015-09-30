/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.sos.model.ItemEntity;

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
	public boolean addItem(ItemEntity itemEntity) {
		entityManager.persist(itemEntity);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ItemEntity> getItems() {
	
		List<ItemEntity> itemEntityList = entityManager.createQuery("from ItemEntity", ItemEntity.class)
														.getResultList();
		
		return itemEntityList;
	}

}
