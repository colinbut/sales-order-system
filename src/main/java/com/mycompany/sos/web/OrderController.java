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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.sos.model.Address;
import com.mycompany.sos.model.Customer;
import com.mycompany.sos.model.Item;
import com.mycompany.sos.model.Order;
import com.mycompany.sos.service.CustomerService;
import com.mycompany.sos.service.ItemService;
import com.mycompany.sos.service.OrderService;
import com.mycompany.sos.web.validators.OrderFormValidator;
import com.mycompany.sos.web.viewmodel.forms.CreateOrderForm;
import com.mycompany.sos.web.viewmodel.modeldata.OrderModel;

/**
 * OrderController class
 * 
 * @author colin
 *
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
	private OrderFormValidator orderFormValidator;
	
	@RequestMapping(value = "/orders/create", method=RequestMethod.GET)
	public String showCreateOrdersForm(ModelMap modelMap) {
		modelMap.addAttribute("createOrderForm", new CreateOrderForm());
		
		List<Customer> customers = customerService.getCustomers();
		
		List<String> customerNames = new ArrayList<>();
		for(Customer customer : customers) {
			customerNames.add(customer.getFirstName() + " " + customer.getLastName());
		}
		
		List<Item> items = itemService.getItems();
		
		modelMap.addAttribute("customersList", customerNames);
		modelMap.addAttribute("itemsList", items);
		
		return "orders-createOrder";
	}
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public ModelAndView createOrder(CreateOrderForm createOrderForm, BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		// custom validation
		orderFormValidator.validate(createOrderForm, result);
		
		if(result.hasErrors()) {
			modelAndView.setViewName("orders-createOrder");
		} else {
			modelAndView.setViewName("orders-createOrderSuccess");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/orders", method=RequestMethod.GET)
	public String listOrders(ModelMap modelMap) {
		
		List<Order> orders = orderService.getOrders();
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		
		for(Order order : orders) {
			
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
			orderList.add(orderModel);
			
		}
		
		modelMap.addAttribute("orders", orderList);
		
		return "orders";
	}
	
}
