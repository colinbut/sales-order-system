/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.sos.model.CustomerEntity;
import com.mycompany.sos.service.CustomerService;

/**
 * {@link CustomerDetailsController} class
 * 
 * @author colin
 *
 */
@Controller
public class CustomerDetailsController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "customers/{customerId}", method = RequestMethod.GET)
	public String getCustomerDetailsPage(@PathVariable("customerId") String customerId, Model model) {
		CustomerEntity customer = customerService.findCustomerByCustomerId(Integer.parseInt(customerId));
		model.addAttribute("customer", customer);
		return "customerDetails";
	}
}
