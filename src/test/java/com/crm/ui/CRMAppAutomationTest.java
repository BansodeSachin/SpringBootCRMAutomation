package com.crm.ui;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.pageobjects.AddCustomerPage;
import com.crm.pageobjects.CustomerListPage;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class CRMAppAutomationTest extends Base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test
	public void addCRMCustomer() throws InterruptedException, IOException {
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		
		CustomerListPage c = new CustomerListPage(driver);
		
		c.getAddButton().click();
		
		Thread.sleep(2000);
		
		AddCustomerPage ac = new AddCustomerPage(driver);
		
		ac.getFirstName().sendKeys("AutoAddFirstName1");
		Thread.sleep(1000);
		
		ac.getLastName().sendKeys("AutoAddLastName1");
		Thread.sleep(1000);
		
		ac.getEmail().sendKeys("AutoAddEmail1");
		Thread.sleep(1000);
		
		ac.getSubmitButton().click();
		
		System.out.println("User Added Successfully...");
		
	}
	
	@Test
	public void updateCRMCustomer() throws InterruptedException, IOException {
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		
		CustomerListPage c = new CustomerListPage(driver);
		
		c.getUpdateLink(15).click();
		
		Thread.sleep(2000);
		
		AddCustomerPage ac = new AddCustomerPage(driver);
		
		ac.getFirstName().clear();
		ac.getFirstName().sendKeys("AutoUpdateFirstName1");
		Thread.sleep(1000);
		ac.getLastName().clear();
		ac.getLastName().sendKeys("AutoUpdateLastName1");
		Thread.sleep(1000);
		ac.getEmail().clear();
		ac.getEmail().sendKeys("AutoUpdateEmail1");
		Thread.sleep(1000);
		ac.getSubmitButton().click();
		
		System.out.println("User Updated Successfully...");
		
	}
	
	@Test
	public void deleteCRMCustomer() throws InterruptedException, IOException {
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		
		CustomerListPage c = new CustomerListPage(driver);
		
		c.getDeleteLink(6).click();
		
		Thread.sleep(2000);
		
		System.out.println("CRM UI Update Link Testing Started...");
		
		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().dismiss();
		
		//driver.switchTo().alert().accept();
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}