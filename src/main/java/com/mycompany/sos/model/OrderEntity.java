/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * {@link OrderEntity} class
 * 
 * Order entity
 * 
 * @author colin
 *
 */
@Entity
@Table(name = "orders")
public class OrderEntity {

	private int orderId;
	private CustomerEntity customer;
	private Set<ItemEntity> items = new HashSet<>(0);
	
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
	public CustomerEntity getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "orders_items",
		joinColumns = { @JoinColumn(name = "order_id", nullable = false, updatable = false)},
		inverseJoinColumns = { @JoinColumn(name = "item_id", nullable = false, updatable = false)}
			)
	public Set<ItemEntity> getItems() {
		return items;
	}
	
	public void setItems(Set<ItemEntity> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer
				+ ", items=" + items + "]";
	}
	
}
