package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class SampleAppiumTestcase extends BaseTest{
	
	@Test
	public void completeCheckout() {
		loginPage.loginSwagLabs("standard_user", "secret_sauce");
		productsPage.clickBagPackAddToCart();
		productsPage.clickCartIcon();
		cartsPage.clickCheckoutBtn();
		checkoutPage.setFirstName("Sambit");
		checkoutPage.setLastName("Senapati");
		checkoutPage.setZipCode("543123");
		checkoutPage.clickContinueBtn();
		checkoutPage.clickFinishBtn();
		
		String expectedOrderConfirmationMsg = "THANK YOU FOR YOU ORDER";
		String actualOrderConfirmationMsg = checkoutPage.getOrderPurchageThanksTxt();
		Assert.assertEquals(expectedOrderConfirmationMsg, actualOrderConfirmationMsg);
	}
	
	@Test
	public void verifyAmmount() {
		loginPage.loginSwagLabs("standard_user", "secret_sauce");
		productsPage.clickBagPackAddToCart();
		productsPage.clickCartIcon();
		cartsPage.clickCheckoutBtn();
		checkoutPage.setFirstName("Sambit");
		checkoutPage.setLastName("Senapati");
		checkoutPage.setZipCode("543123");
		checkoutPage.clickContinueBtn();
		
		String expectedAmounttxt = "Item total: $29.99";
		String actualAmountTxt = checkoutPage.getTotalAmount();
		Assert.assertEquals(expectedAmounttxt, actualAmountTxt);
	}
	
}
