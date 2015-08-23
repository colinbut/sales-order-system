Feature: Create orders

As an application user,
I want to be able to create orders for customers,
So that customer can have orders

	Background: Given i am an application user
	
		Scenario: Showing create orders form
		
			Given i am on the customer details page
			And there are items in the system
			When i click on the 'Create orders' button
			Then i should be redirected to the create orders page
			
		Scenario: Creating orders for customers (no validation errors)
			
			Given i am on the create orders page
			When i fill in all the form fields
			Then a new order with list of items is created in the system
			And i should be redirected to the create orders success page
			
		Scenario: Creating orders for customers (with validation errors)
		
			Given i am on the create orders page
			When i fill in some of the form fields
			Then i should be presented with the form page with errors highlighted with error messages