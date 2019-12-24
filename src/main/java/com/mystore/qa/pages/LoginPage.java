package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory or Object Repository:
	@FindBy(id="email")
	@CacheLookup	//this is useful to store this element in cache. so whenever we want to interact with this element then it will find from cache
	WebElement emailaddress;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signinbtn;
	
	@FindBy(id="SubmitCreate")
	WebElement createaccountbtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement logo;
	
	//Initializing Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions or Features:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatelogo() {
		return logo.isDisplayed();
	}
	
	public MyAccountPage login(String emailadd, String pwd) {
		
		emailaddress.sendKeys(emailadd);
		password.sendKeys(pwd);
		signinbtn.click();
		
		return new MyAccountPage();
		
	}
	
}
