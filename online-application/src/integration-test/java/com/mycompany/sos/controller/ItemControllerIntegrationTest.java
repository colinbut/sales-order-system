/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.controller;

import com.mycompany.sos.IntegrationTestCategory;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * {@link ItemControllerIntegrationTest} test class
 *
 * @author colin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
			//"file:src/main/webapp/WEB-INF/application-context.xml",
			// "file:src/main/webapp/WEB-INF/application-datasource.xml",
			//"file:src/main/webapp/WEB-INF/application-web.xml"
			"file:src/integration-test/resources/META-INF/test-context.xml"
		}
)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@WebAppConfiguration
@Category(IntegrationTestCategory.class)
public class ItemControllerIntegrationTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testShowItemsList() throws Exception {
		mockMvc.perform(get("/items"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("items"))
				.andExpect(view().name("items/items"));
	}

    @Test
    public void testShowCreateItemPage() throws Exception {
        mockMvc.perform(get("/items/create"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("createItemForm"))
            .andExpect(view().name("items/items-create"));
    }
}
