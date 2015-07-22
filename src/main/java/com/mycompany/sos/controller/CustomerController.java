/**
 * 
 */
package com.mycompany.sos.controller;

import java.util.ArrayList;
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

import com.mycompany.sos.controller.viewmodel.forms.CreateCustomerForm;
import com.mycompany.sos.controller.viewmodel.modeldata.CustomerModel;
import com.mycompany.sos.dao.entities.CustomerEntity;
import com.mycompany.sos.model.Address;
import com.mycompany.sos.model.Customer;
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
		
		CustomerEntity customer = new CustomerEntity();
		customer.setFirstName(createCustomerForm.getFirstName());
		customer.setLastName(createCustomerForm.getLastName());
		customer.setDateOfBirth(createCustomerForm.getDateOfBirth());
		customer.setEmail(createCustomerForm.getEmailAddress());
		
		if(!customerService.addCustomer(customer)) {
			modelAndView.addObject("submittedCustomerForm", createCustomerForm);
			modelAndView.setViewName("customers-createCustomerSuccess");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listCustomers(ModelMap modelMap) {
		
		List<Customer> customers = customerService.getCustomers();
		List<CustomerModel> customerList = new ArrayList<>();
		
		for(Customer customer : customers) {
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
			
			customerList.add(customerModel);
		}
		
		modelMap.addAttribute("customers", customerList);
		
		return "customers";
	}
}
