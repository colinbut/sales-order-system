/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.sos.model.Address;
import com.mycompany.sos.model.Order;
import com.mycompany.sos.service.CustomerService;
import com.mycompany.sos.web.viewmodel.forms.CreateOrderForm;
import com.mycompany.sos.web.viewmodel.modeldata.OrderModel;

/**
 * {@link OrderViewModelConverter} class
 * 
 * Converts between View (ViewModel) and Model objects 
 * 
 * @author colin
 *
 */
@Component
public class OrderViewModelConverter {

	@Autowired
	private CustomerService customerService;
	
	public Order convertOrderFormToOrder(CreateOrderForm createOrderForm) {
		Order order = new Order();
		//order.setItems(createOrderForm.getItems()); TODO: add method in item service
		//order.setCustomer(customerService.findCustomerByCustomerName(createOrderForm.getCustomer()));
		return new Order();
	}
	
	public OrderModel convertOrderToOrderViewModel(Order order) {
		OrderModel orderModel = new OrderModel();
		orderModel.setCustomer(order.getCustomer().getFirstName() + " " 			
						+ order.getCustomer().getLastName());
		
		orderModel.setOrderNo(order.getOrderId());
		
		StringBuilder fullAddress = new StringBuilder();
		Address address = order.getCustomer().getAddress();
		fullAddress.append(address.getHouseFlatNo())
					.append(" " + address.getStreet())
					.append(" " + address.getPostCode())
					.append(" " + address.getCity())
					.append(" " + address.getCountry());
		
		orderModel.setAddress(fullAddress.toString());
		return orderModel;
	}
}
