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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.sos.controller.viewmodel.forms.CreateOrderForm;
import com.mycompany.sos.controller.viewmodel.modeldata.OrderModel;
import com.mycompany.sos.model.Address;
import com.mycompany.sos.model.Order;
import com.mycompany.sos.service.OrderService;

/**
 * OrderController class
 * 
 * @author colin
 *
 */
@Controller
public class OrderController {

	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderService orderService;
	
	@RequestMapping(value = "/orders/create", method=RequestMethod.GET)
	public String showCreateOrdersForm(ModelMap modelMap) {
		modelMap.addAttribute("createOrderForm", new CreateOrderForm());
		return "orders-createOrder";
	}
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public void createOrder(CreateOrderForm createOrderForm) {
		
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
