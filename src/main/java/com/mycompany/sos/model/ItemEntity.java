/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * {@link ItemEntity} class
 * 
 * Item entity
 * 
 * @author colin
 *
 */
@Entity
@Table(name = "items")
public class ItemEntity {

	private int itemId;
	
	@NotNull(message = "{error.null.itemName}")
	private String itemName;
	
	@NotNull(message = "{error.null.itemPrice}")
	private BigDecimal itemPrice;
	
	private Set<OrderEntity> orders = new HashSet<OrderEntity>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	public int getItemId() {
		return itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	@Column(name = "item_name", nullable = false, length = 255)
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
		
	@Column(name = "item_price", nullable = false)
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "items")
	public Set<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderEntity> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemPrice=" + itemPrice + "]";
	}
	
}
