package Generics;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.SupportsNetworkStateManagement;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SeleniumHelper {

	public static WebDriver driver;

	public boolean waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(Config.configMap.get("globalWaitTime"))));
		wait.until(ExpectedConditions.visibilityOf(ele));
		return true;
	}
	public void waitForPage(WebDriver driver) 
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}

	public WebElement scrollToAnElementByText(String text) {
		return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
	}
	public  void enableFlightMode() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((SupportsNetworkStateManagement) driver).toggleAirplaneMode();
		
		
	}
       
	public  void disableFlightMode() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((SupportsNetworkStateManagement) driver).toggleAirplaneMode();
	
	}
	public void openChromeBrowser(WebDriver driver) {
		UiAutomator2Options opitons = new UiAutomator2Options()
		.setPlatformName("Android")
		.setDeviceName("Samsungs")
		.noReset().withBrowserName("chrome");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("https://google.com");
	}
	
}
