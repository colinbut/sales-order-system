/**
 * 
 */
package com.mycompany.sos.dao.entities;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

/**
 * CustomerPaymentDetail entity
 * 
 * @author colin
 *
 */
@Entity
@Table(name = "customer_payment_details")
public class CustomerPaymentDetailEntity {

	private int paymentDetailsId;
	private String customerReference;
	private String cardNo;
	private String cardExpiryDate;
	private CustomerEntity customer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_payment_details_id")
	public int getPaymentDetailsId() {
		return paymentDetailsId;
	}
	
	public void setPaymentDetailsId(int paymentDetailsId) {
		this.paymentDetailsId = paymentDetailsId;
	}
	
	@Column(name = "customer_reference", nullable = false, length = 255)
	public String getCustomerReference() {
		return customerReference;
	}
	
	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}
	
	@Column(name = "customer_card_number", nullable = false, length = 16)
	public String getCardNo() {
		return cardNo;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	@Column(name = "customer_card_expiry_date", nullable = false, length = 5)
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public CustomerEntity getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "CustomerPaymentDetails [paymentDetailsId=" + paymentDetailsId
				+ ", customerReference=" + customerReference + ", cardNo="
				+ cardNo + ", cardExpiryDate=" + cardExpiryDate + "]";
	}
	
	
}
