package com.orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage {

	@FindBy(xpath = "//input[@id ='txtUsername']")
	private WebElement usernameField;

	@FindBy(css = "#txtPassword")
	private WebElement passwordField;

	@FindBy(id = "btnLogin")
	private WebElement loginButton;

	private WebElement spanMessage;

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@Step("Type username <{0}>")
	public void typeUsername(String username) {
		usernameField.click();
		waitFor(1);
		usernameField.sendKeys(username);
	}

	@Step("Type password <{0}>")
	public void typePassword(String password) {
		passwordField.click();
		passwordField.sendKeys(password);
	}

	@Step
	public void clickLoginButton() {
		loginButton.click();
	}

	public boolean isLoginButtonEnabled() {
		return loginButton.isEnabled();
	}

	@Step("Login using username <{0}>, password <{1}>")
	public DashboardPage loginUsing(String username, String password) {
		typeUsername(username);
		typePassword(password);
		clickLoginButton();
		return new DashboardPage(driver);
	}

	@Step
	@Attachment("Error")
	public String readErrorMessage() {
		String invalidCredentialsMessage = spanMessage.getText();
		return invalidCredentialsMessage;
	}

	@Step("Read current URL")
	@Attachment("URL")
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	private void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {

		}
	}

}
