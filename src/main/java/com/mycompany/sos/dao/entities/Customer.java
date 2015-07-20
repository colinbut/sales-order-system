/**
 * 
 */
package com.mycompany.sos.dao.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Customer entity
 * 
 * @author colin
 *
 */
@Entity
@Table(name = "customer")
public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String email;

	// M : 1
	private Address address;
	
	// 1 : 1
	private CustomerPaymentDetail customerPaymentDetail;
	
	// 1 : M
	private Set<Order> orders = new HashSet<Order>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Column(name = "customer_firstname", nullable = false, length = 50)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "customer_lastname", nullable = false, length = 50)
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "customer_date_of_birth", nullable = false)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Column(name = "customer_email_address", nullable = false, columnDefinition = "TEXT")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_address_id")
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
	public CustomerPaymentDetail getCustomerPaymentDetail() {
		return customerPaymentDetail;
	}

	public void setCustomerPaymentDetail(CustomerPaymentDetail customerPaymentDetail) {
		this.customerPaymentDetail = customerPaymentDetail;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", address=" + address
				+ "]";
	}

	
}
