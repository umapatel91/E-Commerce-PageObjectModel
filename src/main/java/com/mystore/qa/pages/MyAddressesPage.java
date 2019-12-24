package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class MyAddressesPage extends TestBase {
	
	@FindBy(xpath = "//a[@title=\"Add an address\"]")
	WebElement addAddress;
	
	public MyAddressesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateAddressTitle() {
		return driver.getTitle();
	}
	
	public AddAddressPage addNewAddress() {
		addAddress.click();
		return new AddAddressPage();
	}
	

}
