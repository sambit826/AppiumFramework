package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import io.appium.java_client.android.SupportsNetworkStateManagement;
import io.appium.java_client.android.nativekey.AndroidKey;

public class GoogleMapPage extends BasePage {
	
	public GoogleMapPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button")
	private WebElement skipbutton;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
    private WebElement signBtn;
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"Search here\"]/android.widget.TextView")
	private WebElement textBox;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText/android.widget.EditText")
	private WebElement searchBox;
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Back\"]/android.widget.ImageView")
	private WebElement leftArrow;
	@FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Website: https://www.willenslaw.com/\"]")
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
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Map view\"]")
	private WebElement viewmap;
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Close\"]")
	private WebElement close;
	@FindBy(xpath = "//android.widget.CompoundButton[@content-desc=\"Relevance\"]")
	private WebElement sortOption;
	@FindBy(xpath = "//android.widget.CheckBox[@content-desc=\"Distance\"]")
	private WebElement distanceBtn;
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Back\"]/android.widget.ImageView")
	private WebElement backArrow;
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Enter compass mode\"]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.ImageView")
	private WebElement compassBtn;
	@FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]")
	private WebElement recentSearch;
	@FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
	private WebElement notWorkingInternetMsg;
	@FindBy (xpath = "//android.widget.Button[@content-desc=\"Close\"]")
	private WebElement closePopup;
	@FindBy (xpath = "//android.widget.Button[@content-desc=\"NOT\"]")
	private WebElement falseElement;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[5]/android.widget.ScrollView")
	private WebElement mapview;
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Voice search\"]")
	private WebElement voicesearch;
	//WebElement
	
	public void clickOnSearchBoxSendText(String text) {
	try {	
	  if(signBtn.isDisplayed()) {
		waitForElement(signBtn);
		//skipbutton.click();
		tap(417, 66);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		waitForElement(compassBtn);
//		compassBtn.click();
//		sleep(2);
		waitForElement(textBox);
	    textBox.click();
	    waitForElement(searchBox);
		searchBox.sendKeys(text);
		sleep(1);
		pressKeyboardKey(AndroidKey.ENTER);
//		waitForElement(compassBtn);
//		compassBtn.click();
//		sleep(2);
	
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(closePopup.isDisplayed()) {
				waitForElement(closePopup);
				closePopup.click();
				System.out.println("Pop up is closed_1");
				//sleep(1);
				toogleFlightMode();
				//sleep(1);
				toogleFlightMode();
				//sleep(4);
				waitForElement(textBox);
				textBox.click();
				sleep(1);
				pressKeyboardKey(AndroidKey.ENTER);
			  //pressKeyboardKey(AndroidKey.ENTER);
			}

		}catch(Exception e) {
			System.out.println("Pop up not display___1");
			//sleep(5);
		}
		//pressKeyboardKey(AndroidKey.SEARCH);
		System.out.println("searching done");
	  }
	  else if (textBox.isDisplayed()) {
		  waitForElement(compassBtn);
		  compassBtn.click();
		  waitForElement(textBox);
		    textBox.click();
		    waitForElement(searchBox);
			searchBox.sendKeys(text);
			sleep(1);
			pressKeyboardKey(AndroidKey.ENTER);
			
	  }
	} catch (NoSuchElementException t) {
        // Handle the exception if the elements are not found
        // For example, you can print an error message or log it
//		waitForElement(compassBtn);
//		compassBtn.click();
		waitForElement(textBox);
	    textBox.click();
	    waitForElement(searchBox);
		searchBox.sendKeys(text);
		sleep(1);
		pressKeyboardKey(AndroidKey.ENTER);
		
		System.out.println("Not searching in se");
    }
//	    waitForElement(textBox);
//	    textBox.click();
//	    waitForElement(searchBox);
//		searchBox.sendKeys(text);
//		pressKeyboardKey(AndroidKey.ENTER);
//		sleep(2);
	  
	  
	}
	public void toogleFlightMode() {
		sleep(1);
		((SupportsNetworkStateManagement) driver).toggleAirplaneMode();
		sleep(1);
		((SupportsNetworkStateManagement) driver).toggleAirplaneMode();
		sleep(7);
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
	public void chnageToDistance() {
     try {
	  if(sortOption.isDisplayed()) {
		waitForElement(sortOption);
		sortOption.click();
		waitForElement(distanceBtn);
		distanceBtn.click();
		System.out.println("Sort option changed to Distance");
	  }
     }catch(Exception e) {
    	 System.out.println("Sort option not displayed");
     }
	}
	public void clickOnShopUrl() {
		boolean elementFound = false;
		try{
		  if(shopUrlIsVisible()) {
			//waitForPage(driver);
			// sleep(1);
			waitForElement(shopUrl);
			shopUrl.click();
			try {
				 if(signBtn.isDisplayed()) {
					 sleep(2);
					 pressKeyboardKey(AndroidKey.BACK);
			      System.out.println(shopUrl);
			      waitForElement(shopUrl);
			      shopUrl.click();
				 }}catch (Exception e) {
					// TODO: handle exception
					 System.out.println("not displayed signIn button");
				}
			elementFound = true;
			
		  }
		  else {
			  //sleep(1);
			  scrollInTouchToTheButtom(driver);
			  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  waitForElement(shopUrl);
		      shopUrl.click();
		      try {
					 if(signBtn.isDisplayed()) {
						 sleep(2);
						 pressKeyboardKey(AndroidKey.BACK);
				      System.out.println(shopUrl);
				      waitForElement(shopUrl);
				      shopUrl.click();
					 }}catch (Exception e) {
						// TODO: handle exception
						 System.out.println("not displayed signIn button");
					}
		      System.out.println(shopUrl);
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
    public void checkInternetIsWorking() {
    	   while(!viewIsVisible()) {
          	
      		toogleFlightMode();
      		sleep(1);
      		toogleFlightMode();
      		sleep(2);
      		System.out.println("Network Restarting");
      	try{
      	  if(close.isDisplayed()) {
      		waitForElement(close);
      		close.click();
      		sleep(1);
            }
      	}
      	catch(Exception e) {
      		
      	}
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
		try {
			waitForElement(falseElement);
			falseElement.click();
		}catch(Exception e) {
			System.out.println("Element not found");
			waitForElement(urlSearchBox);
			urlSearchBox.click();
			waitForElement(webAddressBox);
			webAddressBox.sendKeys(text);
			sleep(1);
			pressKeyboardKey(AndroidKey.ENTER);
		}
		
	}
	public boolean shopUrlIsVisible() {
	 try {
		element = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Website: https://www.willenslaw.com/\"]"));
		 System.out.println(element);
         sleep(1);
        return element.isDisplayed();     //android.widget.TextView[@content-desc=\"Corporate Video Production\"]
         //return true;
     } catch (Exception e) {
     	
         return false;
     }
	
     
 }
	public boolean viewIsVisible() {
	  try {
		  sleep(1);
		  return viewmap.isDisplayed();
	  }
	  catch(Exception e) {
		  return false;
	  }
	}
	public void moveToShopName(WebDriver driver, String shopName, int maxScrollCount) throws Exception {
		//sleep(3);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(closePopup.isDisplayed()) {
				waitForElement(closePopup);
				closePopup.click();
				System.out.println("Pop up is closed--2");
				//sleep(1);
				toogleFlightMode();
				//sleep(1);
				toogleFlightMode();
				//sleep(4);
				waitForElement(textBox);
				textBox.click();
				pressKeyboardKey(AndroidKey.ENTER);
				sleep(1);
				pressKeyboardKey(AndroidKey.ENTER);
			}

		}catch(Exception e) {
			System.out.println("Pop up not display_______2");
			//sleep(4);
		}
        sleep(1);
		boolean elementFound = false;
		int currentScrollCount = 0;
		sleep(1);
		while (currentScrollCount < maxScrollCount) {
			// Check if the element is visible
			if (isElementVisible(driver, shopName)) {
				sleep(1);
				element.click();
				elementFound = true;
				 System.out.println("Shop Name Found- "+shopName);
				break;
			} else {
				//bElement viewButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\\\"Map view\\\"]"));
				//sleep(2);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					if(closePopup.isDisplayed()) {
						waitForElement(closePopup);
						closePopup.click();
						System.out.println("Pop up is closed__3");
						//sleep(1);
						toogleFlightMode();
						//sleep(1);
						toogleFlightMode();
						//sleep(1);
						waitForElement(textBox);
						textBox.click();
						pressKeyboardKey(AndroidKey.ENTER);
						sleep(1);
						pressKeyboardKey(AndroidKey.ENTER);
					}

				}catch(Exception e) {
					System.out.println("..........................");
					//sleep(2);
					try {
						if(closePopup.isDisplayed()) {
							waitForElement(closePopup);
							closePopup.click();
							System.out.println("Pop up is closed__4");
					
							toogleFlightMode();
							//sleep(1);
							toogleFlightMode();
							//sleep(2);
							waitForElement(textBox);
							textBox.click();
							sleep(1);
							pressKeyboardKey(AndroidKey.ENTER);
							sleep(1);
							pressKeyboardKey(AndroidKey.ENTER);
						}

					}catch(Exception m) {
						System.out.println("..........................2");
						try {
							if(closePopup.isDisplayed()) {
								waitForElement(closePopup);
								closePopup.click();
								System.out.println("Pop up is closed--5");
								sleep(1);
								toogleFlightMode();
								//sleep(1);
								toogleFlightMode();
								//sleep(1);
								waitForElement(textBox);
								textBox.click();
								sleep(1);
								pressKeyboardKey(AndroidKey.ENTER);
								sleep(1);
								pressKeyboardKey(AndroidKey.ENTER);
								
							}

						}catch(Exception f) {
							System.out.println("..........................3");
						}
					}
				}
//				String maptext = mapview.getText();
//				System.out.println(maptext);
				waitForElement(viewmap);
				scrollInTouchAction(driver);
				//sleep(2);
				currentScrollCount++;

			}

		}

		if (!elementFound) {
			try {
			System.out.println("Shopname-" +shopName+ " - Again trying to search the shopname.");
			waitForElement(backArrow);
			backArrow.click();
			waitForElement(backArrow);
			backArrow.click();
			//waitForElement(voicesearch);
			//compassBtn.click();
			sleep(2);
			tap(424, 642);
			waitForElement(textBox);
			textBox.click();
			waitForElement(recentSearch);
			recentSearch.click();
			 elementFound = false;
			 currentScrollCount = 0;
			sleep(1);
			while (currentScrollCount < maxScrollCount) {
				// Check if the element is visible
				if (isElementVisible(driver, shopName)) {
					sleep(1);
					element.click();
					elementFound = true;
					 System.out.println("Shop Name Found- "+shopName);
					break;
				} else {
					//bElement viewButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\\\"Map view\\\"]"));
					waitForElement(viewmap);
					scrollInTouchAction(driver);
					sleep(1);
					currentScrollCount++;

				}

			}
			}catch(Exception e) {
				System.out.println("catch block exicuted");
				System.out.println("Again 2nd time to find");
				System.out.println("Shopname-" +shopName+ " - Again 2nd time trying to search the shopname.");
				waitForElement(backArrow);
				backArrow.click();
				waitForElement(backArrow);
				backArrow.click();
				//waitForElement(voicesearch);
				//compassBtn.click();
				sleep(2);
				tap(424, 642);
				waitForElement(textBox);
				textBox.click();
				waitForElement(recentSearch);
				recentSearch.click();
				 elementFound = false;
				 currentScrollCount = 0;
				sleep(1);
				while (currentScrollCount < maxScrollCount) {
					// Check if the element is visible
					if (isElementVisible(driver, shopName)) {
						sleep(1);
						element.click();
						elementFound = true;
						 System.out.println("Shop Name Found- "+shopName);
						break;
					} else {
						//bElement viewButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\\\"Map view\\\"]"));
						waitForElement(viewmap);
						scrollInTouchAction(driver);
						sleep(1);
						currentScrollCount++;

					}

				}

				}
			}

		}
	}
	
	
	
	


