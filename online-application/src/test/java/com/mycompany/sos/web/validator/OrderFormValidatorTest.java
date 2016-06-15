/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.web.validator;

import com.mycompany.sos.UnitTestCategory;
import com.mycompany.sos.model.Order;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

/**
 * {@link OrderFormValidatorTest} test class
 *
 * @author colin
 */
@Category(UnitTestCategory.class)
public class OrderFormValidatorTest {

	private OrderFormValidator orderFormValidator = new OrderFormValidator();

	@Test
	@Ignore
	public void testValidate() {
		Order createOrderForm = new Order();
		Errors errors = new BeanPropertyBindingResult(null, "");
		orderFormValidator.validate(createOrderForm, errors);
	}
}
