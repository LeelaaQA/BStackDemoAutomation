package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CartPage {

	private WebDriver driver;
	private WaitUtils wait;

	private By cartIcon = By.cssSelector(".bag");

	private By cartCount = By.cssSelector(".bag__quantity");

	private By minusButton = By.cssSelector(".float-cart__content .change-product-button");

	private By checkoutButton = By.cssSelector(".buy-btn");

	private By removeProductButton = By.cssSelector(".shelf-item__del");

	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}

	public void openCart() {
		wait.waitForElementClickable(cartIcon).click();
	}

	public int getCartCount() {
		return Integer.parseInt(wait.waitForElementVisible(cartCount).getText());
	}

	public void decreaseQuantity() {
		wait.waitForElementClickable(minusButton).click();
	}

	public void removeProduct() {
		wait.waitForElementClickable(removeProductButton).click();
	}

	public void clickCheckout() {
		wait.waitForElementClickable(checkoutButton).click();
	}
}