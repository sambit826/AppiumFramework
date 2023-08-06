package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class CheckoutPage extends BasePage {

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
	private WebElement firstNameTxtBox;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
	private WebElement lastNameTxtBox;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
	private WebElement zipCodeTxtBox;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]/android.widget.TextView")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[5]")
	private WebElement totalAmoutTxt;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
	private WebElement finishBtn;
	
	@FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
	private WebElement thanksOrderTxtEle;
	
	public void setFirstName(String firstName) {
		waitForElement(firstNameTxtBox);
		firstNameTxtBox.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		waitForElement(lastNameTxtBox);
		lastNameTxtBox.sendKeys(lastName);
	}
	
	public void setZipCode(String zipCode) {
		waitForElement(zipCodeTxtBox);
		zipCodeTxtBox.sendKeys(zipCode);
	}
	
	public void clickContinueBtn()
	{
		continueBtn.click();
	}
	
	public String getTotalAmount() {
		waitForElement(totalAmoutTxt);
		return totalAmoutTxt.getText().trim();
	}
	
	public void clickFinishBtn() {
		waitForElement(totalAmoutTxt);
		scrollToAnElementByText("FINISH").click();
	}
	
	public String getOrderPurchageThanksTxt() {
		waitForElement(thanksOrderTxtEle);
		return thanksOrderTxtEle.getText().trim();
		
	}
	
}
