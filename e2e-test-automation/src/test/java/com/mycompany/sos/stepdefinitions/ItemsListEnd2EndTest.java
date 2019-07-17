/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.stepdefinitions;

import com.mycompany.sos.End2EndCategory;
import com.mycompany.sos.web.ItemController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.experimental.categories.Category;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.*;

/**
 * {@link ItemsListEnd2EndTest} test class
 *
 * @author colin
 */
@Category(End2EndCategory.class)
public class ItemsListEnd2EndTest {

    ItemController itemController = new ItemController();

    String viewName;

    @Given("^i am on the customers list page$")
    public void i_am_on_the_customers_list_page() throws Throwable {
        //
    }

    @When("^i click on the 'items' tab$")
    public void i_click_on_the_items_tab() throws Throwable {
        viewName = itemController.showItemsList(new ModelMap());
    }

    @Then("^i should be presented with the items list page$")
    public void i_should_be_presented_with_the_items_list_page() throws Throwable {
        assertEquals(viewName, "items");
    }
}
