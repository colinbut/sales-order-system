/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

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

import com.mycompany.sos.model.Customer;
import com.mycompany.sos.service.CustomerService;
import com.mycompany.sos.service.converters.CustomerViewModelConverter;
import com.mycompany.sos.web.viewmodel.forms.CreateCustomerForm;
import com.mycompany.sos.web.viewmodel.modeldata.CustomerModel;

/**
 * CustomerController class
 * 
 * @author colin
 *
 */
@Controller
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	@Qualifier("customerServiceImpl")
	private CustomerService customerService;
	
	@Autowired
	private CustomerViewModelConverter customerViewModelConverter;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	/**
	 * Shows the create customer form page
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/customers/create", method = RequestMethod.GET)
	public String showCreateCustomerFormPage(ModelMap modelMap) {
		modelMap.addAttribute("createCustomerForm", new CreateCustomerForm());
		logger.info("Accessed Create Customer page");
		if(logger.isDebugEnabled()) {
			logger.debug("Retrieved createCustomerForm");
		}
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
			@Valid @ModelAttribute("createCustomerForm") 
			CreateCustomerForm createCustomerForm,
			BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result.hasErrors()) {
			modelAndView.setViewName("customers-createCustomer");
			return modelAndView;
		}
		
		if(logger.isDebugEnabled()) {
			logger.debug(createCustomerForm.toString());
		}
		
		if(logger.isTraceEnabled()) {
			logger.trace("Converting form backing object to domain object (DTO)");
		}
		
		Customer customer = customerViewModelConverter.convertCustomerFormToCustomer(createCustomerForm);
		
		if(customerService.addCustomer(customer)) {
			logger.info("Successfully added customer");
			modelAndView.addObject("submittedCustomerForm", createCustomerForm);
			modelAndView.setViewName("customers-createCustomerSuccess");
		} else {
			logger.warn("Unable to add customer");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listCustomers(ModelMap modelMap) {
		
		logger.info("Fetching customers list");
		
		List<Customer> customers = customerService.getCustomers();
		List<CustomerModel> customerList = new ArrayList<>();
		
		for(Customer customer : customers) {
			
			if(logger.isTraceEnabled()) {
				logger.trace("Converting Customer object to CustomerModel object");
			}
			
			CustomerModel customerModel = customerViewModelConverter.convertCustomerToCustomerView(customer);
			customerList.add(customerModel);
		}
		
		modelMap.addAttribute("customers", customerList);
		
		return "customers";
	}
}
