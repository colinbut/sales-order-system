/**
 * 
 */
package com.mycompany.sos.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


/**
 * Item dto
 * 
 * @author colin
 *
 */
public class Item {

	private int itemId;
	private String itemName;
	private BigDecimal itemPrice;
	
	private Set<Order> orders = new HashSet<Order>();

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

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
