package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.Connection;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generics.SeleniumHelper;
import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.SupportsNetworkStateManagement;

public class SampleAppiumTestcase extends BaseTest{
//	SeleniumHelper help = new SeleniumHelper();
	
//	@Test
//	public void completeCheckout() {
//		loginPage.loginSwagLabs("standard_user", "secret_sauce");
//		productsPage.clickBagPackAddToCart();
//		productsPage.clickCartIcon();
//		cartsPage.clickCheckoutBtn();
//		checkoutPage.setFirstName("Sambit");
//		checkoutPage.setLastName("Senapati");
//		toogleFlightMode();
//		checkoutPage.setZipCode("543123");
//		toogleFlightMode();
//		checkoutPage.clickContinueBtn();
//		checkoutPage.clickFinishBtn();
//		String expectedOrderConfirmationMsg = "THANK YOU FOR YOU ORDER";
//		String actualOrderConfirmationMsg = checkoutPage.getOrderPurchageThanksTxt();
//		Assert.assertEquals(expectedOrderConfirmationMsg, actualOrderConfirmationMsg);
//	}
//	
//	@Test
//	public void verifyAmmount() {
//		loginPage.loginSwagLabs("standard_user", "secret_sauce");
//		productsPage.clickBagPackAddToCart();
//		productsPage.clickCartIcon();
//		cartsPage.clickCheckoutBtn();
//		checkoutPage.setFirstName("Sambit");
//		checkoutPage.setLastName("Senapati");
//		checkoutPage.setZipCode("543123");
//		checkoutPage.clickContinueBtn();
//		String expectedAmounttxt = "Item total: $29.99";
//		String actualAmountTxt = checkoutPage.getTotalAmount();
//		Assert.assertEquals(expectedAmounttxt, actualAmountTxt);
//	}
//	@Test
//	public void chromeBrowser() {
//		driver.get("http://www.google.com");
//	}
	
  
}
