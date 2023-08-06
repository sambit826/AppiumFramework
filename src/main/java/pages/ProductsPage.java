package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class ProductsPage extends BasePage {
	
	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
	private WebElement filterBtn;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
	private WebElement cancelBtnInPopUp;
	
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")
	private WebElement bagPackAddToCart;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
	private WebElement cartIcon;
	public void clickFilterBtn() {
		waitForElement(filterBtn);
		filterBtn.click();
	}
	
	public void clickCancelInPopUp() {
		waitForElement(cancelBtnInPopUp);
		cancelBtnInPopUp.click();
	}
	
	public void clickBagPackAddToCart() {
		waitForElement(bagPackAddToCart);
		bagPackAddToCart.click();
	}
	
	public void clickCartIcon() {
		cartIcon.click();
	}
}

