package com.orange;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangehrm.DashboardPage;
import com.orangehrm.LoginPage;
import com.orangehrm.OrangeHRM;

public class LoginAsAdminTest {
	private WebDriver driver;
	private LoginPage onLoginPage;
	private DashboardPage onDashboardPage;
	
	@BeforeClass
	public void setup() {
		onLoginPage = OrangeHRM.openOnLoginPage();
	}

	@Test(priority = 1)
	public void testLoginFunction() {
		onDashboardPage = onLoginPage.loginUsing("Admin", "admin");

		waitFor(2);

		Assert.assertFalse(onDashboardPage.getCurrentUrl().contains("login"), "URL still contains 'login' part");
		Assert.assertTrue(onDashboardPage.getCurrentUrl().contains("dashboard"), "URL does not contain 'dashboard' part");
	}

	@Test(priority = 2, dependsOnMethods = "testLoginFunction")
	public void testWelcomeMessage() {
		String welcomeMessage = onDashboardPage.readWelcomeMessage();
		Assert.assertEquals(welcomeMessage, "Welcome Admin", "Incorrect welcome message");
	}

	@Test(priority = 3, dependsOnMethods = "testLoginFunction")
	public void testLogoutFunction() {
		onLoginPage = onDashboardPage.logout();

		Assert.assertTrue(onLoginPage.getCurrentUrl().contains("login"), "URL does not contain 'login' part");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		OrangeHRM.close();
	}

	private void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {

		}
	}

}
