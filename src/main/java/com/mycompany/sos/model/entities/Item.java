/**
 * 
 */
package com.mycompany.sos.model.entities;

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

/**
 * Item entity
 * 
 * @author colin
 *
 */
@Entity
@Table(name = "items")
public class Item {

	private int itemId;
	private String itemName;
	private BigDecimal itemPrice;
	
	private Set<Order> orders = new HashSet<Order>();
	
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
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemPrice=" + itemPrice + "]";
	}
	
	
	
	
}
