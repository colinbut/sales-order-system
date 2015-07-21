/**
 * 
 */
package com.mycompany.sos.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Order dto
 * 
 * @author colin
 *
 */
public class Order {

	private int orderId;
	private Customer customer;
	private Set<Item> items = new HashSet<Item>(0);
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
