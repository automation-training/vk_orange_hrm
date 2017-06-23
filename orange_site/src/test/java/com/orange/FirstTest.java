package com.orange;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.Browser;

public class FirstTest {

	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = Browser.open();
		driver.get("http://opensource.demo.orangehrmlive.com/");
	}

	@Test(priority = 1)
	public void testNumberOne() {

		String invalidMessage = "Invalid credentials";

		WebElement findUserField = driver.findElement(By.xpath("//input[@id ='txtUsername']"));

		findUserField.click();

		waitFor(1);

		findUserField.sendKeys("Admin2");

		waitFor(2);

		WebElement findPasswordField = driver.findElement(By.id("txtPassword"));
		findPasswordField.click();
		findPasswordField.sendKeys("123456789");

		waitFor(2);

		WebElement enteringLoginButton = driver.findElement(By.id("btnLogin"));
		enteringLoginButton.click();

		WebElement spanMessage = driver.findElement(By.id("spanMessage"));

		String invalidMessageDisplayed = spanMessage.getText();

		Assert.assertTrue(invalidMessageDisplayed.contains(invalidMessage));

	}

	@Test(priority = 2)
	public void testNumberTwo() {

		String invalidMessage = "Invalid credentials";

		WebElement findUserField = driver.findElement(By.xpath("//input[@id ='txtUsername']"));

		findUserField.click();

		waitFor(2);

		findUserField.sendKeys("1234567890987654321");

		waitFor(2);

		WebElement findPasswordField = driver.findElement(By.id("txtPassword"));

		waitFor(2);
		findPasswordField.click();
		waitFor(2);
		findPasswordField.sendKeys("1234567890987654321");

		waitFor(2);

		WebElement enteringLoginButton = driver.findElement(By.id("btnLogin"));
		enteringLoginButton.click();

		WebElement spanMessage = driver.findElement(By.id("spanMessage"));

		String invalidMessageDisplayed = spanMessage.getText();

		Assert.assertTrue(invalidMessageDisplayed.contains(invalidMessage));

	}

	@Test(priority = 3)
	public void testNumberThree() {

		String searchQuery = "Chief Executive Officer (C.E.O)";

		WebElement findUserField = driver.findElement(By.xpath("//input[@id ='txtUsername']"));

		findUserField.click();

		waitFor(1);

		findUserField.sendKeys("Admin");

		waitFor(2);

		WebElement findPasswordField = driver.findElement(By.id("txtPassword"));
		findPasswordField.click();
		findPasswordField.sendKeys("admin");

		waitFor(2);

		WebElement enteringLoginButton = driver.findElement(By.id("btnLogin"));
		enteringLoginButton.click();

		waitFor(2);

		WebElement exitScenario = driver.findElement(By.id("welcome"));

		exitScenario.click();

		waitFor(1);

		// WebElement exitScenarioTwo =
		// driver.findElement(By.id("welcome-menu")).getAttribute("href");
		WebElement exitScenarioTwo = driver.findElement(By.linkText("Logout"));
		exitScenarioTwo.click();

	}

	@Test(priority = 4)
	public void testNumberFour() {

		String searchQuery = "Chief Executive Officer (C.E.O)";

		WebElement findUserField = driver.findElement(By.xpath("//input[@id ='txtUsername']"));

		findUserField.click();

		waitFor(1);

		findUserField.sendKeys("Admin");

		waitFor(2);

		WebElement findPasswordField = driver.findElement(By.id("txtPassword"));
		findPasswordField.click();
		findPasswordField.sendKeys("admin");

		waitFor(2);

		WebElement enteringLoginButton = driver.findElement(By.id("btnLogin"));
		enteringLoginButton.click();

		waitFor(2);

		WebElement welcomeMenuOpen = driver.findElement(By.id("menu_admin_viewAdminModule"));
		welcomeMenuOpen.click();

		WebElement menuJob = driver.findElement(By.id("menu_admin_Job"));
		menuJob.click();

		waitFor(2);

		WebElement menuPayGrades = driver.findElement(By.id("menu_admin_viewPayGrades"));
		menuPayGrades.click();

		waitFor(1);

		WebElement inputCheckboxOne = driver.findElement(By.id("ohrmList_chkSelectRecord_4"));
		inputCheckboxOne.click();

		waitFor(2);
		WebElement deleteButton = driver.findElement(By.id("btnDelete"));
		deleteButton.click();

		waitFor(2);

		WebElement buttonOk = driver.findElement(By.id("dialogDeleteBtn"));
		buttonOk.click();

		waitFor(3);

		WebElement welcomeMenuOpenTwo = driver.findElement(By.id("menu_admin_viewAdminModule"));
		welcomeMenuOpenTwo.click();

		WebElement menuJobTwo = driver.findElement(By.id("menu_admin_Job"));
		menuJobTwo.click();

		waitFor(2);

		WebElement menuPayGradesTwo = driver.findElement(By.id("menu_admin_viewPayGrades"));
		menuPayGradesTwo.click();

		waitFor(1);

		// WebElement searchWord =
		// driver.findElement(By.id("resultTable")).getText().contains("Chief
		// Executive Officer (C.E.O)");
		WebElement searchWord = driver.findElement(By.id("resultTable"));

		String actualResult = searchWord.getText();

		Assert.assertTrue(actualResult.contains(searchQuery));

		// Assert.assertFalse("Pass", searchWordTwo);

		/*
		 * if (searchWordTwo = true) {
		 * 
		 * System.out.println("����� ���� �������");
		 * 
		 * } else {
		 * 
		 * System.out.println("����� ���� ��������"); }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * // WebElement chooseAbout =
		 * driver.findElement(By.id("aboutDisplayLink")); //
		 * chooseAbout.click();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * /* waitFor(2);
		 * 
		 * driver.findElement(By.id("txtPassword"));
		 * 
		 * waitFor(2);
		 * 
		 * driver.findElement(By.id("btnLogin"));
		 * 
		 * waitFor(2);
		 */
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	private void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {

		}
	}
}
