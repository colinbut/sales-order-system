/**
 * 
 */
package com.mycompany.sos.dao.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Address entity
 * 
 * @author colin
 *
 */
@Entity
@Table(name = "address")
public class AddressEntity {

	private int addressId;
	private int houseFlatNo;
	private String street;
	private String postCode;
	private String city;
	private String country;
	
	// 1 : M
	private Set<CustomerEntity> customers = new HashSet<CustomerEntity>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	public int getAddressId() {
		return addressId;
	}
	
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	@Column(name = "house_flat_no", nullable = false)
	public int getHouseFlatNo() {
		return houseFlatNo;
	}
	
	public void setHouseFlatNo(int houseFlatNo) {
		this.houseFlatNo = houseFlatNo;
	}
	
	@Column(name = "street", nullable = false, length = 255)
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(name = "postcode", nullable = false, length = 8)
	public String getPostCode() {
		return postCode;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	@Column(name = "city", nullable = false, length = 15)
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "country", nullable = false, length = 20)
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<CustomerEntity> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<CustomerEntity> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseFlatNo="
				+ houseFlatNo + ", street=" + street + ", postCode=" + postCode
				+ ", city=" + city + ", country=" + country + "]";
	}
	
	
}
