/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.converters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.sos.model.Address;
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.model.CustomerPaymentDetails;
import com.mycompany.sos.web.viewmodel.forms.CreateCustomerForm;
import com.mycompany.sos.web.viewmodel.modeldata.CustomerModel;

/**
 * {@link CustomerViewModelConverter} class
 * 
 * Converts between View (ViewModel) and Model objects 
 * 
 * @author colin
 *
 */
@Component
public class CustomerViewModelConverter {
	
	static Logger logger = LoggerFactory.getLogger(CustomerViewModelConverter.class);
	
	public static Customer convertCustomerFormToCustomer(CreateCustomerForm createCustomerForm) {
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
		return customer;
	}
	
	public static CustomerModel convertCustomerToCustomerView(Customer customer) {
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
		
		return customerModel;
	}
}
