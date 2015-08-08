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

	@NotNull(message = "error.null.firstname")
	@NotBlank(message = "error.blank.firstname")
	@NotEmpty(message = "error.empty.firstname")
	@Pattern(regexp = "[a-zA-Z]*", message = "error.invalid.firstname")
	private String firstName;
	
	@NotNull(message = "error.null.lastname")
	@NotBlank(message = "error.blank.lastname")
	@NotEmpty(message = "error.empty.lastname")
	@Pattern(regexp = "[a-zA-Z]*", message = "error.invalid.lastname")
	private String lastName;
	
	@NotNull(message = "error.null.dob")
	@Past(message = "error.past.dob")
	private Date dateOfBirth;
	
	@NotNull(message = "error.null.email")
	@NotBlank(message = "error.blank.email")
	@NotEmpty(message = "error.empty.email")
	@Email(message = "error.email")
	private String emailAddress;
	
	@NotNull(message = "error.null.houseFlatNo")
	@Min(value = 1, message = "error.min.houseFlatNo")
	private int houseFlatNo;
	
	@NotNull(message = "error.null.street")
	@NotBlank(message = "error.blank.street")
	@NotEmpty(message = "error.empty.street")
	@Pattern(regexp = "[a-zA-Z]*", message = "error.invalid.street")
	private String street;
	
	@NotNull(message = "error.null.postcode")
	@NotBlank(message = "error.blank.postcode")
	@NotEmpty(message = "error.empty.postcode")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "error.invalid.postcode")
	private String postcode;
	
	@NotNull(message = "error.null.city")
	@NotBlank(message = "error.blank.city")
	@NotEmpty(message = "error.empty.city")
	@Pattern(regexp = "[a-zA-Z]*", message = "error.invalid.city")
	private String city;
	
	@NotNull(message = "error.null.country")
	@NotBlank(message = "error.blank.country")
	@NotEmpty(message = "error.empty.country")
	@Pattern(regexp = "[a-zA-Z]*", message = "error.invalid.country")
	private String country;
	
	
	@NotNull(message = "error.null.cardNo")
	@NotBlank(message = "error.blank.cardNo")
	@NotEmpty(message = "error.empty.cardNo")
	@Pattern(regexp = "[0-9]*", message = "error.invalid.cardNo")
	private String cardNo;
	
	@NotNull(message = "error.null.expDate")
	@Future(message = "error.future.expDate")
	private Date expDate;
	
	@NotNull(message = "error.null.customerReference")
	@NotBlank(message = "error.blank.customerReference")
	@NotEmpty(message = "error.empty.customerReference")
	@Size(min = 1, max = 20, message = "error.size.customerReference")
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
	
	public Date getExpDate() {
		return expDate;
	}
	
	public void setExpDate(Date expDate) {
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
