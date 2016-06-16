/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import com.mycompany.sos.UnitTestCategory;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;

/**
 * {@link LoginControllerTest} test class
 *
 * @author colin
 */
@Category(UnitTestCategory.class)
public class LoginControllerTest {

    private LoginController loginController = new LoginController();

    @Test
    public void testLogin() {
        ModelAndView modelAndView = loginController.login(null,null);
        assertEquals("login/login", modelAndView.getViewName());
    }
}
