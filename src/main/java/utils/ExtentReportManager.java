package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getReportInstance() {

		if (extent == null) {

			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");

			extent = new ExtentReports();

			extent.attachReporter(sparkReporter);

			extent.setSystemInfo("Project", "BStackDemo Automation");
			extent.setSystemInfo("Tester", "Leelaa");
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("Framework", "Selenium + TestNG");
		}

		return extent;
	}
}