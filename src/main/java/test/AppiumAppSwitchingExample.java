package test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class AppiumAppSwitchingExample {
	
	public static AppiumDriver originalDriver;
	public static AppiumDriver newDriver;
    public static void main(String[] args) throws InterruptedException {
    	
    	 
        // Set desired capabilities for the original app
        DesiredCapabilities originalAppCaps = new DesiredCapabilities();
        originalAppCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        originalAppCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "SAMSUNG");
        originalAppCaps.setCapability("appPackage", "com.google.android.apps.maps");
        originalAppCaps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
        originalAppCaps.setCapability("automationName", "UiAutomator2");

        // Set desired capabilities for the new app
        DesiredCapabilities newAppCaps = new DesiredCapabilities();
        newAppCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        newAppCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "SAMSUNG");
      //  newAppCaps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        newAppCaps.setCapability(MobileCapabilityType.AUTO_WEBVIEW,"true");
        newAppCaps.setCapability("appPackage", "com.android.chrome");
        newAppCaps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        newAppCaps.setCapability("automationName", "UiAutomator2");


        try {
            // Initialize the driver for the original app
             originalDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), originalAppCaps);
             Thread.sleep(5000);
             originalDriver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Search here\"]/android.widget.TextView")).click();
             Thread.sleep(5000);
           originalDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText"
           		+ "/android.widget.EditText")).sendKeys("abc supply");
           Thread.sleep(5000);
           pressKeyboardKey(AndroidKey.ENTER);
           Thread.sleep(5000);
           
    	    originalDriver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"ABC Supply Co. Inc.\"])[1]\r\n")).click();
    	    Thread.sleep(5000);
    	    originalDriver.findElement(By.xpath("	\r\n"
    	    		+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
    	    		+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup"
    	    		+ "/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout"
    	    		+ "/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout"
    	    		+ "/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout"
    	    		+ "/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]")).click();
    	    Thread.sleep(5000);

    	   
   
            Activity activity = new Activity("appPackage", "appActivity");
            activity.setAppWaitPackage("appPackage");
            activity.setAppWaitActivity("appActivity");
            activity.setStopApp(false);
            ((AndroidDriver) originalDriver).startActivity(activity);
//            ChromeBrowserPage chrome = new ChromeBrowserPage();
//            chrome.openChromeBrowser();


            // Switch to the context of the Chrome browser
            Set<String> contextHandles = ((AndroidDriver)originalDriver).getContextHandles();
            for (String context : contextHandles) {
                if (context.contains("CHROMIUM")) {
                	((AndroidDriver)originalDriver).context(context);
                    break;
                }
            }

            // Perform actions in the new app
            WebElement urlElement = originalDriver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.EditText"));
            String currentURL = urlElement.getText();
            System.out.println(currentURL);

          

            // Quit the driver to close the session
            originalDriver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    
    public static void pressKeyboardKey(AndroidKey key) {
		((AndroidDriver) originalDriver).pressKey(new KeyEvent(key));
	}
    
}

