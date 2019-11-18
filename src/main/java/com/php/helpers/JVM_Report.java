package com.php.helpers;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

public class JVM_Report {

	public static void generateCucumberReport(String jsonPath) {
		try {
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();

			String dateTime = date.toString() + "-"
					+ time.toString().replaceAll(":", "-").substring(0, time.toString().length() - 4);
			String path = System.getProperty("user.dir") + "\\src\\test\\resource\\Reports\\cucumber-jvm-report"
					+ dateTime + "\\";
			File reportPath = new File(path);
			List<String> jsonReport = new ArrayList<String>();
			jsonReport.add(jsonPath);

			String buildNumber = "1";
			String projectName = "Cucumber Automation";
			Configuration configuration = new Configuration(reportPath, projectName);
			// optional configuration - check javadoc for details
			configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
			// do not make scenario failed when step has status SKIPPED
			// configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
			configuration.setBuildNumber(buildNumber);
			// addidtional metadata presented on main page
			configuration.addClassifications("Platform", "Desktop");
			configuration.addClassifications("Browser",
					FileReaderManager.getInstance().getConfigReader().getBrowserName());

//			// optionally add metadata presented on main page via properties file
//			List<String> classificationFiles = new ArrayList<String>();
//			classificationFiles.add("properties-1.properties");
//			classificationFiles.add("properties-2.properties");
//			configuration.addClassificationFiles(classificationFiles);

			ReportBuilder reportBuilder = new ReportBuilder(jsonReport, configuration);
			Reportable result = reportBuilder.generateReports();
			System.out.println("Report generarted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
