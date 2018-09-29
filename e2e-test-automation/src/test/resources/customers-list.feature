Feature: Customers list view

As an application user,
I would like to view a list of customers,
So that i can manage them

	Background: Given i am an application user
	
		Scenario: Show customers list page
	
			Given i am an application user
			When i request the customers list page via this URL <URL>
			Then i should be able to view the list of ALL customers on screen