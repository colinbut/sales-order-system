/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link Order} class
 * 
 * Order entity
 * 
 * @author colin
 *
 */
@Entity
@Table(name = "orders")
public class Order {

	private int orderId;
	private Customer customer;
	private Set<Item> items = new HashSet<>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "orders_items",
		joinColumns = { @JoinColumn(name = "order_id", nullable = false, updatable = false)},
		inverseJoinColumns = { @JoinColumn(name = "item_id", nullable = false, updatable = false)}
			)
	public Set<Item> getItems() {
		return items;
	}
	
	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer
				+ ", items=" + items + "]";
	}
	
}
