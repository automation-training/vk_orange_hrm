package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void typeUsername(String username) {
		WebElement usernameField = driver.findElement(By.xpath("//input[@id ='txtUsername']"));
		usernameField.click();

		waitFor(1);

		usernameField.sendKeys(username);
	}

	public void typePassword(String password) {
		WebElement passwordField = driver.findElement(By.id("txtPassword"));
		passwordField.click();
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() {
		WebElement enteringLoginButton = driver.findElement(By.id("btnLogin"));
		enteringLoginButton.click();
	}

	public DashboardPage loginUsing(String username, String password) {
		typeUsername(username);
		typePassword(password);
		clickLoginButton();
		return new DashboardPage(driver);
	}

	public String readErrorMessage() {
		WebElement spanMessage = driver.findElement(By.id("spanMessage"));

		String invalidCredentialsMessage = spanMessage.getText();
		return invalidCredentialsMessage;
	}

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
