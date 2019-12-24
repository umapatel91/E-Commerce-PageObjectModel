package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.AddAddressPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.MyAddressesPage;
import com.mystore.qa.util.TestUtil;

public class AddAddressPageTest extends TestBase {
	LoginPage loginpage;
	MyAccountPage myaccount;
	MyAddressesPage myaddresses;
	AddAddressPage addaddress;	

	String sheetName = "AddAddressTestData";
	
	
	public AddAddressPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		myaccount = loginpage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
		myaddresses = myaccount.clickonMyAddresses();
		addaddress = myaddresses.addNewAddress();
	}
	
	@Test(priority = 1)
	public void validateaddresspage() {
		Assert.assertTrue(addaddress.validateAddAdressPage());
		System.out.println("Add Address Page is displayed");
	}
	
	@DataProvider
	public Object[][] getAddressTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;	
	}

	@Test(priority = 2, dataProvider = "getAddressTestData")
	public void addAddressPageTest(String Address1, String City, String State, int Postalcode, int HomePhone, int MobilePhone, String AddressTitle) {
		myaddresses = addaddress.addAddress(Address1, City, State, Postalcode, HomePhone, MobilePhone, AddressTitle);
		String addressesTitle = myaddresses.validateAddressTitle();
		Assert.assertEquals(addressesTitle, "Addresses - My Store", "Address is not Save");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
