package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Generics.Config;
import Generics.SeleniumHelper;
import drivers.DriverManager;
import pages.CartsPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class BaseTest {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected BasePage basePage;
	protected ProductsPage productsPage;
	protected CheckoutPage checkoutPage;
	protected CartsPage cartsPage;
	protected SeleniumHelper seleniumHelper;
	
	public void initiatePages() {
		basePage = new BasePage();
		loginPage = new LoginPage(); 
		productsPage = new ProductsPage();
		checkoutPage = new CheckoutPage();
		cartsPage = new CartsPage();
		seleniumHelper = new SeleniumHelper();
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
		SeleniumHelper.driver = driver;
		initiatePages();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Quiting driver: " + driver);
		driver.quit();
	}

}
