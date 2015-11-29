/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * {@link CustomerPaymentDetail} class
 * 
 * CustomerPaymentDetail entity
 * 
 * @author colin
 *
 */
@Entity
@Table(name = "customer_payment_details")
public class CustomerPaymentDetail {

	private int paymentDetailsId;
	
	@NotNull(message = "{error.null.customerReference}")
	@NotBlank(message = "{error.blank.customerReference}")
	@NotEmpty(message = "{error.empty.customerReference}")
	@Size(min = 1, max = 20, message = "{error.size.customerReference}")
	private String customerReference;
	
	@NotNull(message = "{error.null.cardNo}")
	@NotBlank(message = "{error.blank.cardNo}")
	@NotEmpty(message = "{error.empty.cardNo}")
	@Size(max = 16, min = 16, message = "{error.invalid.size.cardNo}")
	@Pattern(regexp = "[0-9]*", message = "{error.invalid.cardNo}")
	private String cardNo;
	
	@NotNull(message = "{error.null.expDate}")
	@Future(message = "{error.future.expDate}")
	private Date cardExpiryDate;
	
	
	private Customer customer;
	
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "customer_card_expiry_date", nullable = false, length = 5)
	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}
	
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "CustomerPaymentDetails [paymentDetailsId=" + paymentDetailsId
				+ ", customerReference=" + customerReference + ", cardNo="
				+ cardNo + ", cardExpiryDate=" + cardExpiryDate + "]";
	}
	
	
}
