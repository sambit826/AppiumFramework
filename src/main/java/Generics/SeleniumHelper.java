package Generics;



import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.PointerInput.PointerEventProperties;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.dockerjava.api.model.Task;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.SupportsNetworkStateManagement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.appium.java_client.remote.SupportsLocation;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import pages.GoogleMapPage;
import test.GoogleMapTestCaseTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

public class SeleniumHelper extends AutomationHelper {

	public static WebDriver driver;
	public static WebElement element;
	private final static PointerInput FINGER = new PointerInput(Kind.TOUCH, "finger");
	
   //WebElement = driver.finde
	public boolean waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(Config.configMap.get("globalWaitTime"))));
		wait.until(ExpectedConditions.visibilityOf(ele));
		return true;
	}
	
	public boolean waitForElement(WebElement ele, int timeInSec) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(timeInSec));
		wait.until(ExpectedConditions.visibilityOf(ele));
		return true;
	}

	public void waitForPage(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}

	public WebElement scrollToAnElementByText(String text) {
		return driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ text + "\").instance(0))"));
	}

	public void toogleFlightMode() {
		((SupportsNetworkStateManagement) driver).toggleAirplaneMode();
		sleep(1);
		((SupportsNetworkStateManagement) driver).toggleAirplaneMode();
		sleep(6);
		System.out.println("Network Restarting");
	}

	public void pressKeyboardKey(AndroidKey key) {
		((AndroidDriver) driver).pressKey(new KeyEvent(key));
	}

	public void scrollTillTime(double timeInMinute) {
		long startTime = System.currentTimeMillis();
        long duration = (long) (timeInMinute * 60 * 1000);
        
        while (System.currentTimeMillis() - startTime < duration) {
            scrollPage();
//        	System.out.println("Scrolling...");
            sleep(5);
        }	
	}
	
	public void scrollInfinitely() {
		while (true) {
			scrollPage();
			System.out.println("Scrolling...");
			sleep(5);
		}
	}
	public void scrollPage() {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
	}
	
	//Set location
	public void changeLocation(double latitude, double longitude, double altitude) {
		 try {  
		   Location location = new Location(latitude, longitude, altitude);
           ((SupportsLocation) driver).setLocation(location);
           System.out.println(location);
           System.out.println("Location changed,");
		 }catch(Exception e) {
			 System.out.println("Again changing location");
			 Location location = new Location(latitude, longitude, altitude);
	           ((SupportsLocation) driver).setLocation(location);
	           System.out.println(location);
		 }
           
	   }
	
	 public  void scrollForDurationInSeconds(WebDriver driver, int durationInSeconds) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        long endTimeMillis = System.currentTimeMillis() + (durationInSeconds * 1000); // Convert seconds to milliseconds

	        while (System.currentTimeMillis() < endTimeMillis) {
	            // Scroll down the page
	            js.executeScript("window.scrollBy(0, 500)"); // Adjust the scroll amount as needed
	            try {
	                Thread.sleep(1000); // Wait for 1 second before scrolling again
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	public  void scrollToElement(WebDriver driver, String scrollToText, String scrollToAddress, int maxScrollCount) {
        for (int scrollCount = 0; scrollCount < maxScrollCount; scrollCount++) {
            WebElement element = null;

            if (scrollToText != null) {
                // Scroll by searching for element with text
                element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + scrollToText + "\"))"));
            } else if (scrollToAddress != null) {
                // Scroll by searching for element with content-desc (address)
                element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"" + scrollToAddress + "\"))"));
            }

            if (element != null) {
                // Element found, break out of the loop
                break;
            } else {
                // Scroll further if element not found yet
                int screenHeight = driver.manage().window().getSize().getHeight();
                int scrollStart = (int) (screenHeight * 0.8);
                int scrollEnd = (int) (screenHeight * 0.2);

                TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
                touchAction.press(PointOption.point(0, scrollStart)).moveTo(PointOption.point(0, scrollEnd)).release().perform();
            }
        }
    }
	    public void findShopName(String shopName) {
    	driver.findElement(By.xpath("(//android.widget.TextView[@content-desc='"+shopName+"'])"));
    }
//    public void scrollToShopName(WebDriver driver, String shopName, int maxScrollCount) {
//        int scrollCount = 0;
//        boolean found = false;
//
//        while (scrollCount < maxScrollCount) {
//            // Check if the desired search result is visible
//            WebElement shop = driver.findElement(By.xpath("//android.widget.TextView[@content-desc="+shopName+"]"));
//
//            if (shop.isDisplayed()) {
//            	shop.click();
//                found = true;
//                break; // Exit the loop if the search result is found
//            } else {
//                // Perform a scroll to bring the search result into view
//                int startY = driver.manage().window().getSize().getHeight() / 2;
//                int endY = startY / 2;
//                int centerX = driver.manage().window().getSize().getWidth() / 2;
//
//                TouchAction action = new TouchAction((PerformsTouchActions) driver);
//                action.press(ElementOption.point(centerX, startY))
//                      .waitAction(io.appium.java_client.touch.WaitOptions.waitOptions(Duration.ofMillis(500)))
//                      .moveTo(ElementOption.point(centerX, endY))
//                      .release()
//                      .perform();
//
//                scrollCount++;
//            }
//        }
//
//        if (!found) {
//            System.out.println("Search result not found after scrolling.");
//        }
//        public  void scrollToShopName(WebDriver driver, String shopName, int maxScrollCount) {
//            int scrollCount = 0;
//            boolean found = false;
//
//            while (scrollCount < maxScrollCount) {
//                // Check if the desired element is visible
//                WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@content-desc="+shopName+"]"));
//                System.out.println(element);
//
//                if (element.isDisplayed()) {
//                	element.click();
//                    found = true;
//                    break;
//                } else {
//                    // Scroll down to bring the element into view
//                    int startY = driver.manage().window().getSize().getHeight() / 2;
//                    int endY = (int) (startY * 0.8); // Adjust the scroll distance as needed
//                    int centerX = driver.manage().window().getSize().getWidth() / 2;
//
//                    TouchAction action = new TouchAction((PerformsTouchActions) driver);
//                    action.press(ElementOption.point(centerX, startY))
//                          .waitAction()
//                          .moveTo(ElementOption.point(centerX, endY))
//                          .release()
//                          .perform();
//
//                    scrollCount++;
//                }
//            }
//
//            if (!found) {
//                System.out.println("Element not found after scrolling.");
//            }
//        }
        public void scrollInTouchAction(WebDriver driver) {
        	 int startY = driver.manage().window().getSize().getHeight() / 2;
             int endY = (int) (startY * 0.4); // Adjust the scroll distance as needed
             int centerX = driver.manage().window().getSize().getWidth() / 2;

             TouchAction action = new TouchAction((PerformsTouchActions) driver);
             action.press(ElementOption.point(centerX, startY))
                   .waitAction()
                   .moveTo(ElementOption.point(centerX, endY))
                   .release()
                   .perform();
             System.out.println("Scrolling.....");
        }
        public void scrollInTouchActionToTheTop(WebDriver driver) {
        	int scrollHeight = driver.manage().window().getSize().getHeight();
            int startY = (int) (scrollHeight * 0.2); // 20% from the top
            int endY = (int) (scrollHeight * 0.8); // 80% from the bottom

            TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
            touchAction.press(PointOption.point(0, startY))
                    .waitAction()
                    .moveTo(PointOption.point(0, endY))
                    .release()
                    .perform();
        }
        public void scrollInTouchToTheButtom(WebDriver driver) {
        	int scrollHeight = driver.manage().window().getSize().getHeight();
            int startY = (int) (scrollHeight * 0.8); // 80% from the bottom
            int endY = (int) (scrollHeight * 0.5); // 20% from the top

            TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
            touchAction.press(PointOption.point(0, startY))
                    .waitAction()
                    .moveTo(PointOption.point(0, endY))
                    .release()
                    .perform();
        }
        
        public static void doSwipe(WebDriver driver,int duration, int maxScrollCount) throws Exception {
        	
        	Dimension dimension = driver.manage().window().getSize();
        	Point start = new Point((int)(dimension.width*0.2), (int)(dimension.height*0.2));
        	Point end = new Point((int)(dimension.width*0.5), (int)(dimension.height*0.8)); 
        	
        	
        	
        	
            Sequence swipe = new Sequence(FINGER, 1)
                    .addAction(FINGER.createPointerMove( Duration.ofSeconds(duration), Origin.viewport(), start.getX(), start.getY()))
                    //.addAction(FINGER.createPointerDown(LEFT.asArg()))
                    .addAction(FINGER.createPointerMove(Duration.ofMillis(duration), Origin.viewport(), end.getX(), end.getY()));
                   
            ((RemoteWebDriver) driver).perform(Arrays.asList(swipe));
        }

//		public void moveToShopName(WebDriver driver, String shopName, int maxScrollCount) throws Exception {
//
//			boolean elementFound = false;
//			int currentScrollCount = 0;
//			sleep(1);
//			while (currentScrollCount < maxScrollCount) {
//				// Check if the element is visible
//				if (isElementVisible(driver, shopName)) {
//					sleep(2);
//					element.click();
//					elementFound = true;
//					break;
//				} else {
//					sleep(1);
//					WebElement viewButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\\\"Map view\\\"]"));
//					waitForElement(viewButton);
//					scrollInTouchAction(driver);
//					currentScrollCount++;
//
//				}
//
//			}
//
//			if (!elementFound) {
//				System.out.println("Element not found after scrolling.");
//
//			}
//		}
        	
        
        public  boolean isElementVisible(WebDriver driver, String shopName) {
            // Check if the element with the given text is visible
            try {
                 element = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='"+shopName+"']"));
                System.out.println(element);
                ///sleep(1);
               return element.isDisplayed();     //android.widget.TextView[@content-desc=\"Corporate Video Production\"]
                //return true;
            } catch (Exception e) {
            	
                return false;
            }
            
        }
        public void scrollTillTimeWithTouchAction(double timeInMinute , WebDriver driver) {
    		long startTime = System.currentTimeMillis();
            long duration = (long) (timeInMinute * 60 * 1000);
            
            while (System.currentTimeMillis() - startTime < duration) {
                scrollInTouchAction(driver);
//            	System.out.println("Scrolling...");
                sleep(5);
            }	
    	}
       
//        public void scrollUntilElementVisible(WebDriver driver, String elementText) {
//            boolean elementFound = false;
//            int maxScrollCount = 15; // Set your desired maximum scroll count
//            int currentScrollCount = 0;
//
//            while (!elementFound && currentScrollCount < maxScrollCount) {
//                // Check if the element is visible
//                if (isElementVisible(driver, elementText)) {
//                    elementFound = true;
//                    break;
//                }
//                else {
//                    scrollInTouchAction(driver);
//                    currentScrollCount++;
//
//                }
//
//                // Scroll down to bring more elements into view
//
//                // Increment the scroll count
//            }
//
//            if (!elementFound) {
//                System.out.println("Element not found after scrolling.");
//            }
//        }
        public void switchToViewPage() {
        	//WebDriver driver = ((SupportsContextSwitching) driver);
        	 String originalContext = ((SupportsContextSwitching) driver).getContext();

             // Switch to the Chrome browser app
             Set<String> contextHandles = ((SupportsContextSwitching) driver).getContextHandles();
             for (String contextHandle : contextHandles) {
                 if (contextHandle.contains("WEBVIEW")) {
                     ((SupportsContextSwitching) driver).context(contextHandle);
                     break;
                 }
             }
             ((SupportsContextSwitching) driver).context(originalContext);
        }
        public void scrollInTime(int durationInSeconds) {
            Duration duration = Duration.ofSeconds(durationInSeconds);
            Dimension size = driver.manage().window().getSize();

            int startX = size.width / 2;
            int startY = (int) (size.height * 0.4); // 80% from the bottom
            int endY = (int) (size.height * 0.2); // 20% from the top

            TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
                   touchAction.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(duration))
                    .moveTo(PointOption.point(startX, endY))
                    .release();
            
            touchAction.perform();
        }
//        public void scrollForTime(int durationInSecconds) {
//        	Duration duration = Duration.ofSeconds(durationInSecconds);
//        	 int startY = driver.manage().window().getSize().getHeight() / 2;
//             int endY = (int) (startY * 0.4); // Adjust the scroll distance as needed
//             int centerX = driver.manage().window().getSize().getWidth() / 2;
//
//             TouchAction action = new TouchAction((PerformsTouchActions) driver);
//             action.press(ElementOption.point(centerX, startY))
//                   .waitAction(WaitOptions.waitOptions(duration))
//                   .moveTo(ElementOption.point(centerX, endY))
//                   .release()
//                   .perform();
//        }
        public void scrollForTime (int durationInSeconds) {
        	 long startTime = System.currentTimeMillis();
        	    long endTime =  (startTime + (durationInSeconds * 1000)); // Convert seconds to milliseconds

        	    while (System.currentTimeMillis() < endTime) {
        	        // Scroll to the end
        	    	scrollPage();
//        	        driver.findElement(AppiumBy
//        	                .androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));

        	        // You can adjust the sleep time if needed to control scrolling speed
        	        try {
        	            Thread.sleep(1000); // Sleep for 1 second (adjust as needed)
        	        } catch (InterruptedException e) {
        	            Thread.currentThread().interrupt();
        	        }
        	      }
        	    }
        	    public void scrollForTimeInTouchAction(WebDriver driver,int durationInSeconds) {
        	    	WebElement pageNotFoundLink = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.TextView"));
        	       
        	    	 try {
        	    		    if(!pageNotFoundLink.isDisplayed()) {
        	    		    	long startTime = System.currentTimeMillis();
        	    	 	        long endTime =  (startTime + (durationInSeconds * 1000));
        	    	 	          while (System.currentTimeMillis() < endTime) {
        	    	 	    	   sleep(2);
        	    	 	    	     scrollInTouchAction(driver);
        	    	 	    }
        	    		    	}
        	    			 }catch(Exception e) {
        	    				 
        	    			 }
        	    	 	        }
}
            	        
        




