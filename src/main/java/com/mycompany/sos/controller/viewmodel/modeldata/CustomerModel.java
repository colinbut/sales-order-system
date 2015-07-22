/**
 * 
 */
package com.mycompany.sos.controller.viewmodel.modeldata;

import java.util.Date;

/**
 * @author colin
 *
 */
public class CustomerModel {

	private String customerName;
	private Date dateOfBirth;
	private String emailAddress;
	private String address;
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
