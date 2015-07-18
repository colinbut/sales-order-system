/**
 * 
 */
package com.mycompany.sos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.sos.model.entities.Customer;
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
	
	@RequestMapping(value = "/customers/create", method = RequestMethod.GET)
	public String showCreateCustomerFormPage(ModelMap modelMap) {
		modelMap.addAttribute("createCustomerForm", new CreateCustomerForm());
		return "customers-createCustomer";
	}
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public String createCustomer(
			@ModelAttribute("createCustomerForm") CreateCustomerForm createCustomerForm,
			BindingResult result) {
		
		
		
		return "";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCustomers(ModelMap modelMap) {
		
		List<Customer> customers = customerService.getCustomers();
		
		modelMap.addAttribute("customers", customers);
		
		return "/";
	}
}
