/**
 * 
 */
package com.mycompany.sos.model.dto;

import java.util.HashSet;
import java.util.Set;

import com.mycompany.sos.dao.entities.CustomerEntity;
import com.mycompany.sos.dao.entities.ItemEntity;

/**
 * @author colin
 *
 */
public class Order {

	private int orderId;
	private CustomerEntity customer;
	private Set<ItemEntity> items = new HashSet<ItemEntity>(0);
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public Set<ItemEntity> getItems() {
		return items;
	}
	public void setItems(Set<ItemEntity> items) {
		this.items = items;
	}
}
