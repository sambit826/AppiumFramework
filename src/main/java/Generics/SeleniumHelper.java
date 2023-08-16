package Generics;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Task;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.SupportsNetworkStateManagement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SeleniumHelper extends AutomationHelper {

	public static WebDriver driver;

	public boolean waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(Config.configMap.get("globalWaitTime"))));
		wait.until(ExpectedConditions.visibilityOf(ele));
		return true;
	}
	
	public boolean waitForElement(WebElement ele, int timeInSec) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(timeInSec));
		wait.until(ExpectedConditions.visibilityOf(ele));
		return true;
	}

	public void waitForPage(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}

	public WebElement scrollToAnElementByText(String text) {
		return driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ text + "\").instance(0))"));
	}

	public void toogleFlightMode() {
		sleep(3);
		((SupportsNetworkStateManagement) driver).toggleAirplaneMode();
	}

	public void pressKeyboardKey(AndroidKey key) {
		((AndroidDriver) driver).pressKey(new KeyEvent(key));
	}

	public void scrollTillTime(double timeInMinute) {
		long startTime = System.currentTimeMillis();
        long duration = (long) (timeInMinute * 60 * 1000);
        
        while (System.currentTimeMillis() - startTime < duration) {
            scrollPage();
//        	System.out.println("Scrolling...");
            sleep(5);
        }	
	}
	
	public void scrollInfinitely() {
		while (true) {
			scrollPage();
			System.out.println("Scrolling...");
			sleep(5);
		}
	}
	public void scrollPage() {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
	}
	
	

}
