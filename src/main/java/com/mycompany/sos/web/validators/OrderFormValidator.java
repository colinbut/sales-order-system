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

import com.mycompany.sos.model.OrderEntity; 

/**
 * {@link OrderFormValidator} class
 * 
 * @author colin
 *
 */
@Component("orderFormValidator")
public class OrderFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> c1) {
		return OrderEntity.class.equals(c1);
	}


	@Override
	public void validate(Object object, Errors errors) {
		
		OrderEntity orderEntity = (OrderEntity) object;
		
		String customer = orderEntity.getCustomer().toString();
		
		if(customer == null || StringUtils.isEmpty(customer)) {
			errors.rejectValue("customer", "error.empty.customer");
		}
	}

}
