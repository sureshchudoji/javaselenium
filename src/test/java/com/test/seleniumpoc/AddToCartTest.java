package com.test.seleniumpoc;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.pageObjects.LandingPage;
import com.test.pageObjects.LoginPage;
import com.test.pageObjects.HomePage;

import com.test.resources.base;

public class AddToCartTest extends base {

	public WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test
	public void HomePage() throws IOException, InterruptedException {

		// Create Page Objects
		landingPage = new LandingPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);

		landingPage.getLogin().click();

		loginPage.getUsername().sendKeys("storedemo@test.com");
		loginPage.getPassword().sendKeys("Password@123");
		loginPage.getLogin().click();

		Assert.assertTrue(homePage.getLogout().isDisplayed());
		Assert.assertEquals("STORE", homePage.getPageTitle());

		homePage.getLogout().click();

		Assert.assertTrue(landingPage.getLogin().isDisplayed());
		Assert.assertEquals(false, true);
	}

	@AfterTest
	public void quit() throws IOException {

		driver.close();
	}

}
