/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import com.mycompany.sos.model.Item;
import com.mycompany.sos.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@link ItemServiceImpl} class
 *
 * implementation of the {@link ItemService} interface
 *
 * @author colin
 */
@Service("itemServiceImpl")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addItem(Item item) {
		return itemRepository.save(item) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Item> getItems() {
		return itemRepository.findAll();
	}

}
