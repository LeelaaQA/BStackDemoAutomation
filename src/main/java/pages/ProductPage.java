package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class ProductPage {

	private WebDriver driver;
	private WaitUtils wait;

	private By firstProductAddToCart = By.cssSelector("[id='1'] .shelf-item__buy-btn");

	private By secondProductAddToCart = By.cssSelector("[id='2'] .shelf-item__buy-btn");

	private By thirdProductAddToCart = By.cssSelector("[id='3'] .shelf-item__buy-btn");

	private By cartCount = By.cssSelector(".bag__quantity");

	private By cartIcon = By.className("float-cart__content");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}

	public void addFirstProductToCart() {
		wait.waitForElementClickable(firstProductAddToCart).click();
	}

	public void addSecondProductToCart() {
		wait.waitForElementClickable(secondProductAddToCart).click();
	}

	public void addThirdProductToCart() {
		wait.waitForElementClickable(thirdProductAddToCart).click();
	}

	public int getCartCount() {
		return Integer.parseInt(wait.waitForElementVisible(cartCount).getText());
	}

	public void openCart() {
		wait.waitForElementClickable(cartIcon).click();
	}
}