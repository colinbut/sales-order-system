Feature: Order listing

	Background: Given i am an application user
	
		Scenario: viewing orders list
		
			Given i am on the customers list page
			When i click on the 'Orders' tab
			Then i should be redirected to the orders list page