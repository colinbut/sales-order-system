/**
 * 
 */
package com.mycompany.sos.web.forms;

import java.util.Date;

/**
 * @author colin
 *
 */
public class CreateCustomerForm {

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String emailAddress;
	private int houseFlatNo;
	private String street;
	private String postcode;
	private String city;
	private String country;
	
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
	@Override
	public String toString() {
		return "CreateCustomerForm [firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", houseFlatNo=" + houseFlatNo + ", street="
				+ street + ", postcode=" + postcode + ", city=" + city
				+ ", country=" + country + "]";
	}
}
