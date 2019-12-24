package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class MyAccountPage extends TestBase {
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement imglogo;
		
	@FindBy(xpath="//h1[contains(text(),'My account')]")
	WebElement myaccountlabel;	

	@FindBy(id="search_query_top")
	WebElement searchtextbox;
	
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchimg;
	
	@FindBy(xpath = "//a[@title=\"Addresses\"]")
	WebElement myaddress;
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateMyAccountTitle() {
		return driver.getTitle();		
	}
	
	public String validateMyAccountLabel() {
		return myaccountlabel.getText();
	}
	
	public boolean validateSearchTextBox() {
		return searchtextbox.isDisplayed();
	}

	public SearchPage validateSeachBox(String text) {
		searchtextbox.sendKeys(text);
		searchimg.click();
		return new SearchPage();
	}
	
	public MyAddressesPage clickonMyAddresses() {
		myaddress.click();
		return new MyAddressesPage();
	}
	
}
