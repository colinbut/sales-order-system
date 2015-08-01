/**
 * 
 */
package com.mycompany.sos.web;

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

import com.mycompany.sos.model.Address;
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.model.CustomerPaymentDetails;
import com.mycompany.sos.service.CustomerService;
import com.mycompany.sos.web.viewmodel.forms.CreateCustomerForm;
import com.mycompany.sos.web.viewmodel.modeldata.CustomerModel;

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
		
		if(logger.isTraceEnabled()) {
			logger.trace("Converting form backing object to domain object (DTO)");
		}
		
		Customer customer = new Customer();
		customer.setFirstName(createCustomerForm.getFirstName());
		customer.setLastName(createCustomerForm.getLastName());
		customer.setDateOfBirth(createCustomerForm.getDateOfBirth());
		customer.setEmail(createCustomerForm.getEmailAddress());
		
		Address address = new Address();
		address.setHouseFlatNo(createCustomerForm.getHouseFlatNo());
		address.setPostCode(createCustomerForm.getPostcode());
		address.setStreet(createCustomerForm.getStreet());
		address.setCountry(createCustomerForm.getCountry());
		address.setCity(createCustomerForm.getCity());
		
		CustomerPaymentDetails customerPaymentDetails = new CustomerPaymentDetails();
		customerPaymentDetails.setCardNo(createCustomerForm.getCardNo());
		customerPaymentDetails.setCardExpiryDate(createCustomerForm.getExpDate());
		customerPaymentDetails.setCustomerReference(createCustomerForm.getCustomerReference());
		
		customer.setAddress(address);
		customer.setCustomerPaymentDetails(customerPaymentDetails);
				
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
