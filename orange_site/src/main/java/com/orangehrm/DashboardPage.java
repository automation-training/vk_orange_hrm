package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	private WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String readWelcomeMessage() {
		WebElement welcomeMessageLabel = driver.findElement(By.id("welcome"));
		return welcomeMessageLabel.getText();
	}

	public LoginPage logout() {
		WebElement exitScenario = driver.findElement(By.id("welcome"));
		exitScenario.click();
		waitFor(1);
		WebElement exitScenarioTwo = driver.findElement(By.linkText("Logout"));
		exitScenarioTwo.click();
		return new LoginPage(driver);
	}

	private void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {

		}
	}

}
