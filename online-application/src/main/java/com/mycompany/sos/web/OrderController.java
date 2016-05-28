/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import com.mycompany.sos.model.Customer;
import com.mycompany.sos.model.Item;
import com.mycompany.sos.model.Order;
import com.mycompany.sos.service.CustomerService;
import com.mycompany.sos.service.ItemService;
import com.mycompany.sos.service.OrderService;
import com.mycompany.sos.web.validator.OrderFormValidator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * {@link OrderController} class
 *
 * @author colin
 */
@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

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


	/**
	 * Shows the create order form page
	 *
	 * @param modelMap Spring's framework model map object containing the model data
	 * @return view name
	 */
	@RequestMapping(value = "/orders/create", method=RequestMethod.GET)
	public String showCreateOrdersForm(ModelMap modelMap, @RequestParam("customerId") int customerId) {

		// get the customer
		Customer customer = customerService.findCustomerByCustomerId(customerId);
		Order order = new Order();
		order.setCustomer(customer);

		// get list of all available items
		List<Item> items = itemService.getItems();

		modelMap.addAttribute("createOrderForm", order);
		modelMap.addAttribute("itemsList", items);

		return "orders/orders-createOrder";
	}

	/**
	 * Handles the submission of orders creation
	 *
	 * @param order the order entity (also used as the form backing object)
	 * @param result Spring Framework's binding result object
	 * @return model and view
	 */
	@RequestMapping(value = "orders/createOrder", method = RequestMethod.POST)
	public ModelAndView createOrder(@ModelAttribute("createOrderForm") Order order, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();

		// custom validation
		orderFormValidator.validate(order, result);

		if(result.hasErrors()) {
			modelAndView.setViewName("orders/orders-createOrder");
		} else {
			if(orderService.addOrder(order)) {
				modelAndView.setViewName("orders-createOrderSuccess");
			}
			// TODO: need to decide what to do in event of unsuccessful order creation
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
		modelMap.addAttribute("orders", orders);
		return "orders/orders";
	}

}
