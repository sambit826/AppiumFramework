package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class VtechysPage extends BasePage{
    public VtechysPage() {
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//android.view.View[@content-desc=\"Vtechys LLC https://vtechys.com Vtechys LLC: Home\"]/android.view.View[2]")
    private WebElement vtechysLink;
    
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.widget.TextView")
    private WebElement menuBtn;
    
    @FindBy(xpath = "//android.view.View[@content-desc=\"Home\"]")
    private WebElement homeBtn;
    
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.widget.TextView")
    private WebElement pageUpBtn;
    
    @FindBy(xpath = "//android.view.View[@content-desc=\"View All Services\"]/android.widget.TextView")
    private WebElement viewAllServiceBtn;
    
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[2]" )
    private WebElement blogbtn;
    
    @FindBy(xpath = "//android.view.View[@content-desc=\"Next →\"]/android.widget.TextView")
    private WebElement nextBtn;
    
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Close Blog - Vtechys LLC - Page 2 tab\"]")
    private WebElement closeVtechysFromRecentTabs;
    
    public void openVtechys() {
    	waitForElement(vtechysLink);
    	vtechysLink.click();
    }
    
    public void clickOnMenuBtn() {
    	waitForElement(menuBtn);
    	menuBtn.click();
    }
    
    public void clickOnHomeBtn() {
    	waitForElement(homeBtn);
    	homeBtn.click();
    }
    
    public void clickPageUpBtn() {
    	waitForElement(pageUpBtn);
    	pageUpBtn.click();
    }
    
    public void clickViewAllservice() {
    	waitForElement(viewAllServiceBtn);
    	viewAllServiceBtn.click();
    }
    
    public void openBlog() {
    	waitForElement(blogbtn);
    	blogbtn.click();
    }
    
    public void clickNext() {
    	waitForElement(nextBtn);
    	nextBtn.click();
    }
    
    public void clearVtechysFromBrowser() {
    	waitForElement(closeVtechysFromRecentTabs);
    	closeVtechysFromRecentTabs.click();
    }
    
    
    
}
