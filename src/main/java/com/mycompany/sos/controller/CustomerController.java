/**
 * 
 */
package com.mycompany.sos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.sos.model.web.forms.CreateCustomerForm;
import com.mycompany.sos.service.CustomerService;

/**
 * @author colin
 *
 */
@Controller
public class CustomerController {

	@Autowired
	@Qualifier("customerServiceImpl")
	private CustomerService customerService;
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public String createCustomer(
			@ModelAttribute("createCustomerForm") CreateCustomerForm createCustomerForm) {
		
		
		
		return "";
	}
	
	@RequestMapping(value = "/listCustomers", method = RequestMethod.GET)
	public void listCustomers() {
		
	}
}
