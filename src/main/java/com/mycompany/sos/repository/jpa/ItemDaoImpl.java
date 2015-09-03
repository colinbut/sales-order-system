/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.repository.jpa;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

	private EntityManager entityManager;
	
	Logger logger = LoggerFactory.getLogger(ItemDaoImpl.class);
	
	@PostConstruct
	public void init(){
		logger.info("Setting up EntityManager");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
				"com.mycompany.sos.entitymanager");
		
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@PreDestroy
	public void destroy() {
		logger.info("Cleaning up resources");
		if(entityManager.isOpen()) {
			if(logger.isDebugEnabled()) {
				logger.debug("EntityManager is open - closing it");
			}
			entityManager.close();
		}
	}
	
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
