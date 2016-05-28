/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import com.mycompany.sos.model.Customer;
import com.mycompany.sos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * {@link CustomerDetailsController} class
 *
 * @author colin
 */
@Controller
public class CustomerDetailsController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Displaying of the customer details page
	 *
	 * @param customerId id identifying the customer
	 * @param model Spring's framework model object
	 * @return view name
	 */
	@RequestMapping(value = "customers/{customerId}", method = RequestMethod.GET)
	public String getCustomerDetailsPage(@PathVariable("customerId") String customerId, Model model) {
		Customer customer = customerService.findCustomerByCustomerId(Integer.parseInt(customerId));
		model.addAttribute("customer", customer);
		return "customers/customerDetails";
	}
}
