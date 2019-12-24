package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.qa.base.TestBase;

public class AddAddressPage extends TestBase{
	
	@FindBy(xpath="//a[@href=\"http://automationpractice.com/index.php?controller=addresses\"]//span//i")
	WebElement backtoyouraddresses;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(xpath="//select[@id=\"id_state\"]")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement postalcode;
	
	@FindBy(id="phone")
	WebElement homephone;
	
	@FindBy(id="phone_mobile")
	WebElement mobilephone;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement addresstitle;
	
	@FindBy(xpath="//button[@id=\"submitAddress\"]")
	WebElement saveaddressbtn;
	
	public AddAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAddAdressPage() {
		return backtoyouraddresses.isDisplayed();
	}
	
	public MyAddressesPage addAddress(String add1, String city1, String state1, int pcode, int hphone, int mphone, String addtitle) {
		
		address1.sendKeys(add1);
		city.sendKeys(city1);
		Select select = new Select(state);
		select.selectByVisibleText(state1);
		postalcode.sendKeys(String.valueOf(pcode));
		homephone.sendKeys(String.valueOf(hphone));
		mobilephone.sendKeys(String.valueOf(mphone));
		addresstitle.sendKeys(addtitle);
		saveaddressbtn.click();
		
		return new MyAddressesPage();
	}
	
}
