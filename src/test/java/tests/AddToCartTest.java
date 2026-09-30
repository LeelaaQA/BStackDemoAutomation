package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class AddToCartTest extends BaseTest {

	@Test
	public void addSingleProductTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.openLoginPage();

		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		ProductPage productPage = new ProductPage(driver);

		productPage.addFirstProductToCart();

		int cartCount = productPage.getCartCount();

		Assert.assertEquals(cartCount, 1, "Cart count should be 1 after adding one product");
	}

	@Test
	public void addMultipleProductsTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.openLoginPage();

		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		ProductPage productPage = new ProductPage(driver);

		productPage.addFirstProductToCart();

		productPage.addSecondProductToCart();

		int cartCount = productPage.getCartCount();

		Assert.assertEquals(cartCount, 2, "Cart count should be 2 after adding two products");
	}

	@Test
	public void decreaseProductQuantityTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.openLoginPage();

		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		ProductPage productPage = new ProductPage(driver);

		// Add the same product twice
		productPage.addFirstProductToCart();
		productPage.addFirstProductToCart();

		Assert.assertEquals(productPage.getCartCount(), 2, "Cart count should be 2");

		CartPage cartPage = new CartPage(driver);

		cartPage.openCart();

		cartPage.decreaseQuantity();

		Assert.assertEquals(cartPage.getCartCount(), 1, "Cart count should decrease to 1");
	}

	@Test
	public void removeProductTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.openLoginPage();

		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		ProductPage productPage = new ProductPage(driver);

		// Add two different products
		productPage.addFirstProductToCart();
		productPage.addSecondProductToCart();

		Assert.assertEquals(productPage.getCartCount(), 2, "Cart count should be 2 before removing a product");

		CartPage cartPage = new CartPage(driver);

		cartPage.openCart();

		// Remove the selected product completely
		cartPage.removeProduct();

		Assert.assertEquals(cartPage.getCartCount(), 1, "Cart count should be 1 after removing one product");
	}
}