/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.sos.web.viewmodel.forms.CreateOrderForm;

/**
 * OrderFormValidator class
 * 
 * @author colin
 *
 */
@Component("orderFormValidator")
public class OrderFormValidator implements Validator{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supports(Class<?> c1) {
		return CreateOrderForm.class.equals(c1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(Object object, Errors errors) {
		
		CreateOrderForm orderForm = (CreateOrderForm) object;
		
		String customer = orderForm.getCustomer();
		
		if(customer == null || StringUtils.isEmpty(customer)) {
			errors.rejectValue("customer", "error.empty.customer");
		}
	}

}
