/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web.validators;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.web.viewmodel.forms.CreateOrderForm;

/**
 * {@link OrderFormValidatorTest} test class
 * 
 * @author colin
 *
 */
@Category(UnitTestCategory.class)
public class OrderFormValidatorTest {

	private OrderFormValidator orderFormValidator = new OrderFormValidator();
	
	@Test
	@Ignore
	public void testValidate() {
		CreateOrderForm createOrderForm = new CreateOrderForm();
		Errors errors = new BeanPropertyBindingResult(null, "");
		orderFormValidator.validate(createOrderForm, errors);
	}
}
