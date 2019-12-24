 package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.SearchPage;

public class MyAccountPageTest extends TestBase {
	
	MyAccountPage myaccount;
	LoginPage loginpage;
	SearchPage seachpage;

	public MyAccountPageTest() {
		super();
	}	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		myaccount = loginpage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void validateMyAccountPageTitleTest() {
		String myaccounttitle = myaccount.validateMyAccountTitle();
		Assert.assertEquals(myaccounttitle, "My account - My Store", "My Account Page title is not matched");
	}
	
	@Test(priority = 2)
	public void validateLabelTest() {
		String myaccountlabel = myaccount.validateMyAccountLabel();
		Assert.assertEquals(myaccountlabel, "MY ACCOUNT", "My account label is incorrect");
	}
	
	@Test(priority = 3)
	public void validateSearchTextImageTest() {
		boolean searchimg = myaccount.validateSearchTextBox();
		Assert.assertTrue(searchimg);
	}
	
	@Test(priority = 4)
	public void validateSearchTest() {
		seachpage = myaccount.validateSeachBox(prop.getProperty("search"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
