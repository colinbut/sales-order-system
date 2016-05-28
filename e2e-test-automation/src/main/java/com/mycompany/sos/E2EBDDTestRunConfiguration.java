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
 * {@link E2EBDDTestRunConfiguration} class
 * 
 * @author colin
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/e2e-test/resources/items-list.feature")
public class E2EBDDTestRunConfiguration {
}
