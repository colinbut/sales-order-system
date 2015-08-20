/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.sos.model.Customer;
import com.mycompany.sos.model.Item;
import com.mycompany.sos.model.Order;
import com.mycompany.sos.service.CustomerService;
import com.mycompany.sos.service.ItemService;
import com.mycompany.sos.service.OrderService;
import com.mycompany.sos.service.converters.OrderViewModelConverter;
import com.mycompany.sos.web.validators.OrderFormValidator;
import com.mycompany.sos.web.viewmodel.forms.CreateOrderForm;
import com.mycompany.sos.web.viewmodel.modeldata.OrderModel;

/**
 * {@link OrderController} class
 * 
 * @author colin
 */
@Controller
public class OrderController {

	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderService orderService;
	
	@Autowired
	@Qualifier("customerServiceImpl")
	private CustomerService customerService;
	
	@Autowired
	@Qualifier("itemServiceImpl")
	private ItemService itemService;
	
	@Autowired
	@Qualifier("orderFormValidator")
	private OrderFormValidator orderFormValidator;
	
	@Autowired
	private OrderViewModelConverter orderViewModelConverter;
	
	/**
	 * Shows the create order form page
	 * 
	 * @param modelMap model
	 * @return view name
	 */
	@RequestMapping(value = "/orders/create", method=RequestMethod.GET)
	public String showCreateOrdersForm(ModelMap modelMap) {
		modelMap.addAttribute("createOrderForm", new CreateOrderForm());
		
		List<Customer> customers = customerService.getCustomers();
		
		List<String> customerNames = new ArrayList<>();
		
		if(!customers.isEmpty()) {
			customers.stream().forEach(customer -> {
				customerNames.add(customer.getFirstName() + " " + customer.getLastName());
			});
		}
		
		List<Item> items = itemService.getItems();
		
		modelMap.addAttribute("customersList", customerNames);
		modelMap.addAttribute("itemsList", items);
		
		return "orders-createOrder";
	}
	
	/**
	 * Handles the submission of orders creation
	 * 
	 * @param createOrderForm the form backing object
	 * @param result Spring Framework's binding result object
	 * @return model and view
	 */
	@RequestMapping(value = "orders/createOrder", method = RequestMethod.POST)
	public ModelAndView createOrder(CreateOrderForm createOrderForm, BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		// custom validation
		orderFormValidator.validate(createOrderForm, result);
		
		if(result.hasErrors()) {
			modelAndView.setViewName("orders-createOrder");
		} else {
			Order order = orderViewModelConverter.convertOrderFormToOrder(createOrderForm);
			orderService.addOrder(order);
			modelAndView.setViewName("orders-createOrderSuccess");
		}
		
		return modelAndView;
	}
	
	/**
	 * Handles the orders list page
	 * 
	 * @param modelMap model
	 * @return view name
	 */
	@RequestMapping(value="/orders", method=RequestMethod.GET)
	public String listOrders(ModelMap modelMap) {
		
		List<Order> orders = orderService.getOrders();
		List<OrderModel> orderList = new ArrayList<>();
		
		if(!orders.isEmpty()) {
			orders.stream().forEach(order -> {
				OrderModel orderModel = orderViewModelConverter.convertOrderToOrderViewModel(order);
				orderList.add(orderModel);
			});
		}
		
		modelMap.addAttribute("orders", orderList);
		
		return "orders";
	}
	
}
