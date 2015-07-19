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
import org.springframework.web.servlet.ModelAndView;

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
	
	/**
	 * Shows the create customer form page
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/customers/create", method = RequestMethod.GET)
	public String showCreateCustomerFormPage(ModelMap modelMap) {
		modelMap.addAttribute("createCustomerForm", new CreateCustomerForm());
		return "customers-createCustomer";
	}
	
	/**
	 * Handles the create customer form submit
	 * 
	 * @param createCustomerForm
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/customers/createCustomer", method = RequestMethod.POST)
	public ModelAndView createCustomer(
			@ModelAttribute("createCustomerForm") CreateCustomerForm createCustomerForm,
			BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println(createCustomerForm);
		
		Customer customer = new Customer();
		customer.setFirstName(createCustomerForm.getFirstName());
		customer.setLastName(createCustomerForm.getLastName());
		customer.setDateOfBirth(createCustomerForm.getDateOfBirth());
		customer.setEmail(createCustomerForm.getEmailAddress());
		
		if(customerService.addCustomer(customer)) {
			modelAndView.addObject("submittedCustomerForm", createCustomerForm);
			modelAndView.setViewName("customers-createCustomerSuccess");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listCustomers(ModelMap modelMap) {
		
		List<Customer> customers = customerService.getCustomers();
		
		for(Customer customer : customers ) {
			System.out.println(customer);
		}
		
		
		modelMap.addAttribute("customers", customers);
		
		return "/";
	}
}
