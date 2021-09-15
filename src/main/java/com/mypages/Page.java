package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	
	WebDriver driver;
	WebDriverWait wait;
	
	//create constructor of abstact class is allowed
	public Page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver,15);
	}
	
	//protype methods
	//abstract methods
	public abstract String getPageTitle();

	public abstract String getPageHeader(By Locator);
	
	public abstract WebElement getElement(By Locator);
	
	public abstract void waitforElementPresent(By Locator);
	
	public abstract void waitforPageTitle(String title);
	
	//getInstance method or non-abstract method
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
