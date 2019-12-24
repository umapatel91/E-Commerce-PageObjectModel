package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAccountPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	MyAccountPage myaccountpage;
	
	//Initialization of Parent class Constructor
	public LoginPageTest() {
		super();	//It will called Parent class constructor
	}
	
	@BeforeMethod
	public void setup() {		
		initialization();		
		loginpage = new LoginPage();	//create object of LoginPage class because we want to access all methods of that class	
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title =loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login - My Store");
	}
	
	@Test(priority = 2)
	public void mystoreLogoTest() {
		boolean logo = loginpage.validatelogo();
		Assert.assertEquals(logo, true);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		myaccountpage = loginpage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
