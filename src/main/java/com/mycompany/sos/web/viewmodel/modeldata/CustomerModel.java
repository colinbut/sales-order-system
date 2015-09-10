/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web.viewmodel.modeldata;

import java.util.Date;

/**
 * {@link CustomerModel} class
 * 
 * @author colin
 *
 */
public class CustomerModel {
	
	private int customerId;
	private String customerName;
	private Date dateOfBirth;
	private String emailAddress;
	private String address;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "CustomerModel [customerName=" + customerName + ", dateOfBirth="
				+ dateOfBirth + ", emailAddress=" + emailAddress + ", address="
				+ address + "]";
	}
	
}
