/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web.viewmodel.forms;

import java.util.List;

/**
 * @author colin
 *
 */
public class CreateOrderForm {

	private String customer;
	private List<String> items;
	
	public String getCustomer() {
		return customer;
	}
	
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public List<String> getItems() {
		return items;
	}
	
	public void setItems(List<String> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CreateOrderForm [customer=" + customer + ", items=" + items
				+ "]";
	}
}
