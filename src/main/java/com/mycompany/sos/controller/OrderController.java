/**
 * 
 */
package com.mycompany.sos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.sos.model.web.forms.CreateOrderForm;
import com.mycompany.sos.service.OrderService;

/**
 * OrderController class
 * 
 * @author colin
 *
 */
@Controller
public class OrderController {

	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderService orderService;
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public void createOrder(CreateOrderForm createOrderForm) {
		
	}
	
}
