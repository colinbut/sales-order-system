/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.web.validator;

import com.mycompany.sos.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * {@link OrderFormValidator} class
 *
 * @author colin
 */
@Component("orderFormValidator")
public class OrderFormValidator implements Validator{

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderFormValidator.class);

	@Override
	public boolean supports(Class<?> c1) {
		return Order.class.equals(c1);
	}


	@Override
	public void validate(Object object, Errors errors) {

		Order order = (Order) object;

		String customer = order.getCustomer().toString();

		LOGGER.debug(customer);

		if(customer == null || StringUtils.isEmpty(customer)) {
			errors.rejectValue("customer", "error.empty.customer");
		}
	}

}
