package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	//page objects or locator
	private By emailId = By.name("username");
	private By pass = By.name("password");
	private By loginBtn = By.xpath("//input[@type='submit' and @value='Login']");
	private By crmLogo = By.xpath("(//img[@class='img-responsive'])[1]");
	private By signUpBtn = By.xpath("//a[contains(text(),'Sign Up')]");
	private By homeLink = By.xpath("//a[contains(text(),'Home')]");
	
	public boolean getHomeLinkSign() {
		return getElement(homeLink).isEnabled();
	}
	
	public Boolean getSignUpBtn() {
		return getElement(signUpBtn).isDisplayed();
	}

	public Boolean getCrmLogo() {
		return getElement(crmLogo).isDisplayed();
	}
	public LoginPage(WebDriver driver) {
		super(driver);
		}


	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public WebElement getPass() {
		return getElement(pass);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	public String getLoginPageTitle() {
		return getPageTitle();
	}

	public HomePage doLogin(String username,String pass) {
		getEmailId().sendKeys(username);
		getPass().sendKeys(pass);
		getLoginBtn().click();
		
		return getInstance(HomePage.class);
	}
	
	//method overloading
	public HomePage doLogin() {
		getEmailId().sendKeys("");
		getPass().sendKeys("");
		getLoginBtn().click();
		
		return getInstance(HomePage.class);
	}
}