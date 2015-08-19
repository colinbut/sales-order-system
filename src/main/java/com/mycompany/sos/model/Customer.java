/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer dto
 * 
 * @author colin
 *
 */
public class Customer {

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String email;
	
	private Address address;
	private CustomerPaymentDetails customerPaymentDetails;
	
	private Set<Order> orders = new HashSet<>();
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public CustomerPaymentDetails getCustomerPaymentDetails() {
		return customerPaymentDetails;
	}
	
	public void setCustomerPaymentDetails(
			CustomerPaymentDetails customerPaymentDetails) {
		this.customerPaymentDetails = customerPaymentDetails;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
}
