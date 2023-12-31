package base;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import Generics.Config;
import Generics.SeleniumHelper;
import drivers.DriverManager;
import pages.CartsPage;
import pages.CheckoutPage;
import pages.ChromeBrowserPage;
import pages.GoogleMapPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.VtechysPage;

public class BaseTest extends SeleniumHelper {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected BasePage basePage;
	protected ProductsPage productsPage;
	protected CheckoutPage checkoutPage;
	protected CartsPage cartsPage;
	protected ChromeBrowserPage chromeBrowserPage;
	protected VtechysPage vtechysPage;
	protected GoogleMapPage googleMapPage;
	
	
	public void initiatePages() {
		basePage = new BasePage();
		loginPage = new LoginPage(); 
		productsPage = new ProductsPage();
		checkoutPage = new CheckoutPage();
		cartsPage = new CartsPage();
		chromeBrowserPage = new ChromeBrowserPage();
		vtechysPage = new VtechysPage();
		googleMapPage = new GoogleMapPage();
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
//	@BeforeMethod
	public void beforeMethod(String deviceName, String udid) {
		DriverManager.initiateDriver( deviceName,  udid);
		driver = DriverManager.getDriver();
		SeleniumHelper.driver = driver;
		initiatePages();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Quiting driver: " + driver);
		//driver.quit();
	}
	
	@DataProvider
	public Object[][] readData() {
		return readFromExcel();
	}
	
	
}
