package pages;

import java.security.PublicKey;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.host.media.rtc.webkitRTCPeerConnection;

import Generics.AutomationHelper;
import base.BasePage;
import base.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ChromeBrowserPage extends BasePage {
	public ChromeBrowserPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button")
	private WebElement acceptAndContinueBtn;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]")
	private WebElement noThanksBtn;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.Button[1]")
	private WebElement noThanksNotificationBtn;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.ListView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]")
	private WebElement continueAsSambitBtn;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.ListView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")
	private WebElement yesIamInBtn;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.Button[2]")
	private WebElement continueBtn;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
	private WebElement allowBtn;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement searchBar;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ListView/android.view.View[1]")
	private WebElement redditSearchTab;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.Button")
	private WebElement continueChrome;

	@FindBy(xpath = "//android.view.View[@content-desc='Home']/android.widget.Image")
	private WebElement redditHomeBtn;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
	private WebElement translationPopupCloseBtn;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Google Account, Sambit Senapati's profile picture, ssenapati826@gmail.com, Sambit Senapati\"]/android.widget.TextView")
	private WebElement selectUserAccountBtn;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.app.Dialog/android.view.View[2]/android.widget.Button")
	private WebElement continueAsAccountBtn;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Switch or close tabs\"]")
	private WebElement recentTabsBtn;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.Button")
	private WebElement closeAllAppsBtn;
  
	public void openChromeBrowser() {
		try {
			if (continueAsSambitBtn.isDisplayed()) {
				continueAsSambitBtn.click();
			}
//			waitForElement(continueAsSambitBtn, 5);
		} catch (NoSuchElementException t) {
//			System.out.println("Close Pop up did not appear till 5 secs");
		}
		waitForElement(acceptAndContinueBtn);
		acceptAndContinueBtn.click();

		waitForElement(noThanksBtn);
		noThanksBtn.click();
		waitForElement(noThanksNotificationBtn);
		noThanksNotificationBtn.click();
	}
	
	public void searchInBrowser(String keys) {
		waitForElement(searchBar);
		searchBar.sendKeys(keys);
		pressKeyboardKey(AndroidKey.ENTER);
	}
	
	public void openRedditUsingChrome() {
//	  waitForElement(continueAsSambitBtn);
//	  continueAsSambitBtn.click();
		waitForElement(acceptAndContinueBtn);
		acceptAndContinueBtn.click();

		waitForElement(noThanksBtn);
		noThanksBtn.click();
		waitForElement(noThanksNotificationBtn);
		noThanksNotificationBtn.click();
	
   		
		
		waitForElement(searchBar);
		searchBar.sendKeys("reddit.com");
		pressKeyboardKey(AndroidKey.ENTER);
	
		
		
//		waitForElement(yesIamInBtn);
//		yesIamInBtn.click();
//		waitForElement(continueBtn);
//		continueBtn.click();
//		waitForElement(allowBtn);
//		allowBtn.click();

	  
	  
	  waitForElement(continueChrome);
	  clickTranslatePopupCloseBtn();
	  continueChrome.click();	
	}
	
	public void scrollPageTillTimeInMinutes(double d) {
		scrollTillTime(d);
	}

	public void clickAnyLinkInRedditPage() {
		waitForElement(redditHomeBtn);
		redditHomeBtn.click();
	}

	public void clickTranslatePopupCloseBtn() {
		try {
			if (translationPopupCloseBtn.isDisplayed()) {
				translationPopupCloseBtn.click();
			}
//			waitForElement(translationPopupCloseBtn, 5);
		} catch (NoSuchElementException t) {
//			System.out.println("Close Pop up did not appear till 5 secs");
		}
	}

	public void selectUserAccount() {
		waitForElement(selectUserAccountBtn);
		selectUserAccountBtn.click();
		waitForElement(continueAsAccountBtn);
		continueAsAccountBtn.click();
	}
	
	public void openRecentTabsBrowser() {
		waitForElement(recentTabsBtn);
		recentTabsBtn.click();
	}

	public void closeAllApps() {
		pressKeyboardKey(AndroidKey.APP_SWITCH);
		waitForElement(closeAllAppsBtn);
		closeAllAppsBtn.click();
	}
}
