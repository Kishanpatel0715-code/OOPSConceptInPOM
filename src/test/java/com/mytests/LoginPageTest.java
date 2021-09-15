package com.mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

public class LoginPageTest extends BaseTest{

	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void verifydoLoginTest() {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String Htitle = homePage.getHomepageTitle();
		System.out.println(Htitle);
		Assert.assertEquals(Htitle, "CRMPRO");
	}
	
	@Test(priority=3)
	public void verifyLoginPageLogo() {
		boolean flag = page.getInstance(LoginPage.class).getCrmLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void verifySignUpBtnTest() {
		boolean flag2 = page.getInstance(LoginPage.class).getSignUpBtn();
		Assert.assertTrue(flag2);
		
	}
	
	@Test(priority=5)
	public void verifyHomeLinkTest() {
		boolean flag3 = page.getInstance(LoginPage.class).getHomeLinkSign();
		Assert.assertTrue(flag3);
	}
}
