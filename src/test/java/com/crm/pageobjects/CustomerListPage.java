package com.crm.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerListPage {

	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By popup = By.xpath("//button[text()='NO THANKS']");
	
	By addButton = By.xpath("//input[@value='Add Customer']");
	
	
	
	public CustomerListPage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}
	
	public WebElement getPopUp() {
		return driver.findElement(popup);
	}
	
	public List<WebElement> getPopUpSize() {
		return driver.findElements(popup);
	}
	
	public WebElement getUpdateLink(int customerId) {
		
		By updateLink = By.xpath("//a[contains(@href,'showFormForUpdate') and contains(@href,'customerId="+customerId+"')]");
		
		return driver.findElement(updateLink);
	}
	
	public WebElement getDeleteLink(int customerId) {
		
		By deleteLink = By.xpath("//a[contains(@href,'delete') and contains(@href,'customerId="+customerId+"')]");
		
		return driver.findElement(deleteLink);
	}
	
	public WebElement getAddButton() {
		return driver.findElement(addButton);
	}
}
