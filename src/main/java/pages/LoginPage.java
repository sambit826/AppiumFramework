package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage
{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
	private WebElement userName;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
	private WebElement password;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	private WebElement loginBtn;

	public void setUserName(String username) {
		userName.sendKeys(username);
		
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
		
	}
	
	public void clickLogin() {
		loginBtn.click();
		
	}
	

	public void testLoginpage() {
		System.out.println(driver);
	}

}
