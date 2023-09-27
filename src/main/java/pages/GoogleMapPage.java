package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import io.appium.java_client.android.nativekey.AndroidKey;

public class GoogleMapPage extends BasePage {
	
	public GoogleMapPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//android.widget.EditText[@content-desc='Search here']/android.widget.TextView")
	private WebElement textBox;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText/android.widget.EditText")
	private WebElement searchBox;
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Back\"]/android.widget.ImageView")
	private WebElement leftArrow;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]")
	private WebElement shopUrl;
	@FindBy(xpath = "//android.view.View[@content-desc=\"Get an Estimate\"]/android.widget.TextView")
	private WebElement estimateBtn;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button")
	private WebElement menuBtn;
	@FindBy(xpath = "(//android.view.View[@content-desc=\"Web & TV Series Video Production\"])[1]/android.widget.TextView")
	private WebElement webTvSeriesVdoProductionLink;
	@FindBy(xpath = "//android.view.View[@content-desc=\"Corporate Video Production in New York\"]/android.widget.Image")
	private WebElement homeBtn;
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Maps\"]/android.view.View")
	private WebElement previousRecentTask;
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Search\"]/android.widget.ImageView")
	private WebElement searchBtn;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.EditText")
	private WebElement urlSearchBox;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.EditText")
	private WebElement webAddressBox;
	//WebElement
	
	public void clickOnSearchBoxSendText(String text) {
		waitForElement(textBox);
	    textBox.click();
	    waitForElement(searchBox);
		searchBox.sendKeys(text);
		pressKeyboardKey(AndroidKey.ENTER);
		sleep(2);
	}
	public void sendTextToTheSearchBox(String text) {
		System.out.println(".................searchBox");
		waitForElement(searchBox);
		searchBox.sendKeys(text);
		pressKeyboardKey(AndroidKey.ENTER);
	}
	
	public void sendingTextToSearchBox(String text) {
	    try {
	        if (textBox.isDisplayed()) {
	            clickOnSearchBoxSendText(text);
	        }
	        
	        else if (searchBox.isDisplayed()) {
	           sendTextToTheSearchBox(text);
	        }
	    } catch (NoSuchElementException t) {
	        // Handle the exception if the elements are not found
	        // For example, you can print an error message or log it
	    }
	}
	public void clickOnLeftArrow() {
		waitForElement(leftArrow);
		leftArrow.click();
	}
	public void clickOnShopUrl() {
		boolean elementFound = false;
		try{
		  if(shopUrlIsVisible()) {
			//waitForPage(driver);
			 sleep(1);
			waitForElement(shopUrl);
			shopUrl.click();
			elementFound = true;
			
		  }
		  else {
			  sleep(1);
			  scrollInTouchToTheButtom(driver);
			  System.out.println(shopUrl);
			  waitForElement(shopUrl);
		      shopUrl.click();
		  }
		}catch(NoSuchElementException e) {
			System.out.println("2 Element is not found.");
		}
		
	}
	public void clickOnEstimate() {
		waitForElement(estimateBtn);
		estimateBtn.click();
	}
	public void clickOnMenuBtn() {
		waitForElement(menuBtn);
		menuBtn.click();
	}
	public void moveToEstimateBtnAndClick() {
		try {
			moveToShopName(driver,"Get an Estimate", 20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void clickWebTvSeriesVdoProductionLink() {
		waitForElement(webTvSeriesVdoProductionLink);
		webTvSeriesVdoProductionLink.click();
	}
	public void clickOnHomeBtn() {
		waitForElement(homeBtn);
		homeBtn.click();
	}
	public void backToPreviousRecentTask() {
		pressKeyboardKey(AndroidKey.APP_SWITCH);
		waitForElement(previousRecentTask);
		previousRecentTask.click();
	}
	public void clickOnSearchBtn() {
		waitForElement(searchBtn);
		searchBtn.click();
		//searchBox.sendKeys("Fence Contractor");
	}
	public void sendTextToUrlSearchBox(String text) {
		waitForElement(urlSearchBox);
		urlSearchBox.click();
		waitForElement(webAddressBox);
		webAddressBox.sendKeys(text);
		pressKeyboardKey(AndroidKey.ENTER);
		
	}
	public boolean shopUrlIsVisible() {
	 try {
		element = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]"));
		 System.out.println(element);
         sleep(1);
        return element.isDisplayed();     //android.widget.TextView[@content-desc=\"Corporate Video Production\"]
         //return true;
     } catch (Exception e) {
     	
         return false;
     }
     
 }
	
	
	
	

}
