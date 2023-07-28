package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Generics.Config;
import drivers.DriverManager;

public class BaseTest {
	protected WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		Config c  = new Config();
		c.loadConfig();
	}
	@BeforeSuite
	public void beforeSuite() {}
	
	@BeforeClass
	public void beforeClass() {}
	
	@BeforeMethod
	public void beforeMethod() {
		DriverManager.initiateDriver();
		driver = DriverManager.getDriver();
		
	}

}
