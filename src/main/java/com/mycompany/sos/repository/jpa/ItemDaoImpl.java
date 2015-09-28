/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.sos.repository.ItemDao;
import com.mycompany.sos.repository.entities.ItemEntity;

/**
 * {@link ItemDaoImpl} class
 * 
 * implementation of {@link ItemDao} interface
 * 
 * @author colin
 *
 */
@Repository("itemDaoImpl")
public class ItemDaoImpl implements ItemDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addItem(ItemEntity itemEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(itemEntity);
		entityManager.getTransaction().commit();
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
