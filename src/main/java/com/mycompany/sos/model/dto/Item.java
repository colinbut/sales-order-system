/**
 * 
 */
package com.mycompany.sos.model.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.mycompany.sos.dao.entities.OrderEntity;

/**
 * @author colin
 *
 */
public class Item {

	private int itemId;
	private String itemName;
	private BigDecimal itemPrice;
	
	private Set<OrderEntity> orders = new HashSet<OrderEntity>();

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Set<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderEntity> orders) {
		this.orders = orders;
	}
}
