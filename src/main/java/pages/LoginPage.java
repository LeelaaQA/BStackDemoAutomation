package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {

	private WebDriver driver;
	private WaitUtils wait;

	private By signInLink = By.id("signin");
	private By usernameDropdown = By.id("username");
	private By passwordDropdown = By.id("password");
	private By loginButton = By.id("login-btn");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}

	public void openLoginPage() {
		wait.waitForElementClickable(signInLink).click();
		wait.waitForElementVisible(usernameDropdown);
	}

	public void selectUsername(String user) {

		wait.waitForElementClickable(usernameDropdown).click();

		By userOption = By.xpath("//div[@id='username']//div[text()='" + user + "']");

		wait.waitForElementClickable(userOption).click();
	}

	public void selectPassword(String pass) {

		wait.waitForElementClickable(passwordDropdown).click();

		By passwordOption = By.xpath("//div[@id='password']//div[text()='" + pass + "']");

		wait.waitForElementClickable(passwordOption).click();
	}

	public void clickLogin() {
		wait.waitForElementClickable(loginButton).click();
	}

	public void login(String user, String pass) {
		selectUsername(user);
		selectPassword(pass);
		clickLogin();
	}
}