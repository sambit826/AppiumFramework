package Generics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;

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
}
