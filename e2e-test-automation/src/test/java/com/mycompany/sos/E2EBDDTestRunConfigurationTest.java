/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * {@link E2EBDDTestRunConfigurationTest} class
 * 
 * @author colin
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty","html:cucumber-html-reports",
    "json:cucumber-html-reports/cucumber.json" }, glue = "com.mycompany.sos.stepdefinitions", features = {"src/test/resources/items-list.feature"})
public class E2EBDDTestRunConfigurationTest {
}
