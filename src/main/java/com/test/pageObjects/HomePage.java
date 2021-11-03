package com.test.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Home Page element locators
	By home = By.xpath("(//a[@href='index.html'])[2]");
	By contact = By.xpath("(//a[text()='Contact']");	
	By aboutUs = By.xpath("//a[text()='About us']");
	By cart = By.xpath("//a[@id='cartur']");
	By logout = By.id("logout2");
	
	public WebElement getHome() {
		return new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(home));
	}
	
	public WebElement getContact() {
		return new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(contact));
	}
	
	public WebElement getAboutUs() {
		return new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(aboutUs));
	}
	
	public WebElement getCart() {
		return new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(cart));
	}
	
	public WebElement getLogout() {
		return new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(logout));
	}
	
	public String getPageTitle() {
		return driver.getTitle().toString();
	}
	
}
