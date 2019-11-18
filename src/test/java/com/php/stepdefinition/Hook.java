package com.php.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.php.testscripts.TestRunner;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

	public static WebDriver driver = TestRunner.driver;
	public static Scenario scenario;

	

	@Before
	public void beforeHooks(Scenario scenario) {
		Hook.scenario=scenario;
	}

	@After
	public void afterHooks(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotAs, "image/png");

		}
	}

}
