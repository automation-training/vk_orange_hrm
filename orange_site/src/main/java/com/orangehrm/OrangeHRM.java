package com.orangehrm;

import org.openqa.selenium.WebDriver;

public class OrangeHRM {

	private static WebDriver driver;

	public OrangeHRM() {
	}

	public static LoginPage openOnLoginPage() {
		driver = Browser.open();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		return new LoginPage(driver);
	}

	public static void close() {
		if (driver != null)
			driver.quit();
		driver = null;
	}

}
