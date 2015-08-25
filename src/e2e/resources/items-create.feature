Feature: Creating items

As an application user,
I want to be able to create items
So that customers can choose items for their orders

	Background: Given i am an application user
	
		Scenario: show create items page
			
			Given i am on the items list page
			When i click on the 'items' tab
			Then i should be presented with the create items page
			And this form should allow me to insert the name, description & price of item
			
		Scenario:  creating new item (no validation errors)
		
			Given i am on the create items page
			When i fill in all the form fields
			Then a new item should be created in the system
			And i should be redirected to the create items success page
			
		Scenario:  creating new item (with validation errors)
		
			Given i am on the create items page
			When i fill in some the form fields
			Then i should be presented with the create items form page with errors messages highlighted