/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web.viewmodel.modeldata;

/**
 * View model data for the orders view table
 * 
 * @author colin
 *
 */
public class OrderModel {

	private int orderNo;
	private String customer;
	private String address;
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderModel [orderNo=" + orderNo + ", customer=" + customer
				+ ", address=" + address + "]";
	}
	
}
