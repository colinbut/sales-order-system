/**
 * 
 */
package com.mycompany.sos.web.viewmodel.forms;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Create customer form
 * 
 * @author colin
 */
public class CreateCustomerForm {

	@NotNull
	@NotBlank
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]*", message = "Firstname has invalid characters")
	private String firstName;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]*", message = "Lastname has invalid characters")
	private String lastName;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Past(message = "DOB must be in the past")
	private Date dateOfBirth;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Email
	private String emailAddress;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Min(value = 1, message = "")
	private int houseFlatNo;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]*", message = "Street name has invalid characters")
	private String street;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "Postcode has invalid characters")
	private String postcode;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]*", message = "City has invalid characters")
	private String city;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]*", message = "")
	private String country;
	
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Pattern(regexp = "[0-9]*", message = "")
	private String cardNo;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Future(message = "Expiry date must be in the future")
	private String expDate;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 1, max = 20)
	private String customerReference;
	
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
	
	public String getCardNo() {
		return cardNo;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public String getExpDate() {
		return expDate;
	}
	
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	public String getCustomerReference() {
		return customerReference;
	}
	
	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}
	
	@Override
	public String toString() {
		return "CreateCustomerForm [firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", houseFlatNo=" + houseFlatNo + ", street="
				+ street + ", postcode=" + postcode + ", city=" + city
				+ ", country=" + country + ", cardNo=" + cardNo + ", expDate="
				+ expDate + ", customerReference=" + customerReference + "]";
	}
	
}
