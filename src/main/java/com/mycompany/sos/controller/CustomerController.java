/**
 * 
 */
package com.mycompany.sos.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.sos.controller.viewmodel.forms.CreateCustomerForm;
import com.mycompany.sos.controller.viewmodel.modeldata.CustomerModel;
import com.mycompany.sos.dao.entities.AddressEntity;
import com.mycompany.sos.dao.entities.CustomerEntity;
import com.mycompany.sos.dao.entities.CustomerPaymentDetailEntity;
import com.mycompany.sos.model.Address;
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.service.CustomerService;

/**
 * @author colin
 *
 */
@Controller
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
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
			@ModelAttribute("createCustomerForm") CreateCustomerForm createCustomerForm,
			BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(logger.isDebugEnabled()) {
			logger.debug(createCustomerForm.toString());
		}
		
		/*
		 * should move following code to Service layer
		 */
		
		// initially create customer 
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setFirstName(createCustomerForm.getFirstName());
		customerEntity.setLastName(createCustomerForm.getLastName());
		customerEntity.setDateOfBirth(createCustomerForm.getDateOfBirth());
		customerEntity.setEmail(createCustomerForm.getEmailAddress());
		
		// make the customer payment details and link to customer
		CustomerPaymentDetailEntity customerPaymentDetailEntity = new CustomerPaymentDetailEntity();
		customerPaymentDetailEntity.setCardNo(createCustomerForm.getCardNo());
		customerPaymentDetailEntity.setCardExpiryDate(createCustomerForm.getExpDate());
		customerPaymentDetailEntity.setCustomerReference(createCustomerForm.getCustomerReference());
		customerPaymentDetailEntity.setCustomer(customerEntity);
		customerEntity.setCustomerPaymentDetail(customerPaymentDetailEntity);
		logger.debug(customerPaymentDetailEntity.toString());
		
		// make the address
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setHouseFlatNo(createCustomerForm.getHouseFlatNo());
		addressEntity.setStreet(createCustomerForm.getStreet());
		addressEntity.setPostCode(createCustomerForm.getPostcode());
		addressEntity.setCity(createCustomerForm.getCity());
		addressEntity.setCountry(createCustomerForm.getCountry());
		addressEntity.getCustomers().add(customerEntity);
		customerEntity.setAddress(addressEntity);
		
		logger.debug(addressEntity.toString());
		
		logger.debug(customerEntity.toString());
		
		if(customerService.addCustomer(customerEntity)) {
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
			
			CustomerModel customerModel = new CustomerModel();
			customerModel.setCustomerName(customer.getFirstName() + " " + customer.getLastName());
			customerModel.setDateOfBirth(customer.getDateOfBirth());
			customerModel.setEmailAddress(customer.getEmail());
			
			StringBuilder fullAddress = new StringBuilder();
			Address address = customer.getAddress();
			fullAddress.append(address.getHouseFlatNo())
						.append(" " + address.getStreet())
						.append(" " + address.getPostCode())
						.append(" " + address.getCity())
						.append(" " + address.getCountry());
			customerModel.setAddress(fullAddress.toString());
			
			if(logger.isDebugEnabled()) {
				logger.debug("CustomerModel object built - " + customerModel);
			}
			
			customerList.add(customerModel);
		}
		
		modelMap.addAttribute("customers", customerList);
		
		return "customers";
	}
}
