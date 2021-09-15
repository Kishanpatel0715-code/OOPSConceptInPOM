package com.mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

public class HomePageTest extends BaseTest{

	@Test
	public void verifyHomePageTitleTest() throws InterruptedException {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(2000);
		String title = page.getInstance(HomePage.class).getHomepageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO");
	}
}
