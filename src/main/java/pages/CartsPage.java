package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class CartsPage extends BasePage{
	public CartsPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE SHOPPING\"]/android.widget.TextView")
	private WebElement continueShoppingBtn;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
	private WebElement checkoutBtn;
	
	
	public void clickContinueShopptingBtn() {
		waitForElement(continueShoppingBtn);
		continueShoppingBtn.click();
	}
	
	public void clickCheckoutBtn() {
		waitForElement(checkoutBtn);
		checkoutBtn.click();
	}


}
