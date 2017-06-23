package com.orange;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.LoginPage;
import com.orangehrm.OrangeHRM;

public class NegativeLoginTest {

	private LoginPage onLoginPage;

	@BeforeMethod
	public void setup() {
		onLoginPage = OrangeHRM.openOnLoginPage();
	}

	@Test
	public void testNumberOne() {
		String expectedInvalidCredentialsMessage = "Invalid credentials";

		onLoginPage.typeUsername("Admin2");
		onLoginPage.typePassword("123456789");
		onLoginPage.clickLoginButton();

		String actualInvalidCredentialsMessage = onLoginPage.readErrorMessage();

		Assert.assertTrue(actualInvalidCredentialsMessage.contains(expectedInvalidCredentialsMessage));
	}

	@Test
	public void testNumberTwo() {
		String invalidMessage = "Invalid credentials";

		onLoginPage.typeUsername("1234567890987654321");
		onLoginPage.typePassword("1234567890987654321");
		onLoginPage.clickLoginButton();

		String invalidMessageDisplayed = onLoginPage.readErrorMessage();

		Assert.assertTrue(invalidMessageDisplayed.contains(invalidMessage));
	}

	@AfterMethod(alwaysRun = true)
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
