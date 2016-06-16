/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
 */
@Entity
@Table(name = "customer_payment_details")
@Getter
@Setter
@ToString(exclude = "customer")
@EqualsAndHashCode(exclude = "customer")
@NoArgsConstructor
public class CustomerPaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_payment_details_id")
	private int paymentDetailsId;

	@NotNull(message = "{error.null.customerReference}")
	@NotBlank(message = "{error.blank.customerReference}")
	@NotEmpty(message = "{error.empty.customerReference}")
	@Size(min = 1, max = 20, message = "{error.size.customerReference}")
    @Column(name = "customer_reference", nullable = false, length = 255)
	private String customerReference;

	@NotNull(message = "{error.null.cardNo}")
	@NotBlank(message = "{error.blank.cardNo}")
	@NotEmpty(message = "{error.empty.cardNo}")
	@Size(max = 16, min = 16, message = "{error.invalid.size.cardNo}")
	@Pattern(regexp = "[0-9]*", message = "{error.invalid.cardNo}")
    @Column(name = "customer_card_number", nullable = false, length = 16)
	private String cardNo;

	@NotNull(message = "{error.null.expDate}")
	@Future(message = "{error.future.expDate}")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "customer_card_expiry_date", nullable = false, length = 5)
	private Date cardExpiryDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

}
