package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generics.SeleniumHelper;
import base.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage
{
	
	public LoginPage() {
//		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
	private WebElement userName;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
	private WebElement password;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-biometry\"]")
	private WebElement testBiometryBtn;
	

	public void setUserName(String username) {
//		waitForPage(driver);
		waitForElement(userName);
		userName.sendKeys(username);
		
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
		
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void loginSwagLabs(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		clickLogin();
	}

	public void testLoginpage() {
		System.out.println(driver);
	}
	
	public void clickBiometryBtn() {
		waitForElement(testBiometryBtn);
		testBiometryBtn.click();
		
	}

}
