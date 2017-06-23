package com.orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public Browser() {
	}

	public static WebDriver open() {
		WebDriver driver = startCrhomeDriver();

		return driver;
	}

	private static WebDriver startCrhomeDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	private static WebDriver startFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\lib\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
