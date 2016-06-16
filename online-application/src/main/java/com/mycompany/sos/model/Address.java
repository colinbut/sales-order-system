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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link Address} class
 *
 * Address entity
 *
 * @author colin
 */
@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "customers")
@ToString(exclude = "customers")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
	private int addressId;

	@NotNull(message = "{error.null.houseFlatNo}")
	@Min(value = 1, message = "{error.min.houseFlatNo}")
    @Column(name = "house_flat_no", nullable = false)
	private int houseFlatNo;

	@NotNull(message = "{error.null.street}")
	@NotBlank(message = "{error.blank.street}")
	@NotEmpty(message = "{error.empty.street}")
	@Pattern(regexp = "[a-zA-Z ]*", message = "{error.invalid.street}")
    @Column(name = "street", nullable = false, length = 255)
	private String street;

	@NotNull(message = "{error.null.postcode}")
	@NotBlank(message = "{error.blank.postcode}")
	@NotEmpty(message = "{error.empty.postcode}")
	@Pattern(regexp = "[a-zA-Z0-9 ]*", message = "{error.invalid.postcode}")
    @Column(name = "postcode", nullable = false, length = 8)
	private String postCode;

	@NotNull(message = "{error.null.city}")
	@NotBlank(message = "{error.blank.city}")
	@NotEmpty(message = "{error.empty.city}")
	@Pattern(regexp = "[a-zA-Z]*", message = "{error.invalid.city}")
    @Column(name = "city", nullable = false, length = 15)
	private String city;

	@NotNull(message = "{error.null.country}")
	@NotBlank(message = "{error.blank.country}")
	@NotEmpty(message = "{error.empty.country}")
	@Pattern(regexp = "[a-zA-Z]*", message = "{error.invalid.country}")
    @Column(name = "country", nullable = false, length = 20)
	private String country;

	// 1 : M
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	private Set<Customer> customers = new HashSet<>(0);

}
