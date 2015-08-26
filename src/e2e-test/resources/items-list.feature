Feature: Listing items

As an application user,
I want to be able to see a list of items
So that i can see all the items in the system

	Background: Given i am an application user
	
		Scenario: show items list page
			
			Given i am on the customers list page
			When i click on the 'items' tab
			Then i should be presented with the items list page
		