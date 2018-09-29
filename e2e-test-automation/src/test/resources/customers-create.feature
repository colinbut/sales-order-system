Feature: Creating new customers

As an application user,
I would like to be able to create new customers,
So that they can be managed by me

	Background: Given i am an application user

		Scenario: Show customers create page
		
			Given i am on the customer list page
			When i click on the 'create customer' button
			Then i should be taken to the create customer page
			
		Scenario: Submitting create customers form (no validation errors)
		
			Given i am on the create customer page
			When i fill in all the form fields with correct data
			And i click on the 'submit' button
			Then a new customer should be created in the system
			And i should be redirect to the create customer success page
			
		Scenario: Submitting create customers form (with validation errors)
		
			Given i am on the create customer page
			When i fill in some of the form fields
			And i click on the 'submit' button
			Then i should be presented with the form page with error messages next to the fields  
		