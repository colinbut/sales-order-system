/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import com.mycompany.sos.model.Customer;
import com.mycompany.sos.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * {@link CustomerController} class
 *
 * @author colin
 */
@Controller
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	@Qualifier("customerServiceImpl")
	private CustomerService customerService;


	@InitBinder
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	/**
	 * Shows the create customer form page
	 *
	 * @param modelMap Spring's framework model map object containing the model data
	 * @return view name
	 */
	@RequestMapping(value = "/customers/create", method = RequestMethod.GET)
	public String showCreateCustomerFormPage(ModelMap modelMap) {
		modelMap.addAttribute("createCustomerForm", new Customer());
		logger.info("Accessed Create Customer page");
		logger.debug("Retrieved createCustomerForm");
		return "customers/customers-createCustomer";
	}

	/**
	 * Handles the create customer form submit
	 *
	 * @param customer the customer entity (used as form backing object also)
	 * @param result Spring's framework binding result object
	 * @return model and view object
	 */
	@RequestMapping(value = "/customers/createCustomer", method = RequestMethod.POST)
	public ModelAndView createCustomer(
			@Valid @ModelAttribute("createCustomerForm") Customer customer,
			BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();

		if(result.hasErrors()) {
			modelAndView.setViewName("customers/customers-createCustomer");
			return modelAndView;
		}

		logger.debug(customer.toString());

		customer.getCustomerPaymentDetail().setCustomer(customer);

		Customer customerAdded = customerService.addCustomer(customer);
		if(customerAdded != null) {
			logger.info("Successfully added customer");
			modelAndView.addObject("submittedCustomerForm", customer);
			modelAndView.setViewName("redirect:/customers/" + customer.getCustomerId());
		} else {
			logger.warn("Unable to add customer");
		}

		return modelAndView;
	}

	/**
	 * Handles customers list page
	 *
	 * @param modelMap Spring's framework model map object containing the model data
	 * @return view name
	 */
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listCustomers(ModelMap modelMap) {
		logger.info("Fetching customers list");
		List<Customer> customers = customerService.getCustomers();
		modelMap.addAttribute("customers", customers);
		return "customers/customers";
	}
}
