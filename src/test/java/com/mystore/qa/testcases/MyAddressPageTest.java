package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.AddAddressPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.MyAddressesPage;

public class MyAddressPageTest extends TestBase{
	
	LoginPage loginpage;
	MyAccountPage myaccount;
	MyAddressesPage myaddresses;
	
	public MyAddressPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		myaccount = loginpage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
		myaddresses = myaccount.clickonMyAddresses();
	}
		
	@Test(priority = 1)
	public void validateMyAddressTitleTest() {
		String addressTitle = myaddresses.validateAddressTitle();
		Assert.assertEquals(addressTitle, "Addresses - My Store");
	}
	
	@Test(priority = 2)
	public AddAddressPage clickonAddNewAddress() {
		myaddresses.addNewAddress();
		return new AddAddressPage();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
