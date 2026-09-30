package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CheckoutPage {

	private WebDriver driver;
	private WaitUtils wait;

	private By firstName = By.id("firstNameInput");

	private By lastName = By.id("lastNameInput");

	private By address = By.id("addressLine1Input");

	private By state = By.id("provinceInput");

	private By postalCode = By.id("postCodeInput");

	private By submitButton = By.cssSelector("button[type='submit']");

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}

	public void enterFirstName(String value) {
		wait.waitForElementVisible(firstName).sendKeys(value);
	}

	public void enterLastName(String value) {
		wait.waitForElementVisible(lastName).sendKeys(value);
	}

	public void enterAddress(String value) {
		wait.waitForElementVisible(address).sendKeys(value);
	}

	public void enterState(String value) {
		wait.waitForElementVisible(state).sendKeys(value);
	}

	public void enterPostalCode(String value) {
		wait.waitForElementVisible(postalCode).sendKeys(value);
	}

	public void submitOrder() {
		wait.waitForElementClickable(submitButton).click();
	}

	public void completeCheckout(String firstName, String lastName, String address, String state, String postalCode) {

		enterFirstName(firstName);
		enterLastName(lastName);
		enterAddress(address);
		enterState(state);
		enterPostalCode(postalCode);
		submitOrder();
	}
}