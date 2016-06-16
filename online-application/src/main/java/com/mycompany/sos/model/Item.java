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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link Item} class
 *
 * Item entity
 *
 * @author colin
 */
@Entity
@Table(name = "items")
@Getter
@Setter
@ToString(exclude = "orders")
@EqualsAndHashCode(exclude = "orders")
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
	private int itemId;

	@NotNull(message = "{error.null.itemName}")
    @Column(name = "item_name", nullable = false, length = 255)
	private String itemName;

	@NotNull(message = "{error.null.itemPrice}")
    @Column(name = "item_price", nullable = false)
	private BigDecimal itemPrice;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "items")
	private Set<Order> orders = new HashSet<>();

}
