package com.test.seleniumpoc;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.pageObjects.LandingPage;
import com.test.pageObjects.LoginPage;
import com.test.pageObjects.HomePage;

import com.test.resources.base;

public class LoginTest extends base {

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void HomePage() throws IOException, InterruptedException {
		
		//BeforeTest steps
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		//Create Page Objects
		landingPage = new LandingPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		landingPage.getLogin().click();
		
		loginPage.getUsername().sendKeys("storedemo@test.com");
		loginPage.getPassword().sendKeys("Password@123");
		loginPage.getLogin().click();
		
		
		
		Assert.assertTrue(homePage.getLogout().isDisplayed());
		Assert.assertEquals("STORE", homePage.getPageTitle());
	}

}
