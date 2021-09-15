package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	
	public String getHomepageTitle() {
		return getPageTitle();
	}

	
	
	

}
