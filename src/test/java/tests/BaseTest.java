package tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import utils.ConfigReader;
import utils.ExtentReportManager;
import utils.ScreenshotUtils;
import utils.WebDriverFactory;

public class BaseTest {

	protected WebDriver driver;
	protected ExtentTest test;

	@BeforeMethod
	public void setUp(Method method) {

		ConfigReader.loadProperties();

		driver = WebDriverFactory.createDriver();

		driver.manage().window().maximize();

		driver.get(ConfigReader.getProperty("url"));

		test = ExtentReportManager.getReportInstance().createTest(method.getName());
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {

			test.pass("Test Passed");

		} else if (result.getStatus() == ITestResult.FAILURE) {

			test.fail("Test Failed");

			// Capture screenshot for failed test
			String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getMethod().getMethodName());

			if (screenshotPath != null) {

				test.addScreenCaptureFromPath(screenshotPath);
			}

		} else if (result.getStatus() == ITestResult.SKIP) {

			test.skip("Test Skipped");
		}

		if (driver != null) {
			driver.quit();
		}

		ExtentReportManager.getReportInstance().flush();
	}
}