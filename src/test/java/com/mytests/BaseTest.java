package com.mytests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
//import com.beust.jcommander.Parameter;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	public Page page;
	public static Properties prop;
	
	public BaseTest() {
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Selenium_workspace\\OOPConceptInPOM2\\src\\main"
					+ "\\java\\com\\confing\\confing.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	//@Parameters(value= {"browser"})
	public void setUp() {
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			//WebDriverManager.chromiumdriver().setup(); //monigrasia webdrivermanager api
			System.setProperty("webdriver.chrome.driver", "C:\\Seleniumjars\\new chromedriver3\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("FF")) {
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", "C:\\Seleniumjars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.out.println("no browser is defined in the testng.xml");
		}
		
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page = new BasePage(driver); //to give this driver to all pages or supply this driver to all pages 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
