/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.model;

import java.util.Date;

/**
 * {@link CustomerPaymentDetails} class
 * 
 * domain model object for representing customer payment details
 * 
 * @author colin
 *
 */
public class CustomerPaymentDetails {

	private int paymentDetailsId;
	private String customerReference;
	private String cardNo;
	private Date cardExpiryDate;
	
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
	
	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}
	
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	@Override
	public String toString() {
		return "CustomerPaymentDetails [paymentDetailsId=" + paymentDetailsId + ", customerReference="
				+ customerReference + ", cardNo=" + cardNo + ", cardExpiryDate=" + cardExpiryDate + "]";
	}
	
	
}
