package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

	@Test
	public void validLoginTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.openLoginPage();

		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		Assert.assertTrue(driver.getCurrentUrl().contains("bstackdemo"), "Valid login was not successful");
	}

	@Test
	public void lockedUserLoginTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.openLoginPage();

		loginPage.selectUsername("locked_user");
		loginPage.selectPassword(ConfigReader.getProperty("password"));

		loginPage.clickLogin();

		Assert.assertTrue(driver.getCurrentUrl().contains("/signin"), "Locked user was allowed to login");
	}

	@Test
	public void emptyCredentialsTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.openLoginPage();

		// Do not select username or password
		loginPage.clickLogin();

		Assert.assertTrue(driver.getCurrentUrl().contains("/signin"),
				"Login should not proceed with empty credentials");
	}
}