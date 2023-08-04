package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Generics.Config;
import drivers.DriverManager;
import pages.LoginPage;

public class BaseTest {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected BasePage basePage;
	
	public void initiatePages() {
		loginPage = new LoginPage(); 
		basePage = new BasePage();
	}
	
	@BeforeTest
	public void beforeTest() {
		Config c  = new Config();
		c.loadConfig();
	}
	@BeforeSuite
	public void beforeSuite() {

	}
	
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		DriverManager.initiateDriver();
		driver = DriverManager.getDriver();
		BasePage.driver = driver;
		initiatePages();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Quiting driver: " + driver);
		driver.quit();
	}

}
