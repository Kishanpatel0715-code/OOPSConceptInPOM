package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By Locator) {
		return getElement(Locator).getText();
	}

	@Override //wrapper method + adding concept of exception handling
	public WebElement getElement(By Locator) {
		WebElement element = null;
		try {
			element = driver.findElement(Locator);
			return element;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("some error ocurred while creating element " + Locator.toString());
		}
		
		return element;
	}

	@Override
	public void waitforElementPresent(By Locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("some error ocurred while waiting for elemenet" + Locator.toString());
		}
	}

	@Override
	public void waitforPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("some exception occured while waiting for title" + title);
		}
		
	}

}
