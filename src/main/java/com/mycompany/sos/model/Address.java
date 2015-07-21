/**
 * 
 */
package com.mycompany.sos.model;

import java.util.HashSet;
import java.util.Set;


/**
 * @author colin
 *
 */
public class Address {

	private int addressId;
	private int houseFlatNo;
	private String street;
	private String postCode;
	private String city;
	private String country;
	
	private Set<Customer> customers = new HashSet<Customer>(0);

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getHouseFlatNo() {
		return houseFlatNo;
	}

	public void setHouseFlatNo(int houseFlatNo) {
		this.houseFlatNo = houseFlatNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
}
