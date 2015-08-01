/**
 * 
 */
package com.mycompany.sos.model;

import java.math.BigDecimal;

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

}
