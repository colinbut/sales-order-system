Feature: Viewing customers details

	Background: Given i am an application user
	
		Scenario: Navigating to customers details page
			
			Given i am on the customers list page
			When i click on one of the customers in the list
			Then i should be redirected to the customers details page 
			
		Scenario: Viewing customer details
		
			Given i am on the customer details page
			Then i should be able to view their details on screen