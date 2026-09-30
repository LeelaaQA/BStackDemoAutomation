package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

	@Test
	public void validCheckoutTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.openLoginPage();

		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		ProductPage productPage = new ProductPage(driver);

		productPage.addFirstProductToCart();

		CartPage cartPage = new CartPage(driver);

		cartPage.openCart();

		cartPage.clickCheckout();

		CheckoutPage checkoutPage = new CheckoutPage(driver);

		checkoutPage.completeCheckout("Leelaa", "Test", "Chennai", "Tamil Nadu", "600001");

		Assert.assertTrue(new utils.WaitUtils(driver).waitForUrlContains("/confirmation"),
				"Order confirmation page was not displayed");
	}

	@Test
	public void checkoutWithoutItemsTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.openLoginPage();

		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		CartPage cartPage = new CartPage(driver);

		cartPage.openCart();

		// Verify cart is empty
		Assert.assertEquals(cartPage.getCartCount(), 0, "Cart should be empty");

		// Verify empty cart message
		boolean emptyCartMessage = driver.findElements(By.xpath("//*[contains(text(),'Add some products in the bag')]"))
				.stream().anyMatch(element -> element.isDisplayed());

		Assert.assertTrue(emptyCartMessage, "Empty cart message was not displayed");
	}
}