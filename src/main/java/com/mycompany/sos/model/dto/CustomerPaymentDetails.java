/**
 * 
 */
package com.mycompany.sos.model.dto;

import com.mycompany.sos.dao.entities.CustomerEntity;

/**
 * @author colin
 *
 */
public class CustomerPaymentDetails {

	private int paymentDetailsId;
	private String customerReference;
	private String cardNo;
	private String cardExpiryDate;
	private CustomerEntity customer;
	
	public int getPaymentDetailsId() {
		return paymentDetailsId;
	}
	public void setPaymentDetailsId(int paymentDetailsId) {
		this.paymentDetailsId = paymentDetailsId;
	}
	public String getCustomerReference() {
		return customerReference;
	}
	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
}
