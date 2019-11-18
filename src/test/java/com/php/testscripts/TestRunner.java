package com.php.testscripts;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.php.baseclass.BaseClass;
import com.php.helpers.FileReaderManager;
import com.php.helpers.JVM_Report;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty",
		"html:Reports", "junit:src\\test\\resource\\Reports\\cucumber.xml",
		"json:src\\test\\resource\\Reports\\cucumber.json" }, features = "src\\test\\java\\com\\php\\feature", glue = "com.php.stepdefinition", tags = {
				"@TC1", "~@Ignore" }, dryRun = false, monochrome = true, strict = false)

public class TestRunner {

	public static WebDriver driver;

	@BeforeClass
	public static void setup() throws Exception {

		String reportPath = System.getProperty("user.dir") + "\\src\\test\\resource\\Reports\\ExtentReport\\";

		System.setProperty("screenshot.dir", reportPath + "/Screenshots/");
		System.setProperty("extent.reporter.html.start", "true");
		System.setProperty("extent.reporter.spark.start", "true");
		System.setProperty("extent.reporter.html.out", reportPath + "/report.html");
		System.setProperty("extent.reporter.spark.out", reportPath + "/");

		driver = BaseClass.browser_LaunchIgnoreCase(FileReaderManager.getInstance().getConfigReader().getBrowserName());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
		System.out.println("Test Execution Completed");
		Thread.sleep(3000);
		JVM_Report.generateCucumberReport(
				System.getProperty("user.dir") + "\\src\\test\\resource\\Reports\\cucumber.json");

	}

}
