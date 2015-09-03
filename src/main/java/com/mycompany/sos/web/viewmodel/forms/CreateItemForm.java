/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web.viewmodel.forms;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

/**
 * {@link CreateItemForm} class
 * 
 * Create item form backing object
 * 
 * @author colin
 */
public class CreateItemForm {

	@NotNull(message = "{error.null.itemName}")
	private String itemName;
	
	@NotNull(message = "{error.null.itemPrice}")
	private BigDecimal itemPrice;
	
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
